public class Player {
    private String name;
    private int jerseyNumber;
    private double grade;
    private Position position;

    public Player(String name, int jerseyNumber, double grade, Position position) {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
        this.grade = grade;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", jerseyNumber=" + jerseyNumber +
                ", grade=" + grade +
                ", position=" + position +
                '}';
    }
}
