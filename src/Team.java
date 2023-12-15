import java.util.*;

public class Team {
    private static Team team;
    private static final Random random = new Random();
    private List<Integer> usedJerseyNumbers;
    private String teamName;
    private List<Player> playersList;
    private final List<String> names = Arrays.asList("Ronaldo", "Messi", "Valverde", "Vincuis", "Mpabpe", "Tchouameni", "Camavinga", "De bryne", "Militao", "Alaba", "Ramos", "Silva",
            "Neymar", "Beckham", "Casemiro", "Modric", "Kroos");

    private NameGenerator generator = new NameGenerator(names);



    public Team(String name){
        this.teamName = name;
        this.playersList = new ArrayList<>();
        this.usedJerseyNumbers = new ArrayList<>();
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<Player> playersList) {
        this.playersList = playersList;
    }

    public List<Integer> getUsedJerseyNumbers() {
        return usedJerseyNumbers;
    }

    public void setUsedJerseyNumbers(List<Integer> usedJerseyNumbers) {
        this.usedJerseyNumbers = usedJerseyNumbers;
    }

    public  Player createByPosition(Position pos){
        String name = generator.generateRandName(names);
        double grade = random.nextDouble(100)+1;
        Position position=pos;
        int number = getRandomJerseyNumber(usedJerseyNumbers);
        return new Player(name,number,grade,pos);
    }
    public void createTeamByTactic(int def, int mid, int att){
        if (def+mid+att != 10) {
            throw new IllegalArgumentException("Number of field players must be a total of 10");
        }playersList.add(createByPosition(Position.GK));
        for(int i=0; i<def; i++){
            playersList.add(createByPosition(Position.DEF));
        }
        for(int i=0; i<mid; i++){
            playersList.add(createByPosition(Position.MID));
        }
        for(int i=0; i<att; i++){
            playersList.add(createByPosition(Position.ATT));
        }

    }

    protected int getRandomJerseyNumber(List<Integer> usedNumbers) {
        int number;
        do {
            number = random.nextInt(24) + 1; // Jersey numbers from 1 to 25
        } while (usedNumbers.contains(number));
        usedNumbers.add(number);
        return number;
    }

    public List<Player> generateRandomTeam() {
        List<Player> team = new ArrayList<>();
        String goalkeeperName = generator.generateRandName(names);
        int goalkeeperNumber = getRandomJerseyNumber(usedJerseyNumbers);
        double goalkeeperGrade = random.nextDouble(100) + 1;
        team.add(new Player(goalkeeperName, goalkeeperNumber, goalkeeperGrade, Position.GK));
        for (int i = 1; i < Position.values().length; i++) {
            for (int j = 0; j < 2; j++) {
                String playerName = generator.generateRandName(names);
                int playerNumber = getRandomJerseyNumber(usedJerseyNumbers);
                double playerGrade = random.nextDouble(100) + 1;
                team.add(new Player(playerName, playerNumber, playerGrade, Position.values()[i]));
            }
        }
        for (int i = 0; i < 4; i++) {
            String playerName = generator.generateRandName(names);
            int playerNumber = getRandomJerseyNumber(usedJerseyNumbers);
            double playerGrade = random.nextDouble(100) + 1;
            int posIndex = 0;
            do {
                posIndex = random.nextInt(Position.values().length);
            } while (posIndex == 0);
            team.add(new Player(playerName, playerNumber, playerGrade, Position.values()[posIndex]));
        }
        Collections.shuffle(team);

        return team;
    }


}