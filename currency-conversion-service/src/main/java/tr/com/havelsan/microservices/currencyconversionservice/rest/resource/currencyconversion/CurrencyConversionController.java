package tr.com.havelsan.microservices.currencyconversionservice.rest.resource.currencyconversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tr.com.havelsan.microservices.currencyconversionservice.rest.feign.CurrencyExchangeProxy;
import tr.com.havelsan.microservices.currencyconversionservice.rest.model.currencyconversion.CurrencyConversionResponse;
import tr.com.havelsan.microservices.currencyconversionservice.rest.model.currencyconversion.CurrencyExchange;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionResponse convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        Map<String, String> argMap = new HashMap<>();
        argMap.put("from", from);
        argMap.put("to", to);

        ResponseEntity<CurrencyExchange> response =
                new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyExchange.class, argMap);
        CurrencyExchange currencyExchange = response.getBody();

        return  CurrencyConversionResponse.builder()
                .id(currencyExchange.getId())
                .from(currencyExchange.getFrom())
                .to(currencyExchange.getTo())
                .conversionMultiple(currencyExchange.getConversionMultiple())
                .quantity(quantity)
                .totalCalculatedAmount(currencyExchange.getConversionMultiple().multiply(quantity))
                .port(currencyExchange.getPort())
                .build();

    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionResponse convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        Map<String, String> argMap = new HashMap<>();
        argMap.put("from", from);
        argMap.put("to", to);

        CurrencyExchange currencyExchange = currencyExchangeProxy.currencyExchangeValue(from, to);

        return  CurrencyConversionResponse.builder()
                .id(currencyExchange.getId())
                .from(currencyExchange.getFrom())
                .to(currencyExchange.getTo())
                .conversionMultiple(currencyExchange.getConversionMultiple())
                .quantity(quantity)
                .totalCalculatedAmount(currencyExchange.getConversionMultiple().multiply(quantity))
                .port(currencyExchange.getPort())
                .build();

    }
}
