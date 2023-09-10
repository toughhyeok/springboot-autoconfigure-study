package hotamulspring.config.autoconfig;

import hotamulspring.config.ConditionalMyOnClass;
import hotamulspring.config.MyAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {
    @Value("${contextPath}")
    String contextPath;

    @Bean("jettyWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory() {
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.setContextPath(this.contextPath);
        return factory;
    }

}

