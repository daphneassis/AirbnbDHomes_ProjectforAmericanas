package entities;

public class Phone {

    private int countryCode;
    private int cityCode;
    private int phoneNumber;

    public Phone(int countryCode, int cityCode, int phoneNumber) {
        this.countryCode = countryCode;
        this.cityCode = cityCode;
        this.phoneNumber = phoneNumber;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "Phone: +"+ countryCode + " (" +cityCode + ") "+ phoneNumber;
    }

}
