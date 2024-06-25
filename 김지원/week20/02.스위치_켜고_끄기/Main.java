import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();
        int numOfSwitch = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        boolean[] switchStatus = new boolean[numOfSwitch + 1];
        for (int i = 1; i <= numOfSwitch; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                switchStatus[i] = true;
            }
        }

        int numOfPeople = Integer.parseInt(br.readLine());
        int[][] people = new int[numOfPeople + 1][2];
        for (int i = 1; i <= numOfPeople; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }

        t.solution(numOfSwitch, switchStatus, numOfPeople, people);
        t.printResult(numOfSwitch, switchStatus);
    }

    public void solution(int numOfSwitch, boolean[] switchStatus, int numOfPeople, int[][] people) {
        for (int i = 1; i <= numOfPeople; i++) {
            if (people[i][0] == 1) {
                // 남자일 때
                actForMan(numOfSwitch, switchStatus, people[i]);
            } else {
                // 여자일 때
                actForWoman(numOfSwitch, switchStatus, people[i]);
            }
        }
    }

    private void actForWoman(int numOfSwitch, boolean[] switchStatus, int[] people) {
        int interval = 0;
        int curSwitch = people[1];
        while ((curSwitch - interval - 1 >= 1 && curSwitch + interval + 1 <= numOfSwitch)) {
            interval++;
            if ((switchStatus[curSwitch - interval] != switchStatus[curSwitch + interval])) {
                interval--;
                break;
            }
        }
        for (int j = curSwitch - interval; j <= curSwitch + interval; j++) {
            switchStatus[j] = !switchStatus[j];
        }
    }

    private void actForMan(int numOfSwitch, boolean[] switchStatus, int[] people) {
        for (int j = people[1]; j <= numOfSwitch; j += people[1]) {
            switchStatus[j] = !switchStatus[j];
        }
    }

    private void printResult(int numOfSwitch, boolean[] switchStatus) {
        for (int i = 1; i <= numOfSwitch; i++) {
            if (switchStatus[i]) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }

            if (i % 20 == 0) {
                System.out.println();
            } else {
                if (i != numOfSwitch) {
                    System.out.print(" ");
                }
            }
        }
    }

}