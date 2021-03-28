package tr.com.havelsan.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.havelsan.microservices.limitsservice.configuration.BaseConfiguration;
import tr.com.havelsan.microservices.limitsservice.domain.LimitConfiguration;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private BaseConfiguration baseConfiguration;


    @GetMapping("/limits")
    public LimitConfiguration retreiveLimitsFromConfigurations(){
        return new LimitConfiguration(baseConfiguration.getMinimum(), baseConfiguration.getMaximum());
    }

}
