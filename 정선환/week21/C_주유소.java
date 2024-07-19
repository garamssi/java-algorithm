package week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/13305
 * 주유소
 */
public class C_주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Integer> distanceList = Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> cityList = Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        long totalPrice = 0;
        long minPrice = cityList.get(0); // 첫 도시 기름 가격

        for(int i = 0; i < n - 1; i++) {
            // 현재 도시의 기름 가격이 더 싼 경우,
            if(cityList.get(i) < minPrice) {
                minPrice = cityList.get(i);
            }

            totalPrice += (minPrice * distanceList.get(i));
        }

        System.out.println(totalPrice);
    }


}
