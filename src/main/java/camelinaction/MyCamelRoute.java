package camelinaction;

import java.net.UnknownHostException;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.util.InetAddressUtil;
import org.springframework.stereotype.Component;

@Component
public class MyCamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:whoami")
            .log("Processing request")
            .transform().body(String.class, MyCamelRoute::whoAmI);
    }

    public static String whoAmI(String body) {
        try {
            return "I am " + InetAddressUtil.getLocalHostName();
        } catch (UnknownHostException e) {
            // ignore
        }
        return "I don't know who am I";
    }
}
