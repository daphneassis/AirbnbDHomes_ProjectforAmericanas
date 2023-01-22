import entities.*;
import enums.EnumsMethodsOfPayments;
import exception.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
       Scanner sc = new Scanner(System.in);

        List<GuestIndividual> listGuestIndividual = new ArrayList<>();
        List<GuestCompany> listGuestCompany = new ArrayList<>();
        List<GuestIndivFullData> listGuestIndivFullData = new ArrayList<>();
        List<GuestCompanyFullData> listGuestCompanyFullData = new ArrayList<>();
        GuestIndividual guestIndividual = null;
        GuestCompany guestCompany = null;
        GuestCompanyFullData guestCompanyFullData = null;
        GuestIndivFullData guestIndivFullData = null;

        char optionRegisterAnotherGuest;
        do {
            System.out.print("-----Guest Registration-------");
            System.out.println("");
            System.out.println("First Name:");
            String name = sc.next();

            System.out.println("Email:");
            String email = sc.next();

            System.out.println("Phone - Enter the country code:");
            int countryCode = sc.nextInt();
            System.out.println("Enter the city code:");
            int cityCode = sc.nextInt();
            System.out.println("Enter the phone number");
            int phoneNumber = sc.nextInt();
            Phone phone = new Phone(countryCode, cityCode, phoneNumber);

            System.out.println("Enter the full adress:");
            sc.nextLine();
            String streetAndComplement = sc.nextLine();
            System.out.println("City:");
            String city = sc.nextLine();
            System.out.println("Enter the zipcode:");
            String zipCode = sc.next();
            System.out.println("Country:");
            String country = sc.next();
            Adress adress = new Adress.AdressBuilder()
                    .streetAndComplement(streetAndComplement)
                    .city(city)
                    .country(country)
                    .zipCode(zipCode)
                    .build();

            System.out.println("-----------The reservation is for individual or company(i/c)------------?");
            char ch = sc.next().charAt(0);
            if (ch == 'i') {
                System.out.println("Enter the last name:");
                String lastName = sc.next();
                System.out.println("Enter the number of ID Registration:");
                String idRegistration = sc.next();

                guestIndividual = new GuestIndividual.GuestIndividualBuilder()
                        .name(name)
                        .lastName(lastName)
                        .idRegistration(idRegistration)
                        .email(email)
                        .phone(phone)
                        .adress(adress)
                        .build();

                System.out.println("------Full Data Registration:---------- ");
                listGuestIndividual.add(guestIndividual);
                System.out.print(guestIndividual);
            }
            if (ch == 'c') {
                System.out.println("Enter the company name: ");
                String companyName = sc.next();
                System.out.println("Enter the number of PJ Registration: ");
                String pjRegistration = sc.next();

                guestCompany = new GuestCompany.GuestCompanyBuilder()
                        .name(name)
                        .companyName(companyName)
                        .pjRegistration(pjRegistration)
                        .email(email)
                        .phone(phone)
                        .adress(adress)
                        .build();
                System.out.println("------Full registration:---------- ");
                listGuestCompany.add(guestCompany);
                System.out.println(guestCompany);
            }

            System.out.println("------Booking Details:---------- ");
            System.out.println("Apt for reservation:");
            int aptNumber = sc.nextInt();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Check-in date (dd/MM/yyyy): ");
            ReservationDates reservationDates = null;
            try {
                Date checkin = sdf.parse(sc.next());
                System.out.println("Check-out date (dd/MM/yyyy): ");
                Date checkout = sdf.parse(sc.next());
                reservationDates = new ReservationDates(aptNumber, checkin, checkout);
            } catch (ParseException e) {
                System.out.println("Invalid format");
            } catch (DomainException e) {
                System.out.println("Error in reservation: " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("Unexpected error!");
            }
            System.out.println("-----Booking Output-------");
            System.out.println(reservationDates);

            System.out.println("--------Payment-------------");
            System.out.println("Total amount to be paid: ");
            Price price = new Price();
            System.out.println("USD: " + price.totalPriceWithDiscountIfApplied(reservationDates, guestCompany));

            System.out.println("------Methods of Payment-----------");
            System.out.println("The reservation is free of charge, but you must choose the option for payment at check-in");
            System.out.println("----------Options:------------- ");
            for (EnumsMethodsOfPayments methods : EnumsMethodsOfPayments.values()) {
                System.out.println(methods.getDescription() + ", Option:  " + methods.getId());
            }
            System.out.println("-------------");
            System.out.println("Enter the chosen option:");
            int idMethodOfPayment = sc.nextInt();
            EnumsMethodsOfPayments methodChosen = EnumsMethodsOfPayments.findMethodPaymentById(idMethodOfPayment);
            System.out.println("Option chosen:  " + methodChosen.getId() + ", " + methodChosen.getDescription());
            System.out.println("Reservation process completed and added to the List:");
            if (ValidationCompany.validationPjRegistration(guestCompany) == true) {
                guestCompanyFullData = new GuestCompanyFullData(guestCompany, reservationDates, price, methodChosen);
                listGuestCompanyFullData.add(guestCompanyFullData);
                System.out.println(guestCompanyFullData);
            } else {
                guestIndivFullData = new GuestIndivFullData(guestIndividual, reservationDates, price, methodChosen);
                listGuestIndivFullData.add(guestIndivFullData);
                System.out.println(guestIndivFullData);
            }
            int optionPossibleActions;
            do {
                System.out.println("----Menu of LIST Actions:-----  ");
                System.out.println("----*List Guest Individuals*:-----  ");
                System.out.println("Enter 1 to see all the Data from the Bookings so far");
                System.out.println("Enter 2 to remove an Reservation by an ID Registration: ");
                System.out.println("Enter 3 to see the contact info for individual guests (for Marketing): ");
                System.out.println("Enter 4 to update contact info for individual guests by an ID Registration:  ");
                System.out.println("Enter 5 to update reservation dates for individual guests by an ID Registration:  ");


                System.out.println("----*List Guest Companies*:-----  ");
                System.out.println("Enter 6 to see all the Data from the Bookings Companies so far");
                System.out.println("Enter 7 to remove an Reservation by an PJ Registration: ");
                System.out.println("Enter 8 to see the contact info for company guests (for Marketing)");
                System.out.println("Enter 9 to update contact info for company guests by an PJ Registration:  ");
                System.out.println("Enter 10 to update reservation dates info for company guests by an PJ Registration: ");


                System.out.println("Enter 0 to leave this Menu List and continue the System");

                System.out.println("----------");
                System.out.println("Enter your option: ");
                optionPossibleActions = sc.nextInt();
                switch (optionPossibleActions) {
                    case 0:
                        System.out.println("Ending List Menu");
                        System.out.println("------------------------");
                        break;
                    case 1:
                        listGuestIndivFullData.forEach(System.out::println);
                        break;
                    case 2:
                        System.out.println("Enter Guest's ID Registration:");
                        String idRegistration = sc.next();
                        for (int i = 0; i < listGuestIndivFullData.size(); i++) {
                            if (listGuestIndivFullData.get(i).getGuestIndividual().getIdRegistration().equals(idRegistration)) {
                                listGuestIndivFullData.remove(listGuestIndivFullData.get(i));
                                System.out.println("The reservation was deleted. ");
                            }
                        }
                        break;
                    case 3:
                        listGuestIndividual.forEach(System.out::println);
                        break;
                    case 4:
                        System.out.println("Enter Guest's ID Registration:");
                        idRegistration = sc.next();
                        for (int i = 0; i < listGuestIndividual.size(); i++) {
                            if (listGuestIndividual.get(i).getIdRegistration().equals(idRegistration)) {
                                System.out.println("Enter the new Guest's email for mailMarketing");
                                email = sc.next();
                                listGuestIndividual.get(i).setEmail(email);
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Enter ID Registration:");
                        idRegistration = sc.next();
                        for (int i = 0; i < listGuestIndivFullData.size(); i++) {
                            if (listGuestIndivFullData.get(i).getGuestIndividual().getIdRegistration().equals(idRegistration)) {
                                System.out.print("Update reservation, enter data: ");
                                System.out.println("\nCheck-in date (dd/MM/yyyy): ");
                                Date checkinUpdated = sdf.parse(sc.next());
                                System.out.println("Check-out date (dd/MM/yyyy): ");
                                Date checkoutUpdated = sdf.parse(sc.next());
                                reservationDates.updateReservationDates(checkinUpdated, checkoutUpdated);
                                listGuestIndivFullData.get(i).setReservationDates(reservationDates);
                                System.out.println("Reservation Updated: " + reservationDates);
                            }
                        }
                    case 6:
                        listGuestCompanyFullData.forEach(System.out::println);
                        break;
                    case 7:
                        System.out.println("Enter PJ Registration:");
                        String pjRegistration = sc.next();
                        for (int i = 0; i < listGuestCompanyFullData.size(); i++) {
                            if (listGuestCompanyFullData.get(i).getGuestCompany().getPjRegistration().equals(pjRegistration)) {
                                listGuestCompanyFullData.remove(listGuestCompanyFullData.get(i));
                                System.out.println("The reservation was deleted. ");
                            }
                        }
                        break;
                    case 8:
                        listGuestCompany.forEach(System.out::println);
                        break;
                    case 9:
                        System.out.println("Enter Company PJ Registration:");
                        pjRegistration = sc.next();
                        for (int i = 0; i < listGuestCompany.size(); i++) {
                            if (listGuestCompany.get(i).getPjRegistration().equals(pjRegistration)) {
                                System.out.println("Enter the new Company's email for mailMarketing");
                                email = sc.next();
                                listGuestCompany.get(i).setEmail(email);
                            }
                        }
                        break;
                    case 10:
                        System.out.println("Enter PJ Registration:");
                        pjRegistration = sc.next();
                        for (int i = 0; i < listGuestCompanyFullData.size(); i++) {
                            if (listGuestCompanyFullData.get(i).getGuestCompany().getPjRegistration().equals(pjRegistration)) {
                                System.out.print("Update reservation, enter data: ");
                                System.out.println("\nCheck-in date (dd/MM/yyyy): ");
                                Date checkinUpdated = sdf.parse(sc.next());
                                System.out.println("Check-out date (dd/MM/yyyy): ");
                                Date checkoutUpdated = sdf.parse(sc.next());
                                reservationDates.updateReservationDates(checkinUpdated, checkoutUpdated);
                                listGuestCompanyFullData.get(i).setReservationDates(reservationDates);

                                System.out.println("Reservation Updated: " + reservationDates);
                            }
                        }
                        break;
                }

            } while (optionPossibleActions != 0) ;

                        System.out.print("Do you need to register another Reservation?(y/n)");
                        optionRegisterAnotherGuest = sc.next().charAt(0);
                }
                while (optionRegisterAnotherGuest == 'y') ;

            }
        }
