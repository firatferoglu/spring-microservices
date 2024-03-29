package tr.com.havelsan.microservices.currencyconversionservice.rest.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tr.com.havelsan.microservices.currencyconversionservice.rest.model.currencyconversion.CurrencyExchange;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000/")
@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyExchange currencyExchangeValue(@PathVariable String from, @PathVariable String to);
}
