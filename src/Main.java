import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(1000);
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass("Key" + i);
            Student value = new Student("Student" + i, "LastName" + i);
            table.put(key, value);
        }

        table.printBucketSizes();
    }
}