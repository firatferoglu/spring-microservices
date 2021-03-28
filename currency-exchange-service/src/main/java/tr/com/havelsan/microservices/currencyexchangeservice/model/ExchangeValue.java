package tr.com.havelsan.microservices.currencyexchangeservice.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ExchangeValue {

    @Id
    private Long id;
    @ManyToOne
    private Currency fromCurrency;
    @ManyToOne
    private Currency toCurrency;
    private BigDecimal conversionMultiple;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

}
