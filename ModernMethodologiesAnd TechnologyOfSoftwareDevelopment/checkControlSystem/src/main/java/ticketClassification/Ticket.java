package ticketClassification;

public abstract class Ticket {
    private int id;
    private String name;
    private int amountOfDays;
    private int numberOfTrips;

    abstract boolean isSuccessful();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfDays() {
        return amountOfDays;
    }

    public void setAmountOfDays(int amountOfDays) {
        this.amountOfDays = amountOfDays;
    }

    public int getNumberOfTrips() {
        return numberOfTrips;
    }

    public void setNumberOfTrips(int numberOfTrips) {
        this.numberOfTrips = numberOfTrips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (getId() != ticket.getId()) return false;
        if (getAmountOfDays() != ticket.getAmountOfDays()) return false;
        if (getNumberOfTrips() != ticket.getNumberOfTrips()) return false;
        return getName() != null ? getName().equals(ticket.getName()) : ticket.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getAmountOfDays();
        result = 31 * result + getNumberOfTrips();
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amountOfDays=" + amountOfDays +
                ", numberOfTrips=" + numberOfTrips +
                '}';
    }
}