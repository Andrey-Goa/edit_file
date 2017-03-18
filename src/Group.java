import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by andrey-goa on 18.03.17.
 */
public class Group implements Comparable<Group>{
    private Integer sizeGroup;
    private String name;

    public Group(int size){
        sizeGroup = size;
    }
    public int getSizeGroup() {
        return sizeGroup;
    }

    public void setSizeGroup(int sizeGroup) {
        this.sizeGroup = sizeGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(int name) {
        this.name = "Группа " + name;
    }

    @Override
    public int compareTo(Group o) {
        if(sizeGroup > o.getSizeGroup()){
            return -1;
        }else{
            return 1;
        }
    }
}
