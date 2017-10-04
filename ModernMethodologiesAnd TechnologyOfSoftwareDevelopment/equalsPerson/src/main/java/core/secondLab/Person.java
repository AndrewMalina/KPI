package core.secondLab;

import com.google.gson.Gson;

public class Person {
    private int age;
    private String name;
    private String surname;

    public Person(int age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person that = (Person) o;

        return getAge() == that.getAge() && getName().equals(that.getName()) && getSurname().equals(that.getSurname());
    }

    @Override
    public int hashCode() {
        int result = getAge();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getSurname().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public String serializePerson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public Person deserializePerson(String s) {
        Gson gson = new Gson();
        return gson.fromJson(s, Person.class);
    }
}