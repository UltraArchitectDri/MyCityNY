

public class Plan  implements Comparable<Plan> {

    private String planId;
    private String state;
    private String metalLevel;
    private Float rate;
    private Integer rateArea;

    public Plan(String planId, String state, String metalLevel, Float rate, Integer rateArea) {
        this.planId = planId;
        this.state = state;
        this.metalLevel = metalLevel;
        this.rate = rate;
        this.rateArea = rateArea;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMetalLevel() {
        return metalLevel;
    }

    public void setMetalLevel(String metalLevel) {
        this.metalLevel = metalLevel;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Integer getRateArea() {
        return rateArea;
    }

    public void setRateArea(Integer rateArea) {
        this.rateArea = rateArea;
    }

    @Override
    public int compareTo(Plan o) {
        return (int) (this.rate - o.rate);
    }
}
