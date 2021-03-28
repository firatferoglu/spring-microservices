package tr.com.havelsan.microservices.currencyexchangeservice.service;

import tr.com.havelsan.microservices.currencyexchangeservice.model.ExchangeValue;

public interface ExchangeValueService {
    ExchangeValue getExchangeValue(Long fromCurrencyId, Long toCurrencyId);
}
