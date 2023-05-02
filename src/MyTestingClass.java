public class MyTestingClass {
    private String key;

    public MyTestingClass(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        for (int i = 0; i < key.length(); i++) {
            hash = (31 * hash) + key.charAt(i);
        }
        return hash;
    }
}


