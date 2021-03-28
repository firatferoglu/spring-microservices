package tr.com.havelsan.microservices.limitsservice.domain;

public class LimitConfiguration {

    private int minimum;
    private int maximum;

    public LimitConfiguration(int minimum, int maximum){
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }
}
