import com.opencsv.bean.CsvBindByName;

public class Slcsp {

    private Integer zipCode;

    private String rate;


    public Slcsp(Integer zipCode, String rate) {
        this.zipCode = zipCode;
        this.rate = rate;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
