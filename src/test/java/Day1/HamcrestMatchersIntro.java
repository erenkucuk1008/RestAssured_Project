package Day1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersIntro {

    @Test
    public void simpleTest1(){

        //assert 10 equal 5+5
        //this is the syntax for hamcrest way for assertion
        assertThat(5+5, is(10));
        assertThat(5+5, equalTo(10));
        assertThat(5+5, is(equalTo(10)));

        //negative assertion 5+5 is not equal 11
        assertThat(5+5, not(11));
        assertThat(5+5, is(not(11)));
        assertThat(5+5, is(not(equalTo(11))));

        //number comparison
        assertThat(5+5, is(greaterThan(9)));
        //                        lessThan()
        //                        greaterThanOrEqual()
        //                        lessThanOrEqual()

    }

    @DisplayName("Matchers related to Strings")
    @Test
    public void stringMatchers(){

        String msg = "I am learning Hamcrest";

        assertThat(msg, is("I am learning Hamcrest"));
        assertThat(msg, equalTo("I am learning Hamcrest"));
        assertThat(msg, is(equalTo("I am learning Hamcrest")));

        //check if this msg starts with "I"
        assertThat(msg, startsWith("I"));
        //now do it insensitive manner
        assertThat(msg, startsWithIgnoringCase("i"));
        //check it ends with "rest"
        assertThat(msg, endsWith("rest"));

        assertThat(msg, containsString("learning"));
        assertThat(msg, containsStringIgnoringCase("LEARning"));

        String str = " ";
        //check if str is blank
        assertThat(str, blankString());
        //check if trimmed str is empty String
        assertThat(str, emptyString());
    }

    @DisplayName("Hamcrest support for collection")
    @Test
    public void testCollection(){

        List<Integer> lst = Arrays.asList(1,4,7,3,7,44,88,99,44);

        //check the side og this list -- kac elamanli
        assertThat(lst, hasSize(9));
        //check if this list hasItem
        assertThat(lst, hasItem(7));
        //check if this list hasItems
        assertThat(lst, hasItems(7,88,99));

        //check if every item in this list is greaterThan 0
        assertThat(lst, everyItem(is(greaterThan(0))));
    }
}
