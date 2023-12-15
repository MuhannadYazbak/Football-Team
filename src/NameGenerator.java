import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class NameGenerator {
    private List<String> names;

    public NameGenerator(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return this.names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public String generateRandName(List<String> names){
        return (names.get(ThreadLocalRandom.current().nextInt(names.size())));
    }
}
