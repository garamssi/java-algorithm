package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1244
 * 스위치 켜고 끄기
 */
public class B_스위치켜고끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int switchCount = Integer.parseInt(bf.readLine());
        String[] switchStatus = bf.readLine().split(" ");
        int studentCount = Integer.parseInt(bf.readLine());

        for (int i = 0; i < studentCount; i++) {
            String[] studentArray = bf.readLine().split(" ");
            String gender = studentArray[0];
            int switchNumber = Integer.parseInt(studentArray[1]);

            if("1".equals(gender)) { // 남자

                for (int j = 0; j < switchCount; j++) {
                    if((j + 1) % switchNumber == 0) {   // switchNumber 의 배수
                        switchStatus[j] = switchStatusChange(switchStatus[j]);
                    }
                }

            }else { // 여자
                int left = switchNumber - 1 - 1;
                int right = switchNumber + 1 - 1;

                while(left >= 0 && right <= switchCount - 1) {
                    if(switchStatus[left].equals(switchStatus[right])) {
                        switchStatus[left] = switchStatusChange(switchStatus[left]);
                        switchStatus[right] = switchStatusChange(switchStatus[right]);

                        left--;
                        right++;

                    }else {
                        break;
                    }
                }
            }
        }

        System.out.println(String.join(" ", switchStatus));
    }

    // 스위치 상태 변경
    private static String switchStatusChange(String switchStatus) {
        return "0".equals(switchStatus) ? "1" : "0";
    }
}
