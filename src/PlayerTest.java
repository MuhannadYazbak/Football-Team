import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("player1", 5, 88.5, Position.MID);
    }

    @AfterEach
    void tearDown() {
        player = null;
    }

    @Test
    void constructorShouldSetProperties() {
        assertEquals("player1", player.getName());
        assertEquals(5, player.getJerseyNumber());
        assertEquals(88.5, player.getGrade(), 0.001);
        assertEquals(Position.MID, player.getPosition());
    }

    @Test
    void setNameShouldChangeName() {
        String newName = "modified player1";
        player.setName(newName);
        assertEquals(newName, player.getName());
    }

    @Test
    void setJerseyNumberShouldChangeJerseyNumber() {
        int newJerseyNumber = 8;
        player.setJerseyNumber(newJerseyNumber);
        assertEquals(newJerseyNumber, player.getJerseyNumber());
    }

    @Test
    void setGradeShouldChangeGrade() {
        double newGrade = 90.2;
        player.setGrade(newGrade);
        assertEquals(newGrade, player.getGrade(), 0.001);
    }

    @Test
    void setPositionShouldChangePosition() {
        Position newPosition = Position.DEF;
        player.setPosition(newPosition);
        assertEquals(newPosition, player.getPosition());
    }
}
