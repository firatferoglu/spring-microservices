package tr.com.havelsan.microservices.currencyconversionservice.rest.model.currencyconversion;

import tr.com.havelsan.microservices.currencyconversionservice.rest.model.BaseRestResponse;

import java.math.BigDecimal;

public class CurrencyConversionResponse extends BaseRestResponse {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;
    private Integer port;

    private CurrencyConversionResponse(CurrencyConversionResponseBuilder builder){
        this.id = builder.id;
        this.from = builder.from;
        this.to = builder.to;
        this.conversionMultiple = builder.conversionMultiple;
        this.quantity = builder.quantity;
        this.totalCalculatedAmount = builder.totalCalculatedAmount;
        this.port = builder.port;
    }

    public static CurrencyConversionResponseBuilder builder(){
        return new CurrencyConversionResponseBuilder();
    }

    public static class CurrencyConversionResponseBuilder{
        private Long id;
        private String from;
        private String to;
        private BigDecimal conversionMultiple;
        private BigDecimal quantity;
        private BigDecimal totalCalculatedAmount;
        private Integer port;

        private CurrencyConversionResponseBuilder(){
        }

        public CurrencyConversionResponseBuilder id(Long id){
            this.id = id;
            return this;
        }

        public CurrencyConversionResponseBuilder from(String from){
            this.from = from;
            return this;
        }

        public CurrencyConversionResponseBuilder to(String to){
            this.to = to;
            return this;
        }

        public CurrencyConversionResponseBuilder conversionMultiple(BigDecimal conversionMultiple){
            this.conversionMultiple = conversionMultiple;
            return this;
        }

        public CurrencyConversionResponseBuilder quantity(BigDecimal quantity){
            this.quantity = quantity;
            return this;
        }

        public CurrencyConversionResponseBuilder totalCalculatedAmount(BigDecimal totalCalculatedAmount){
            this.totalCalculatedAmount = totalCalculatedAmount;
            return this;
        }

        public CurrencyConversionResponseBuilder port(Integer port){
            this.port = port;
            return this;
        }

        public CurrencyConversionResponse build(){
            return new CurrencyConversionResponse(this);
        }

    }

    public Long getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public Integer getPort() {
        return port;
    }
}
