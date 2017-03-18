import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by andrey-goa on 18.03.17.
 */
public class GroupGenerator {

    public void getGroups(Map<String, Set<Line>> map) {
        Map<Group, Set<Line>> m = new TreeMap<>();
        for (String stk : map.keySet()) {
            if (map.get(stk) != null) {
                Iterator<Line> iterator = map.get(stk).iterator();
                while (iterator.hasNext()) {
                    Line line = iterator.next();
                    for (String stv : line.getStrings()) {
                        if (map.get(stv) != null && !stk.equals((stv)) && !stv.equals("\"\"")) {
                            map.get(stk).addAll(map.get(stv));
                            map.put(stv, null);
                            iterator = map.get(stk).iterator();
                        }
                    }
                }
            }

        }

        for(String stv: map.keySet()){
            if(map.get(stv) != null){
                Group group = new Group(map.get(stv).size());
                m.put(group, map.get(stv));
            }
        }
        printGroups(m);
    }

    private void printGroups(Map<Group, Set<Line>> map) {

        String file = "resources/resault.txt";

        int i = 0;
        int name = 1;
        for (Group g : map.keySet()) {
            g.setName(name);
            name++;
            if (g.getSizeGroup() > 1) {
                i++;
            }
        }

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(i + "\n");
            for (Map.Entry entry : map.entrySet()) {
              Group group = (Group) entry.getKey();
              Set<Line>set = (Set<Line>) entry.getValue();
              bw.write(group.getName() + "\n");
              Iterator<Line> iterator = set.iterator();
            while (iterator.hasNext()) {
                bw.write(iterator.next().printStrings() + "\n");
            }
              bw.write("..." + "\n");

        }

        bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
