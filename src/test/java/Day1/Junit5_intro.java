package Day1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Day1 of Junit5 Test")
public class Junit5_intro {

    @DisplayName("Testing numbers")
    @Test
    public void test(){
        System.out.println("Learning Junit5 now");

        assertEquals(1,1);
        //assertEquals(1,2,"Somethig is wrong!!");
    }

    @DisplayName("Testing name start with A")
    @Test
    public void my_name_first_character(){

        String firstName = "Adnan";
        assertEquals('A',firstName.charAt(0));
        //assertTrue(firstName.startsWith("A"));

    }
}
