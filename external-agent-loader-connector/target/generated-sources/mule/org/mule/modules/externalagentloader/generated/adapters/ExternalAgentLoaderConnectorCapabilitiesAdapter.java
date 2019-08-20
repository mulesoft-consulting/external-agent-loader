
package org.mule.modules.externalagentloader.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.modules.externalagentloader.ExternalAgentLoaderConnector;


/**
 * A <code>ExternalAgentLoaderConnectorCapabilitiesAdapter</code> is a wrapper around {@link ExternalAgentLoaderConnector } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.4", date = "2019-08-18T04:59:09-05:00", comments = "Build UNNAMED.2810.4347dd1")
public class ExternalAgentLoaderConnectorCapabilitiesAdapter
    extends ExternalAgentLoaderConnector
    implements Capabilities
{


    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        return false;
    }

}
