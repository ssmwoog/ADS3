
public class Student {
    private String name;
    private String lastName;

    public Student(){}

    public Student(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return "%s %s".formatted(this.name, this.lastName);
    }

    @Override
    public int hashCode() {
        String key = String.valueOf(this.name + " " + this.lastName);
        int code = 0;
        for (int i = 0; i < key.length(); i++) {
            code += (int) key.charAt(i);
        }
        return code;
    }
}
