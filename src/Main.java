import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        CsvReader csvReader = new CsvReader();
        Set<Line> lineSet = csvReader.readFile();
        Map<MainString, Set<Line>> map = new HashMap<>();
        for (Line strings : lineSet) {
            for (int i = 0; i < strings.getStrings().length; i++) {
                if (!strings.getStrings()[i].equals("\"\"")&&(!strings.getStrings()[i].equals(""))) {
                    MainString mainString = new MainString(strings.getStrings()[i], i);
                    map.put(mainString, new HashSet<>());

                }

            }
        }
        for (Line strings : lineSet) {
            for (int i = 0; i < strings.getStrings().length; i++) {
                MainString mainString = new MainString(strings.getStrings()[i],i);
                if (map.containsKey(mainString)) {
                    map.get(mainString).add(strings);
                }
            }
        }

        GroupGenerator groupGenerator = new GroupGenerator();
        groupGenerator.getGroups(map);



    }
}