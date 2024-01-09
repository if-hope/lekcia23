import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
import org.testng.Reporter;

import java.io.Serializable;

@Plugin(name = "Reporter", category = "Core", elementType = "appender", printObject = true)
public class ReporterAppender extends AbstractAppender {

    protected ReporterAppender(String name, Layout layout) {
        super(name, null, layout, false);
    }

    @Override
    public void append(LogEvent event) {
        Reporter.log(((AbstractStringLayout) getLayout()).toSerializable(event));
    }

    @PluginFactory
    public static ReporterAppender createAppenderObject(
            @PluginAttribute("name") @Required(message = "A name for the Appender must be specified") final String name,
            @PluginElement("Layout") Layout<? extends Serializable> layout) {
        return new ReporterAppender(name, layout);
    }
}

