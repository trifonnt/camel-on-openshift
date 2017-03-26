package camelinaction;

import org.apache.camel.EndpointInject;
import org.apache.camel.FluentProducerTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeController {

    @EndpointInject(uri = "direct:whoami")
    FluentProducerTemplate producer;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/plain")
    public String me() {
        return producer.request(String.class);
    }

}
