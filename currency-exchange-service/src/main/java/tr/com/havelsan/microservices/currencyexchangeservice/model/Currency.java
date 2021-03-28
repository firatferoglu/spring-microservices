package tr.com.havelsan.microservices.currencyexchangeservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency{

    public Currency(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Currency(){

    }

    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
