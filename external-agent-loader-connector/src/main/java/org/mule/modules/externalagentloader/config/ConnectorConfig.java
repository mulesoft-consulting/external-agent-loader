package org.mule.modules.externalagentloader.config;

import org.mule.api.annotations.components.Configuration;

import java.io.File;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

@Configuration(friendlyName = "Configuration", configElementName="config")
public class ConnectorConfig {

    /**
     * Relative path to the agent jar file
    @Configurable
    private String agentJar;
     */
    
    /**
     * Optional: agent startup parameters
     */
	@Configurable
    private String applicationName;
	
    @Configurable
    @Optional
    private String agentOptions;
    
    /*
	public String getAgentJar() {
		return agentJar;
	}

	public void setAgentJar(String agentJar) {
		this.agentJar = agentJar;
	}
	*/
    
	public String getAgentOptions() {
		return agentOptions;
	}

	public void setAgentOptions(String agentOptions) {
		this.agentOptions = agentOptions;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
}