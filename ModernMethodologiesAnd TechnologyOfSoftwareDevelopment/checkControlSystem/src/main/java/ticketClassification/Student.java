package ticketClassification;

import com.google.gson.Gson;

public class Student extends Preferential {

    @Override
    public boolean isSuccessful() {
        if (this.getNumberOfTrips() == 0 && this.getAmountOfDays() == 0) {
            return false;
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

    @Override
    public String toString() {
        return "Student{" + "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", amountOfDays=" + this.getAmountOfDays() +
                ", numberOfTrips=" + this.getNumberOfTrips() +
                '}';
    }

    public String serializePerson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public Student deserializePerson(String s) {
        Gson gson = new Gson();
        return gson.fromJson(s, Student.class);
    }
}