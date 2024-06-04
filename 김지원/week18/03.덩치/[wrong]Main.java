import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
/*
* 문제의 조건을 잘 살피자

입력값이 낮으므로 정렬 함수를 사용하지 않아도 정답을 구할 수있다.
- 2 ≤ N ≤ 50
- 10 ≤ x, y ≤ 200
 */
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
                    i,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        t.solution(personList);
    }

    public void solution(List<Person> personList) {
        int[] ranks = new int[personList.size()];

        Collections.sort(personList);
        int rank = 1;
        ranks[personList.get(0).getNumber()] = rank;

        for (int i = 1; i < personList.size(); i++) {
            if (!personList.get(i).isAmbiguous(personList.get(i - 1))) {
                rank = i + 1;
            }
            ranks[personList.get(i).getNumber()] = rank;
        }

        for (int i : ranks) {
            System.out.print(i + " ");
        }
    }

    public static class Person implements Comparable<Person> {
        private int number;
        private int height;
        private int weight;

        public Person(int number, int height, int weight) {
            this.number = number;
            this.height = height;
            this.weight = weight;
        }

        public int getNumber() {
            return number;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Person other) {
            if (this.height < other.height && this.weight < other.weight) {
                return 1;
            }

            if (this.height > other.height && this.weight > other.weight) {
                return -1;
            }

            return 0;
        }

        public boolean isAmbiguous(Person person) {
            return this.compareTo(person) == 0;
        }
    }
}