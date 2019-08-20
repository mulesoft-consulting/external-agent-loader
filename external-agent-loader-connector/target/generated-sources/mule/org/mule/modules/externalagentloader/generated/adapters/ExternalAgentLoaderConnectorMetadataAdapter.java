
package org.mule.modules.externalagentloader.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MetadataAware;
import org.mule.modules.externalagentloader.ExternalAgentLoaderConnector;


/**
 * A <code>ExternalAgentLoaderConnectorMetadataAdapter</code> is a wrapper around {@link ExternalAgentLoaderConnector } that adds support for querying metadata about the extension.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.4", date = "2019-08-18T04:59:09-05:00", comments = "Build UNNAMED.2810.4347dd1")
public class ExternalAgentLoaderConnectorMetadataAdapter
    extends ExternalAgentLoaderConnectorCapabilitiesAdapter
    implements MetadataAware
{

    private final static String MODULE_NAME = "ExternalAgentLoader";
    private final static String MODULE_VERSION = "1.0.0-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.9.4";
    private final static String DEVKIT_BUILD = "UNNAMED.2810.4347dd1";
    private final static String MIN_MULE_VERSION = "3.5.0";

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

    public String getMinMuleVersion() {
        return MIN_MULE_VERSION;
    }

}
