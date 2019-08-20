package org.mule.sample.javaagent;

import java.lang.instrument.Instrumentation;
import java.util.logging.Logger;

public class DemoAgent {

	public static void premain(String args, Instrumentation inst) {
		Logger log = Logger.getGlobal();
		
		log.info("Premain Demo Agent started with " + args);
	}
	
	public static void agentmain(String args, Instrumentation inst) {
		Logger log = Logger.getGlobal();
		
		log.info("Agent Main Demo Agent started with " + args);
	}
}
