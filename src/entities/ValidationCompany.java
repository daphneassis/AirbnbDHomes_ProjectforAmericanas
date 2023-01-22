package entities;

import java.util.Objects;

public class ValidationCompany {

    public static boolean validationPjRegistration(GuestCompany guestCompany) {
        if (Objects.isNull(guestCompany)) {
            return false;
        }
        return true;
    }

}
