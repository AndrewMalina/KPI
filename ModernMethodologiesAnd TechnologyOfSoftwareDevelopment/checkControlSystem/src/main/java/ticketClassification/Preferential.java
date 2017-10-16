package ticketClassification;

import java.util.Random;
import java.util.Scanner;

public abstract class Preferential extends Ticket {
    public void setPreferential() {
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);

        setId(r.nextInt(9999));
        System.out.println("Input Name");
        String name = scanner.nextLine();
        setName(name);
        System.out.println("Select: \n" +
                "1)Set amount of days on the account \n" +
                "2)Set number of trips");
        selectScoreDayOrTrip(scanner);
        System.out.println("Ticket id = " + this.getId());
    }

    private void selectScoreDayOrTrip(Scanner scanner) {
        int scan = scanner.nextInt();
        if (scan == 1 || scan == 2) {
            if (scan == 1) {
                selectDayOnAccount(scanner);
            } else {
                selectTripsOnTheAccount(scanner);
            }
        } else {
            selectScoreDayOrTrip(scanner);
        }

    }

    private void selectTripsOnTheAccount(Scanner scanner) {
        System.out.println("Set number of trips \n1)5 trips \n2)10 trips ");
        int select = scanner.nextInt();
        if (select == 1 || select == 2) {
            if ((select == 1)) {
                setAmountOfDays(10);
            } else {
                setAmountOfDays(30);
            }

            setAmountOfDays(0);
        } else {
            System.err.println("invalid number");

            setPreferential();
        }
    }

    private void selectDayOnAccount(Scanner scanner) {
        System.out.println("Set amount of days on the account \n1)10 days \n2)30 days  ");

        int select = scanner.nextInt();
        if (select == 1 || select == 2) {
            if ((select == 1)) {
                setAmountOfDays(10);
            } else {
                setAmountOfDays(30);
            }

            setNumberOfTrips(0);
        } else {
            System.err.println("invalid number");

            setPreferential();
        }
    }
}