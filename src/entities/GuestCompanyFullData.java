package entities;

import enums.EnumsMethodsOfPayments;

public class GuestCompanyFullData {
    private GuestCompany guestCompany;
    private ReservationDates reservationDates;
    private Price price;
    private EnumsMethodsOfPayments enumsMethodsOfPayments;

    public GuestCompanyFullData(GuestCompany guestCompany, ReservationDates reservationDates, Price price, EnumsMethodsOfPayments enumsMethodsOfPayments) {
        this.guestCompany = guestCompany;
        this.reservationDates = reservationDates;
        this.price = price;
        this.enumsMethodsOfPayments = enumsMethodsOfPayments;
    }

    public GuestCompany getGuestCompany() {
        return guestCompany;
    }

    public void setGuestCompany(GuestCompany guestCompany) {
        this.guestCompany = guestCompany;
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append("Guest Booking:")
                .append(guestCompany)
                .append(", ")
                .append(reservationDates)
                .append("Price: USD ")
                .append(price.totalPriceWithDiscountIfApplied(reservationDates, guestCompany))
                .append(enumsMethodsOfPayments);
        return sb.toString();

    }

}