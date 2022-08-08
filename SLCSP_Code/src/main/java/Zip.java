
public class Zip {

    private Integer zipCode;

    private String state;

    private Integer countyCode;

    private String name;

    private Integer rateArea;


    public Zip(Integer zipCode, String state, Integer countyCode, String name, Integer rateArea) {
        this.zipCode = zipCode;
        this.state = state;
        this.countyCode = countyCode;
        this.name = name;
        this.rateArea = rateArea;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRateArea() {
        return rateArea;
    }

    public void setRateArea(Integer rateArea) {
        this.rateArea = rateArea;
    }

    public Integer getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(Integer countyCode) {
        this.countyCode = countyCode;
    }
}
