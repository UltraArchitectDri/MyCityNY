import com.opencsv.bean.CsvBindByName;

public class Slcsp {

    private String zipCode;

    private String rate;


    public Slcsp(String zipCode, String rate) {
        this.zipCode = zipCode;
        this.rate = rate;
    }


    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
