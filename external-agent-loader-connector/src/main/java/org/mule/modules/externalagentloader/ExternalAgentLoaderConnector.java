package org.mule.modules.externalagentloader;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;

import org.mule.modules.externalagentloader.config.ConnectorConfig;
import org.mule.modules.externalagentloader.utils.JavaToolsUtils;

@Connector(name="external-agent-loader", friendlyName="ExternalAgentLoader")
public class ExternalAgentLoaderConnector {

	@Config
    ConnectorConfig config;

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
        
        //JavaToolsUtils.loadAgentJar(config.getAgentJar(), config.getAgentOptions());
        JavaToolsUtils.loadAgentJars(config);
    }

    /**
     * Custom processor
     *
     */
    @Processor
    public void noOp() {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
    }
}