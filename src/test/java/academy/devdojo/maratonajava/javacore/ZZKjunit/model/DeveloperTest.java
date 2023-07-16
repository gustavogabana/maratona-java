package academy.devdojo.maratonajava.javacore.ZZKjunit.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperTest {

    private Employee employeeDeveloper;

    @BeforeEach
    public void setUp() {
        employeeDeveloper = new Developer("1", "Java");
    }

    @Test
    public void instanceOf_ExecutesChildClassMethod_WhenObjectIsOfChildType() {
        if (employeeDeveloper instanceof Developer) {
            Developer dev = (Developer) employeeDeveloper;
            Assertions.assertEquals("Java", dev.getMainLanguage());
        }
        //Pattern matching for instance of: faz o cast diretamente na validação do instance of
        if (employeeDeveloper instanceof Developer dev) {
            Assertions.assertEquals("Java", dev.getMainLanguage());
        }
    }

}