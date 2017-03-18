import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        CsvReader csvReader = new CsvReader();
        Set<Line> lineSet = csvReader.readFile();
        Map<String, Set<Line>> map = new HashMap<>();
        for (Line strings : lineSet) {
            for (String st : strings.getStrings()) {
                if (!st.equals("\"\"")) {
                    map.put(st, new HashSet<Line>());

                }

            }
        }
        for (Line strings : lineSet) {
            for (String st : strings.getStrings()) {
                if (map.containsKey(st)) {
                    map.get(st).add(strings);
                }
            }


        }
        GroupGenerator groupGenerator = new GroupGenerator();
        groupGenerator.getGroups(map);



    }
}
