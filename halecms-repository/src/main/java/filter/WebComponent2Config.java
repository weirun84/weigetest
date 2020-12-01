package filter;

import core.base.Filter.AdminFilter;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class WebComponent2Config {
    @Bean
    public FilterRegistrationBean<AdminFilter> Filter() {
        FilterRegistrationBean<AdminFilter> filterRegBean = new FilterRegistrationBean<>();
        filterRegBean.setFilter(new AdminFilter());
        filterRegBean.addUrlPatterns("/adminpage/*");
        filterRegBean.setOrder(Ordered.LOWEST_PRECEDENCE -1);
        return filterRegBean;
    }
//    @Bean
//    public TomcatServletWebServerFactory webServerFactory() {
//        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
//            @Override
//            public void customize(Connector connector) {
//                connector.setProperty("relaxedPathChars", "\"<>[\\]^`{|}");
//                connector.setProperty("relaxedQueryChars", "\"<>[\\]^`{|}");
//            }
//        });
//        return factory;
//    }
}
