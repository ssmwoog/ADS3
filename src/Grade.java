import java.util.Objects;

public class Grade extends Object{
    private String g;
    public Grade(){}

    public Grade(String g){
        this.g = g;
    }

    @Override
    public String toString(){
        return "%s".formatted(this.g);
    }

    @Override
    public int hashCode() {
        String key = String.valueOf(this.g);
        int code = 0;

        for (int i = 0; i < key.length(); i++) {
            code += (int) key.charAt(i);
        }
        return code;
    }

}
