package week7;

import java.util.*;

/**
 * https://leetcode.com/problems/keys-and-rooms/description/?envType=study-plan-v2&envId=leetcode-75
 * 841. Keys and Rooms
 */
public class C_KeysAndRooms {

    public static void main(String[] args) {
        // [2],[],[1]
        // [1],[2],[3],[]
        // [1,3],[3,0,1],[2],[0]
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room = Arrays.asList(1,3);
        rooms.add(room);
        room = Arrays.asList(3,0,1);
        rooms.add(room);
        room = Arrays.asList(2);
        rooms.add(room);
        room = Arrays.asList(0);
        rooms.add(room);

//        List<Integer> room = Arrays.asList(2);
//        rooms.add(room);
//        room = Arrays.asList();
//        rooms.add(room);
//        room = Arrays.asList(1);
//        rooms.add(room);

        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> hasKeyQueue = new ArrayDeque<>();

        // 0번 방 방문
        visited.add(0);
        hasKeyQueue.addAll(rooms.get(0));

        while(!hasKeyQueue.isEmpty()) {
            int roomKey = hasKeyQueue.poll();

            // 방 방문
            if(!visited.contains(roomKey)) {
                visited.add(roomKey);
                hasKeyQueue.addAll(rooms.get(roomKey));
            }
        }

        return visited.size() == rooms.size();
    }
}
