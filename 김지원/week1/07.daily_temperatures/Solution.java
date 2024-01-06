class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
    int[] answer = new int[temperatures.length];
        Stack<Temperature> tempStack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!tempStack.isEmpty() && tempStack.peek().getValue() < temperatures[i]) {
                Temperature poppedTemp = tempStack.pop();
                answer[poppedTemp.getDay()] = i - poppedTemp.getDay();
            }
            tempStack.push(new Temperature(temperatures[i], i));
        }

        return answer;
    }

    public class Temperature {
        int value;
        int day;

        public Temperature(int value, int day) {
            this.value = value;
            this.day = day;
        }

        public int getValue() {
            return value;
        }

        public int getDay() {
            return day;
        }
    }
}