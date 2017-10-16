package ticketClassification;

import com.google.gson.Gson;

public class Schoolboy extends Preferential {
    @Override
    public boolean isSuccessful() {
        if (this.getNumberOfTrips() == 0 && this.getAmountOfDays() == 0) {
            return false;
        }
        if (this.getNumberOfTrips() >= 1) {
            this.setNumberOfTrips(this.getNumberOfTrips() - 1);
            return true;
        }
        return this.getAmountOfDays() >= 1;
    }

    @Override
    public String toString() {
        return "Schoolboy{" + "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", amountOfDays=" + this.getAmountOfDays() +
                ", numberOfTrips=" + this.getNumberOfTrips() +
                '}';
    }

    public String serializePerson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public Schoolboy deserializePerson(String s) {
        Gson gson = new Gson();
        return gson.fromJson(s, Schoolboy.class);
    }
}