import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();

        int n = Integer.parseInt(br.readLine());
        List<Person> personList = new ArrayList<>();

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            personList.add(new Person(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        t.solution(personList);
    }

    public void solution(List<Person> personList) {
        for (Person person : personList) {
            int rank = 1;
            for (Person other : personList) {
                if (other.graterThan(person)) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }

    public static class Person {
        private int height;
        private int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }

        public boolean graterThan(Person other) {
            return this.height > other.height && this.weight > other.weight;
        }
    }
}