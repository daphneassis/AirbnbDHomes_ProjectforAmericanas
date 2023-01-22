package entities;

public class GuestIndividual extends Guest {

    private String lastName;
    private String idRegistration;

    public GuestIndividual(String name, String email, Phone phone, Adress adress, String lastName, String idRegistration) {
        super(name, email, phone, adress);
        this.lastName = lastName;
        this.idRegistration = idRegistration;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(String idRegistration) {
        this.idRegistration = idRegistration;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", Last Name: " + getLastName() +
                ", Id Registration: " + getIdRegistration() + ", ";

    }

    public static class GuestIndividualBuilder {

        private String name;

        private String email;

        private Phone phone;

        private Adress adress;

        private String lastName;
        private String idRegistration;

        public GuestIndividualBuilder name(String name) {
            this.name = name;
            return this;
        }

        public GuestIndividualBuilder email(String email) {
            this.email = email;
            return this;
        }

        public GuestIndividualBuilder phone(Phone phone) {
            this.phone = phone;
            return this;
        }

        public GuestIndividualBuilder adress(Adress adress) {
            this.adress = adress;
            return this;
        }

        public GuestIndividualBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public GuestIndividualBuilder idRegistration(String idRegistration) {
            this.idRegistration = idRegistration;
            return this;
        }

        public GuestIndividual build() {
            return new GuestIndividual(name, email, phone, adress, lastName, idRegistration);
        }

    }
}



