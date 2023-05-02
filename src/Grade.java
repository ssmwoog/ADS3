public class Grade {
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
        int hash = 0;
        String key = this.g;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * 31) + key.charAt(i);
        }
        return hash;
    }
}