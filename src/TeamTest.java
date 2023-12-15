import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

class TeamTest {

    private Team team;

    @BeforeEach
    void setUp() {
        team = new Team("Test Team");
    }

    @AfterEach
    void tearDown() {
        team = null;
    }

    @Test
    void createTeamByTacticShouldCreateValidTeam() {
        team.createTeamByTactic(4, 3, 3);
        assertEquals("Test Team", team.getTeamName());
        assertEquals(11, team.getPlayersList().size());
    }

    @Test
    void createTeamByTacticShouldThrowExceptionForInvalidTactic() {
        assertThrows(IllegalArgumentException.class, () -> team.createTeamByTactic(5, 4, 3));
    }

    @Test
    void createByPositionShouldCreateValidPlayer() {
        Position position = Position.MID;
        Player player = team.createByPosition(position);
        assertNotNull(player);
        assertEquals(position, player.getPosition());
        assertTrue(player.getJerseyNumber() >= 1 && player.getJerseyNumber() <= 25);
    }

    @Test
    void getRandomJerseyNumberShouldGenerateUniqueNumbers() {
        int number1 = team.getRandomJerseyNumber(team.getUsedJerseyNumbers());
        int number2 = team.getRandomJerseyNumber(team.getUsedJerseyNumbers());
        assertNotEquals(number1, number2);
    }

    @Test
    void getRandomJerseyNumberShouldGenerateNumbersInRange() {
        int number = team.getRandomJerseyNumber(team.getUsedJerseyNumbers());
        assertTrue(number >= 1 && number <= 25);
    }

    @Test
    void generateRandomTeamShouldCreateValidTeam() {
        List<Player> generatedTeam = team.generateRandomTeam();
        assertEquals(11, generatedTeam.size());
    }
    @ParameterizedTest
    @MethodSource("getInput")
    public void testValidNumber(int a){
        assertTrue(a >=2 && a <=6);
    }
    private static Stream<Arguments> getInput(){
        return Stream.of(
                Arguments.of(4),
                Arguments.of(3),
                Arguments.of(3)
        );
    }
}
