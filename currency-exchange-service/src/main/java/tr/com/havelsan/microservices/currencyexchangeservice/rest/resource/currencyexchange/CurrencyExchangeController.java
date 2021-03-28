package tr.com.havelsan.microservices.currencyexchangeservice.rest.resource.currencyexchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tr.com.havelsan.microservices.currencyexchangeservice.constant.CurrencyEnum;
import tr.com.havelsan.microservices.currencyexchangeservice.model.Currency;
import tr.com.havelsan.microservices.currencyexchangeservice.model.ExchangeValue;
import tr.com.havelsan.microservices.currencyexchangeservice.rest.model.currencyexchange.ExchangeValueResponse;
import tr.com.havelsan.microservices.currencyexchangeservice.service.ExchangeValueService;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueService exchangeValueService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValueResponse currencyExchangeValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue  exchangeValue = exchangeValueService.getExchangeValue(CurrencyEnum.getProperCurrencyByName(from).getValue(), CurrencyEnum.getProperCurrencyByName(to).getValue());
        return ExchangeValueResponse.builder()
                .id(exchangeValue.getId())
                .from(exchangeValue.getFromCurrency().getName())
                .to(exchangeValue.getToCurrency().getName())
                .conversionMultiple(exchangeValue.getConversionMultiple())
                .port(Integer.parseInt(environment.getProperty("local.server.port")))
                .build();
    }
}
