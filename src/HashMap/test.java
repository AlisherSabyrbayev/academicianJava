package HashMap;

import java.util.TreeMap;

public class test {
    public static void main(String[] args) {
        TreeMap<String, Integer> leaderboard = new TreeMap<>();
        leaderboard.put("Alice", 150);
        leaderboard.put("Bob", 200);
        leaderboard.put("Charlie", 100);

        for (String player: leaderboard.keySet()) {
            System.out.println(player + ": " + leaderboard.get(player));
        }
    }
}
