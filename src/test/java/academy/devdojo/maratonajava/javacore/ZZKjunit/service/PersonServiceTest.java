package academy.devdojo.maratonajava.javacore.ZZKjunit.service;

import academy.devdojo.maratonajava.javacore.ZZKjunit.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class PersonServiceTest {

    private Person adult;
    private Person notAdult;
    private PersonService service;

    @BeforeEach // anota este metodo para ser executado antes dos demais
    public void setUp() {
        adult = new Person(18);
        notAdult = new Person(15);
        service = new PersonService();
    }

    @Test // anota esta classe como teste
    @DisplayName("A person should be not adult when age is lower than 18") // permite exibir um nome elaborado para este teste
    void isAdult_ReturnFalse_WhenAgeIsLowerThan18() {
        assertFalse(service.isAdult(notAdult));
    }

    @Test
    @DisplayName("A person should be adult when age is greater or equal than 18")
    void isAdult_ReturnTrue_WhenAgeIsGreaterOrEqualThan18() {
        Assertions.assertTrue(service.isAdult(adult));
    }

    @Test
    @DisplayName("Should throw NullPointerException with message when person is null")
    void isAdult_ShouldThrowException_WhenPersonIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> service.isAdult(null), "Person cannot be null");
    }

    @Test
    @DisplayName("Should return list with only adults")
    void filterRemovingNotAdult_ReturnListWithAdultsOnly_WhenListOfPersonWithAdultIsPassed() {
        Person person1 = new Person(17);
        Person person2 = new Person(18);
        Person person3 = new Person(21);
        List<Person> people = List.of(person1, person2, person3);
        Assertions.assertEquals(2, service.filterRemovingNotAdult(people).size());
    }
}