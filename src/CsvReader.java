import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by andrey-goa on 15.03.17.
 */
public class CsvReader {

    public Set<Line> readFile() throws IOException {
        String csvFile = "resources/lng.csv";
        String line = "";
        String cvsSplitBy = ";";
        Set<Line> setStr = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                Line st = new Line();
                st.setStrings(line.split(cvsSplitBy));
                setStr.add(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return setStr;

    }

}
