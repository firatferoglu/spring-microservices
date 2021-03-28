package tr.com.havelsan.microservices.currencyexchangeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tr.com.havelsan.microservices.currencyexchangeservice.model.ExchangeValue;
import tr.com.havelsan.microservices.currencyexchangeservice.repository.ExchangeValueRepository;

import java.util.Optional;

@Service
public class ExchangeValueServiceImpl implements ExchangeValueService{

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public ExchangeValue getExchangeValue(Long fromCurrencyId, Long toCurrencyId) {
        Optional<ExchangeValue> exchangeValueOptional = exchangeValueRepository.findByFromCurrency_IdAndToCurrency_Id(fromCurrencyId, toCurrencyId);
        return exchangeValueOptional.orElse(new ExchangeValue());
    }
}
