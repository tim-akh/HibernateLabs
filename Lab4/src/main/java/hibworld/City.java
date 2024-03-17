package hibworld;


import javax.persistence.Column;

public class City {
    private Integer id;
    private String name;
    private Integer population;

    private Country country_code;

    public City() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Country getCountry_code() {
        return country_code;
    }

    public void setCountry_code(Country country_code) {
        this.country_code = country_code;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", name=" + name + ", population=" + population + '}';
    }
    
    
    
}
