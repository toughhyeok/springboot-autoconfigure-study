package hotamulspring.config.autoconfig;

import hotamulspring.config.ConditionalMyOnClass;
import hotamulspring.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {
    @Bean("jettyWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();

        factory.setContextPath(properties.getContextPath());
        factory.setPort(properties.getPort());

        return factory;
    }


}

