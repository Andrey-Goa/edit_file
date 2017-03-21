import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by andrey-goa on 18.03.17.
 */
public class GroupGenerator {

    public void getGroups(Map<MainString, Set<Line>> map) {
        Map<Group, Set<Line>> m = new TreeMap<>();
        for (MainString stk : map.keySet()) {
            if(map.get(stk)!= null){
           List<Line> arLine = new ArrayList<>(map.get(stk));
                for(int j = 0; j<arLine.size(); j++) {
                    Line line = arLine.get(j);
                    for (int i = 0; i < line.getStrings().length; i++) {
                        if (!line.getStrings()[i].equals("\"\"") && (!line.getStrings()[i].equals(""))) {
                            MainString mainString1 = new MainString(line.getStrings()[i], i);
                            if (map.get(mainString1) != null && map.containsKey(mainString1) && !(mainString1.equals(stk))) {
                                map.get(stk).addAll(map.get(mainString1));
                                arLine.addAll(map.get(mainString1));
                                map.put(mainString1, null);
                            }
                        }

                    }
                }
            }
        }



     for (MainString stv : map.keySet()) {
         if(map.get(stv) != null) {
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
