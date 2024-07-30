import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] levels = new int[p];
        String[] ids = new String[p];

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            levels[i] = Integer.parseInt(st.nextToken());
            ids[i] = st.nextToken();
        }

        String result = new Main().solution(p, m, ids, levels);
        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }

    private String solution(int p, int m, String[] ids, int[] levels) {
        List<Player> players = new ArrayList<>();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            players.add(new Player(ids[i], levels[i]));
        }

        for (Player player : players) {
            if (rooms.isEmpty()) {
                Room room = new Room(player.level, m, player);
                rooms.add(room);
                continue;
            }

            Optional<Room> foundRoom = findRoom(rooms, player);
            foundRoom.ifPresentOrElse(
                    room -> room.enter(player),
                    () -> {
                        Room newRoom = new Room(player.level, m, player);
                        rooms.add(newRoom);
                    }
            );
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            sb.append(room);
        }
        return sb.toString();
    }

    private Optional<Room> findRoom(List<Room> rooms, Player player) {
        return rooms.stream().filter(room -> room.isEnter(player)).findFirst();
    }

    static class Player implements Comparable<Player> {
        private final String id;
        private final int level;

        public Player(String id, int level) {
            this.id = id;
            this.level = level;
        }

        @Override
        public int compareTo(Player o) {
            return this.id.compareTo(o.id);
        }

        @Override
        public String toString() {
            return level + " " + id;
        }
    }

    static class Room {
        private final int firstPlayerLevel;
        private final int maxCapacity;

        Queue<Player> players = new PriorityQueue<>();

        public Room(int firstPlayerLevel, int maxCapacity, Player player) {
            this.firstPlayerLevel = firstPlayerLevel;
            this.maxCapacity = maxCapacity;
            this.players.offer(player);
        }

        public boolean isEnter(Player player) {
            return players.size() < maxCapacity
                    && Math.abs(firstPlayerLevel - player.level) <= 10;
        }

        public void enter(Player player) {
            players.offer(player);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (players.size() < maxCapacity) {
                sb.append("Waiting!").append("\n");
            } else {
                sb.append("Started!").append("\n");
            }

            while (!players.isEmpty()) {
                Player player = players.poll();
                sb.append(player).append("\n");
            }

            return sb.toString();
        }
    }
}