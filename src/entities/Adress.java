package entities;

public class Adress {

    private String streetAndComplement;
    private String city;
    private String zipCode;
    private String country;

    public Adress(String streetAndComplement, String city, String zipCode, String country) {
        this.streetAndComplement = streetAndComplement;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    public String getStreetAndComplement() {
        return streetAndComplement;
    }

    public void setStreetAndComplement(String streetAndComplement) {
        this.streetAndComplement = streetAndComplement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Adress:" + streetAndComplement + ", City: " + city +
                ", ZipCode: " + zipCode +
                ", Country: " + country;
    }

    public static class AdressBuilder {

        private String streetAndComplement;
        private String city;
        private String zipCode;
        private String country;

        public AdressBuilder streetAndComplement(String streetAndComplement) {
            this.streetAndComplement = streetAndComplement;
            return this;
        }

        public AdressBuilder city (String city) {
            this.city = city;
            return this;
        }

        public AdressBuilder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;

        }

        public AdressBuilder country(String country) {
            this.country = country;
            return this;

        }

        public Adress build() {
            return new Adress(streetAndComplement, city, zipCode, country);
        }
    }
}
