import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class NameGeneratorTest {
    private static List<String> testNames;
    private static NameGenerator generator;

    @BeforeAll
     static void setup(){
        testNames = new ArrayList<>(Arrays.asList("player1", "player2"));
        generator = new NameGenerator(testNames);
    }

    @AfterAll
     static void tear(){
        generator = null;
    }

    @Test
    void contains(){
        assertTrue(generator.getNames().contains("player1"));
        assertEquals(2, generator.getNames().size());
    }


    @Test
    void testGenerateName(){
        assertNotNull(new NameGenerator(testNames).generateRandName(testNames));
    }
}
