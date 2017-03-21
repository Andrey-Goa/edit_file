import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrey-goa on 20.03.17.
 */
public class MainString {
   private String key;
   private Integer value;


    public MainString(String key, Integer value){
        this.key = key;
        this.value = value;
    }

    public void setSupermap(String key, Integer value) {
       this.key = key;
       this.value = value;
    }

    public String getString(){
        return key;
    }

    public Integer getIndex(){
        return value;
    }
    public int hashCode() {
        final int prime = 19;
        int result = 1;
        result = prime * result + getString().hashCode();
        result = prime * result + getIndex();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MainString other = (MainString) obj;
        if (!(this.getString().equals(other.getString()))) {
            return false;
        }

       if (!(this.getIndex().equals(other.getIndex()))) {
            return false;
        }
        return true;
    }
}
