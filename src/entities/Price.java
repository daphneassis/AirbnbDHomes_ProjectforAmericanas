package entities;

public class Price {

    private double dailyRate = 220;
    private double highSeasonTax = 1.5;
    private double companyDiscount = 0.09;
    private double discountForLongStay = 0.1;

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getHighSeasonTax() {
        return highSeasonTax;
    }

    public void setHighSeasonTax(double highSeasonTax) {
        this.highSeasonTax = highSeasonTax;
    }

    public double getCompanyDiscount() {
        return companyDiscount;
    }

    public void setCompanyDiscount(double companyDiscount) {
        this.companyDiscount = companyDiscount;
    }

    public double getDiscountForLongStay() {
        return discountForLongStay;
    }

    public void setDiscountForLongStay(double discountForLongStay) {
        this.discountForLongStay = discountForLongStay;
    }

    public double calculatePriceOfStayBySeason(ReservationDates reservationDates) {
        if (SeasonsService.isHighSeason(reservationDates) == true) {
            return calculatePriceInHighSeason(reservationDates);
        } else {
            return calculatePriceInLowSeason(reservationDates);
        }
    }

    public double calculatePriceInHighSeason(ReservationDates reservationDates) {
        return dailyRate * reservationDates.durationStay() * highSeasonTax;
    }

    public double calculatePriceInLowSeason(ReservationDates reservationDates) {
        return dailyRate * reservationDates.durationStay();
    }

    public double totalPriceWithDiscountIfApplied(ReservationDates reservationDates, GuestCompany guestCompany) {
        if (reservationDates.isLongStay()== true){
           return calculatePriceOfStayBySeason(reservationDates) - calculatePriceOfStayBySeason(reservationDates)*discountForLongStay;
        } else if (ValidationCompany.validationPjRegistration(guestCompany)==true){
            return calculatePriceOfStayBySeason(reservationDates) - calculatePriceOfStayBySeason(reservationDates)*companyDiscount;
        }
        return calculatePriceOfStayBySeason(reservationDates);
    }

}
