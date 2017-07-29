package com.cromey;

import org.apache.catalina.valves.AccessLogValve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter implements EmbeddedServletContainerCustomizer {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		if (container instanceof TomcatEmbeddedServletContainerFactory) {
			TomcatEmbeddedServletContainerFactory factory = (TomcatEmbeddedServletContainerFactory) container;
			AccessLogValve accessLogValve = new AccessLogValve();
			accessLogValve.setDirectory("/var/log/prospectsservice");
			accessLogValve.setPattern("combined");
			accessLogValve.setSuffix(".log");
			factory.addContextValves(accessLogValve);
		} else {
			logger.error("WARNING! this customizer does not support your configured container");
		}
	}

}
