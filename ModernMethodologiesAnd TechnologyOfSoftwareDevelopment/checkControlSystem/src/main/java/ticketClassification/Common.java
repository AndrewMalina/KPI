package ticketClassification;

import com.google.gson.Gson;

import java.util.Random;
import java.util.Scanner;

public class Common extends Ticket {
    private int funds;

    @Override
    public boolean isSuccessful() {
        if (this.funds < 4 && this.getNumberOfTrips() == 0 && this.getAmountOfDays() == 0) {
            return false;
        }
        if (this.funds >= 4) {
            this.funds -= 4;
            return true;
        }
        if (this.getNumberOfTrips() >= 1) {
            this.setNumberOfTrips(this.getNumberOfTrips() - 1);
            return true;
        }
        if (this.getAmountOfDays() >= 1) {
            return true;
        }
        return false;
    }

    public void setCommon() {
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);

        setId(r.nextInt(9999));
        System.out.println("Input Name");
        String name = scanner.nextLine();
        setName(name);
        selectorFundsDaysTrips(scanner);
        System.out.println("Ticket id = " + getId());
    }

    private void selectorFundsDaysTrips(Scanner scanner) {
        System.out.println("Select: \n" +
                "1)Set funds on the account \n" +
                "2)Set amount of days on the account \n" +
                "3)Set number of trips");
        int scan = scanner.nextInt();
        if (scan == 1 || scan == 2 || scan == 3) {
            if (scan == 1) {
                selectFounds(scanner);
            }
            if (scan == 2) {
                selectDays(scanner);
            }
            if (scan == 3) {
                selectTrips(scanner);
            }
        } else {
            System.err.println("Invalid number");
            selectorFundsDaysTrips(scanner);
        }
    }

    private void selectTrips(Scanner scanner) {
        System.out.println("Set number of trips 1)5 trips 2)10 trips");
        int select = scanner.nextInt();
        if (select == 1 || select == 2) {
            setNumberOfTrips(select);

            setAmountOfDays(0);
            this.funds = 0;
        } else {
            System.err.println("invalid number");

            setCommon();
        }
    }

    private void selectDays(Scanner scanner) {
        System.out.println("Set amount of days on the account 1)10 days 2)30 days");
        int select = scanner.nextInt();
        if (select == 1 || select == 2) {
            setAmountOfDays(select);

            setNumberOfTrips(0);
            this.funds = 0;
        } else {
            System.err.println("invalid number");

            setCommon();
        }
    }

    private void selectFounds(Scanner scanner) {
        System.out.print("Set funds on the account:");
        this.funds = scanner.nextInt();

        setNumberOfTrips(0);
        setAmountOfDays(0);
    }


    @Override
    public String toString() {
        return "Common{" +
                "funds=" + funds +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", amountOfDays=" + this.getAmountOfDays() +
                ", numberOfTrips=" + this.getNumberOfTrips() +
                '}';
    }

    public String serializePerson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public Common deserializePerson(String s) {
        Gson gson = new Gson();
        return gson.fromJson(s, Common.class);
    }
}