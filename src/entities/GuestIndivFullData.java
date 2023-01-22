package entities;

import enums.EnumsMethodsOfPayments;

public class GuestIndivFullData {

    private GuestIndividual guestIndividual;
    private GuestCompany guestCompany;
    private ReservationDates reservationDates;
    private Price price;
    private EnumsMethodsOfPayments enumsMethodsOfPayments;

    public GuestIndivFullData(GuestIndividual guestIndividual, ReservationDates reservationDates, Price price, EnumsMethodsOfPayments enumsMethodsOfPayments) {
        this.guestIndividual = guestIndividual;
        this.reservationDates = reservationDates;
        this.price = price;
        this.enumsMethodsOfPayments = enumsMethodsOfPayments;
    }


    public GuestIndividual getGuestIndividual() {
        return guestIndividual;
    }

    public void setGuestIndividual(GuestIndividual guestIndividual) {
        this.guestIndividual = guestIndividual;
    }

    public ReservationDates getReservationDates() {
        return reservationDates;
    }

    public void setReservationDates(ReservationDates reservationDates) {
        this.reservationDates = reservationDates;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public EnumsMethodsOfPayments getEnumsMethodsOfPayments() {
        return enumsMethodsOfPayments;
    }

    public void setEnumsMethodsOfPayments(EnumsMethodsOfPayments enumsMethodsOfPayments) {
        this.enumsMethodsOfPayments = enumsMethodsOfPayments;
    }

    public GuestCompany getGuestCompany() {
        return guestCompany;
    }

    public void setGuestCompany(GuestCompany guestCompany) {
        this.guestCompany = guestCompany;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append("Guest Booking:")
                .append(guestIndividual)
                .append(reservationDates)
                .append("Price: USD ")
                .append(price.totalPriceWithDiscountIfApplied(reservationDates, guestCompany))
                .append(enumsMethodsOfPayments);
        return sb.toString();

    }

}