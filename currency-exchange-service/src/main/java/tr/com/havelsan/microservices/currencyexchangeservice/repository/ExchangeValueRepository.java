package tr.com.havelsan.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.havelsan.microservices.currencyexchangeservice.model.ExchangeValue;

import java.util.Optional;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    Optional<ExchangeValue> findByFromCurrency_IdAndToCurrency_Id(Long fromCurrencyId, Long toCurrencyId);
}
