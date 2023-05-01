public class Main {
    public static void main(String[] args) {
        MyHashTable<Grade, Student> t = new MyHashTable<>(10000);
        for (int i = 0; i < 10000; i++){
            Grade g = new Grade(Integer.toString(i));
            Student stud = new Student("Student %d".formatted(i), "Student %d".formatted(i));
            t.put(g, stud);
        }
        t.printBucketSizes();
    }
}
