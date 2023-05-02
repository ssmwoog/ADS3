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
        final int prime = 31;
        int result = 1;
        result = prime * result + (( g == null) ? 0 : g.hashCode());
        return result;
    }
}