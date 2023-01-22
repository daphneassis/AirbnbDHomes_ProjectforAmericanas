package entities;

public abstract class Guest {

    protected String name;
    protected String email;
    protected Phone phone;
    protected Adress adress;

    public Guest(String name, String email, Phone phone, Adress adress) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public void updateContactInformation(){


    }


    public String toString() {
        return
                "Name: " + getName() +
                        ", Email: " + getEmail() + ", " + getPhone() + ", " + getAdress();
    }
}
