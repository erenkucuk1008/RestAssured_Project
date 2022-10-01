package Day1;

import org.junit.jupiter.api.*;

@DisplayName("Learning Life Cycle Annotations")
public class TestLifeCycleAnnotations {

    @BeforeAll
    public static void init(){
        System.out.println("Before all is running");
    }

    @AfterAll
    public static void close(){
        System.out.println("After all is running");
    }

    @BeforeEach
    public void initEach(){
        System.out.println("Before each is running");
    }

    @AfterEach
    public void tearDownEach(){
        System.out.println("After each is running");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 is running");
    }

    @Test
    public void test2(){
        System.out.println("Test 2 is running");
    }

}
