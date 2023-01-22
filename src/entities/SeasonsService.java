package entities;

public class SeasonsService {

    public static boolean isHighSeason(ReservationDates reservationDates) {
        long month = reservationDates.wichMonthIsTheStay(reservationDates.getCheckin());
        boolean isHighSeason = false;
        switch ((int) month) {
            case 1, 2, 3, 7, 12:
                isHighSeason = true;
                break;
        }
        return isHighSeason;
    }

}
