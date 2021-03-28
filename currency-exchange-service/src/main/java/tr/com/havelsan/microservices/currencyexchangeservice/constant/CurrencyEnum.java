package tr.com.havelsan.microservices.currencyexchangeservice.constant;

import java.util.Arrays;

public enum CurrencyEnum implements BaseEnum<Long> {
    USD(1L), TRY(2L), INR(3L);

    private Long value;

    CurrencyEnum(Long value){
        this.value = value;
    }

    @Override
    public Long getValue(){
        return value;
    }

    public static CurrencyEnum getProperCurrencyByName(String name){
        return Arrays.stream(CurrencyEnum.values())
                .filter(currencyEnum -> currencyEnum.name().equals(name))
                .findFirst().orElse(CurrencyEnum.USD);
    }

}
