import core.secondLab.Person;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EqualsPersonTest {
    @Test
    public void testEqualsPerson() {
        Person person = new Person(
                20,
                "Andrew",
                "Malina"
        );
        String json = person.serializePerson();
        Person deserializePerson = person.deserializePerson(json);
        assertTrue(person.equals(deserializePerson));
    }
}