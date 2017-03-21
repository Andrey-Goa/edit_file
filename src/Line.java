/**
 * Created by andrey-goa on 15.03.17.
 */
public class Line {

    private String [] strings = null;

    public void setStrings(String[] strings) {
        if(strings.length == 0){
            String[] strings1 = {"\"\"", "\"\"", "\"\""};
            this.strings = strings1;
        }else if(strings.length <2){
            String[] strings1 = {strings[0], "\"\"", "\"\""};
            this.strings = strings1;
        } else if(strings.length == 2){
            String[] strings2 = {strings[0], strings[1], "\"\""};
            this.strings = strings2;
        } else {
            this.strings = strings;
        }
    }

    public String[] getStrings() {
        return strings;
    }

    @Override
    public int hashCode() {
        final int prime = 19;
        int result = 1;
        result = prime * result + strings[0].hashCode();
        result = prime * result + strings[1].hashCode();
        result = prime * result + strings[2].hashCode();
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
        Line other = (Line) obj;
        if (!(this.getStrings()[0].equals(other.getStrings()[0]))) {
            return false;
        }

        if (!(this.getStrings()[1].equals(other.getStrings()[1]))) {
           return false;
        }

        if (!(this.getStrings()[2].equals(other.getStrings()[2]))) {
           return false;
        }
        return true;
    }
    public String printStrings(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < this.getStrings().length; i++){
            if(i!=this.getStrings().length-1) {
                stringBuilder.append(this.getStrings()[i] + ";");
            } else{
                stringBuilder.append(this.getStrings()[i]);
            }
        }
        String completedString = stringBuilder.toString();
        return completedString;
    }




}

