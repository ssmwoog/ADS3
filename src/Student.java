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
        int hash = 0;
        String key = this.name + " " + this.lastName;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * 31) + key.charAt(i);
        }
        return hash;
    }
}