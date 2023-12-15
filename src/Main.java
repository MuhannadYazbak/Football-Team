import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static void writeTeam(Team team){
        String filePath = "football_team.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            team.getPlayersList().forEach(player -> {
                try {
                    writer.write(player.toString());
                    writer.newLine();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });

            System.out.println("Team information written to " + filePath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Team team = new Team("myTeam");
        team.createTeamByTactic(4,4,2);
        writeTeam(team);
    }

}