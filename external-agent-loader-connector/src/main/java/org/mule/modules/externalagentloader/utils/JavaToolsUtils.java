package org.mule.modules.externalagentloader.utils;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.mule.modules.externalagentloader.config.ConnectorConfig;
import org.mule.modules.externalagentloader.config.JVMTIAgentConfig;
import org.mule.modules.externalagentloader.config.JavaAgentConfig;
import org.mule.registry.MuleContextProcessor;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.VirtualMachine;

public class JavaToolsUtils {

	private static Logger log = Logger.getGlobal();
    private static boolean started;

    static {
        try {
        		log.log(Level.INFO, "Loading tools.jar...");
            String javaHome = System.getProperty("java.home");
            String toolsJarURL = "file:" + javaHome + "/../lib/tools.jar";

            // Make addURL public
            Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            method.setAccessible(true);

            URLClassLoader sysloader = (URLClassLoader)ClassLoader.getSystemClassLoader();
            if (sysloader.getResourceAsStream("/com/sun/tools/attach/VirtualMachine.class") == null) {
                method.invoke(sysloader, (Object) new URL(toolsJarURL));
                Thread.currentThread().getContextClassLoader().loadClass("com.sun.tools.attach.VirtualMachine");
                Thread.currentThread().getContextClassLoader().loadClass("com.sun.tools.attach.AttachNotSupportedException");
            }
            log.log(Level.INFO, "Loaded tools.jar.");

        } catch (Exception e) {
            log.log(Level.WARNING, "Java home points to " + System.getProperty("java.home") + " make sure it is not a JRE path");
            log.log(Level.WARNING, e.getMessage(), e);
        }
        started = true;
    };

    public static boolean ensureToolsJar() {
        if (!started) {
        		log.severe("Attach API not initialized");
        }
        return started;
    }   

    public static void loadAgent(ConnectorConfig config) {
    		String nameOfRunningVM = ManagementFactory.getRuntimeMXBean().getName();
        String pid = nameOfRunningVM.substring(0, nameOfRunningVM.indexOf('@'));
        
        if (!ensureToolsJar()) return;
        
        String agent = null;
        
        try
        {
	        VirtualMachine vm = VirtualMachine.attach(pid);
	        // get system properties in target VM
	        Properties props = vm.getSystemProperties();
	        
	        // construct path to management agent
	        File agentDir = new File(props.getProperty("mule.home") + File.separator + 
	        			"apps" + File.separator +
	        			config.getApplicationName() + File.separator +
	        			"plugins" + File.separator +
	        			"lib");
	        
	        for (File file : agentDir.listFiles()) {
	        		try 
	        		{
        			
	        			if (config instanceof JavaAgentConfig && file.getName().contains("agent")) {
	        				log.log(Level.INFO, "Attempting to load agent: " + file.getPath());
	        				vm.loadAgent(file.getPath(), config.getAgentOptions());
		        			vm.detach();
				        log.log(Level.INFO, "Loaded agent: " + file.getPath());
				        break;
		        		} else if (config instanceof JVMTIAgentConfig && (file.getName().endsWith(".so") || file.getName().endsWith(".dll"))) {
		        			log.log(Level.INFO, "Attempting to load agent: " + file.getPath());
	        				vm.loadAgentPath(file.getPath(), config.getAgentOptions());
		        			vm.detach();
				        log.log(Level.INFO, "Loaded agent: " + file.getPath());
				        break;
		        		}
	        		}
		        	catch(Exception e) {	
		            		log.log(Level.WARNING, "File: " + agent + " exists=" + file.exists() + " and canread=" + file.canRead());
		            		log.log(Level.WARNING, e.getMessage(), e);
	        		}
	        }
        }
        catch (Exception e) {
        		log.log(Level.WARNING, e.getMessage(), e);
        }
    }
}
