package entities;

import exception.DomainException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ReservationDates {

    private Integer aptNumber;
    private Date checkin;
    private Date checkout;


    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ReservationDates(Integer aptNumber, Date checkin, Date checkout) {
        validateReservationDates(checkin, checkout);
        this.aptNumber =aptNumber;
    }
    public ReservationDates(Date checkin, Date checkout) {
        validateReservationDates(checkin, checkout);
    }

    public Integer getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(Integer aptNumber) {
        this.aptNumber = aptNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }


    public long durationStay() {
        long diffDays = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diffDays, TimeUnit.MILLISECONDS);
    }

    public void validateReservationDates(Date checkin, Date checkout) {
        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)) {
            throw new DomainException("Reservation Dates must be future Dates");
        }
        if (checkout.before(checkin)) {
            throw new DomainException("The checkout date must be after the checkin date");
        }
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public void updateReservationDates(Date checkin, Date checkout) {
        validateReservationDates(checkin,checkout);
    }

       public int wichMonthIsTheStay(Date checkin) {
           LocalDate dateToLocalDate = checkin.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate();
           int month = dateToLocalDate.getMonthValue();
           return month;
       }

    public boolean isLongStay() {
        boolean longStay = false;
        if (durationStay() > 7) {
            longStay = true;
        }
        return longStay;
    }

    public String toString(){
        return "Room: "+ getAptNumber() +", Checkin: "+sdf.format(getCheckin())+","+
                " Checkout: "+ sdf.format(getCheckout()) + ","+ " Duration: "+ durationStay()+ " nights, ";
    }

}
