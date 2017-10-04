package core.secondLab;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Person person = new Person(
                20,
                "Andrew",
                "Malina"
        );

        String json = serializePerson(person);
        Person deserializePerson = deserializePerson(json);
        System.out.println(person.equals(deserializePerson));
    }

    private static String serializePerson(Person person) {
        Gson gson = new Gson();
        return gson.toJson(person);
    }

    private static Person deserializePerson(String s) {
        Gson gson = new Gson();
        return gson.fromJson(s, Person.class);
    }
}