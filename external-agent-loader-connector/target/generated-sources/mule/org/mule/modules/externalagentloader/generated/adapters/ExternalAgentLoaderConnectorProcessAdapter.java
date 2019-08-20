
package org.mule.modules.externalagentloader.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.externalagentloader.ExternalAgentLoaderConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>ExternalAgentLoaderConnectorProcessAdapter</code> is a wrapper around {@link ExternalAgentLoaderConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.4", date = "2019-08-18T04:59:09-05:00", comments = "Build UNNAMED.2810.4347dd1")
public class ExternalAgentLoaderConnectorProcessAdapter
    extends ExternalAgentLoaderConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<ExternalAgentLoaderConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, ExternalAgentLoaderConnectorCapabilitiesAdapter> getProcessTemplate() {
        final ExternalAgentLoaderConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,ExternalAgentLoaderConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, ExternalAgentLoaderConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, ExternalAgentLoaderConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
