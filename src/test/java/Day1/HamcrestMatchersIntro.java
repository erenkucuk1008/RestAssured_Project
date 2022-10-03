package Day1;

import org.junit.jupiter.api.Test;

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

        assertThat(5+5, not(11));
        assertThat(5+5, is(not(11)));
        assertThat(5+5, is(not(equalTo(11))));
    }
}
