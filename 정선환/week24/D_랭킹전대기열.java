package week24;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/20006
 * 랭킹전 대기열
 */
public class D_랭킹전대기열 {

    static List<Room> rooms = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer line1 = new StringTokenizer(bf.readLine(), " ");
        int p = Integer.parseInt(line1.nextToken());
        int m = Integer.parseInt(line1.nextToken());

        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            if(rooms.isEmpty()) {
                makeRoom(level, nickname);
            }else {
                join(m, new Player(level, nickname));
            }
        }

        for (Room room : rooms) {
            PriorityQueue<Player> players = room.players;
            if(players.size() < m) {
                bw.write("Waiting!\n");
            }else {
                bw.write("Started!\n");
            }

            while(!players.isEmpty()) {
                Player poll = players.poll();

                bw.write(poll.getLevel() + " " + poll.getNickName() + "\n");
            }
        }

        bf.close();
        bw.flush();
        bw.close();

    }

    // 방 만들기
    private static void makeRoom(int level, String nickName) {
        PriorityQueue<Player> players = new PriorityQueue<>(new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return p1.getNickName().compareTo(p2.getNickName());
            }
        });
        players.offer(new Player(level, nickName));

        int minLevel = Math.max(1, level -10);
        int maxLevel = Math.min(500, level + 10);

        rooms.add(new Room(minLevel, maxLevel, players));
    }

    // 방 참여
    private static void join(int m, Player player) {
        boolean isJoin = false;
        for (Room room : rooms) {

            // 정원이 찼다면, 다음 방 탐색
            if(room.players.size() >= m) {
                continue;
            }

            // 레벨이 -10, +10 범위를 벗어난 경우, 다음 방 탐색
            int level = player.getLevel();
            if(level < room.getMinLevel() || level > room.getMaxLevel()) {
                continue;
            }

            // 현재 플레이어에 추가
            PriorityQueue<Player> joinedPlayers = room.getPlayers();
            joinedPlayers.offer(player);

            isJoin = true;
            break;
        }

        if(!isJoin) {
            makeRoom(player.getLevel(), player.getNickName());
        }
    }

    static class Room {
        private int minLevel;
        private int maxLevel;
        private PriorityQueue<Player> players;

        public Room(int minLevel, int maxLevel, PriorityQueue<Player> players) {
            this.minLevel = minLevel;
            this.maxLevel = maxLevel;
            this.players = players;
        }

        public int getMinLevel() {
            return minLevel;
        }

        public int getMaxLevel() {
            return maxLevel;
        }

        public PriorityQueue<Player> getPlayers() {
            return players;
        }


        public void updatePlayers(PriorityQueue<Player> players) {
            this.players = players;
        }

    }


    static class Player {
        private int level;
        private String nickName;

        public Player(int level, String nickName) {
            this.level = level;
            this.nickName = nickName;
        }

        public int getLevel() {
            return level;
        }

        public String getNickName() {
            return nickName;
        }
    }

}
