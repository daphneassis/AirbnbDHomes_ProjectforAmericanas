package entities;

public class GuestCompany extends Guest {

    private String companyName;
    private String pjRegistration;


    public GuestCompany(String name, String email, Phone phone, Adress adress, String companyName, String pjRegistration) {
        super(name, email, phone, adress);
        this.companyName = companyName;
        this.pjRegistration = pjRegistration;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPjRegistration() {
        return pjRegistration;
    }

    public void setPjRegistration(String pjRegistration) {
        this.pjRegistration = pjRegistration;
    }
    @Override
    public String toString() {
        return
                super.toString() +
                       " Full Company Name: " + getCompanyName() +
                        " Pj Registration: " + getPjRegistration();
    }

    public static class GuestCompanyBuilder {

        private String name;
        private String email;
        private Phone phone;
        private Adress adress;
        private String companyName;
        private String pjRegistration;

        public GuestCompanyBuilder name(String name) {
            this.name = name;
            return this;
        }

        public GuestCompanyBuilder email(String email) {
            this.email = email;
            return this;
        }

        public GuestCompanyBuilder phone(Phone phone) {
            this.phone = phone;
            return this;
        }

        public GuestCompanyBuilder adress(Adress adress) {
            this.adress = adress;
            return this;
        }

        public GuestCompanyBuilder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public GuestCompanyBuilder pjRegistration(String pjRegistration) {
            this.pjRegistration = pjRegistration;
            return this;
        }
        public GuestCompany build() {
            return new GuestCompany(name, email, phone, adress, companyName, pjRegistration);
        }

    }
}
