package tr.com.havelsan.microservices.currencyexchangeservice.rest.model.currencyexchange;

import tr.com.havelsan.microservices.currencyexchangeservice.rest.model.BaseRestResponse;

import java.math.BigDecimal;

public class ExchangeValueResponse extends BaseRestResponse {

    private Long id;
    private String from;
    private String  to;
    private BigDecimal conversionMultiple;
    private Integer port;

    private ExchangeValueResponse(ExchangeValueResponseBuilder builder){
        this.id = builder.id;
        this.from = builder.from;
        this.to = builder.to;
        this.conversionMultiple = builder.conversionMultiple;
        this.port = builder.port;
    }

    public static ExchangeValueResponseBuilder builder(){
        return new ExchangeValueResponseBuilder();
    }

    public static class ExchangeValueResponseBuilder{

        private Long id;
        private String from;
        private String  to;
        private BigDecimal conversionMultiple;
        private Integer port;

        private ExchangeValueResponseBuilder(){
        }

        public ExchangeValueResponseBuilder id(Long id){
            this.id = id;
            return this;
        }

        public ExchangeValueResponseBuilder from(String from){
            this.from = from;
            return this;
        }

        public ExchangeValueResponseBuilder to(String to){
            this.to = to;
            return this;
        }

        public ExchangeValueResponseBuilder conversionMultiple(BigDecimal conversionMultiple){
            this.conversionMultiple = conversionMultiple;
            return this;
        }

        public ExchangeValueResponseBuilder port(Integer port){
            this.port = port;
            return this;
        }

        public ExchangeValueResponse build(){
            return new ExchangeValueResponse(this);
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

    public Integer getPort() {
        return port;
    }
}
