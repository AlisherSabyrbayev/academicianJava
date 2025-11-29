package HashMap;


import java.util.HashMap;
import java.util.LinkedHashMap;

public class qwerty {
    public static void main(String[] args) {
        HashMap<String, Integer> wordCount = new HashMap<>();

        String text = "apple banana apple orange banana apple";

        String[] words = text.split(" ");

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

            System.out.println(wordCount);
        }
    }
}


//        HashMap<String, Integer> map = new LinkedHashMap<>();
//        map.put("Apple", 1);
//        map.put("Banana", 2);
//        map.put("Cherry", 3);
//        System.out.println("Value for key 'Apple': " + map.get("Apple"));
//
//        for (String key : map.keySet()) {
//            System.out.println(key + ": " + map.get(key));
//        }
//        if (map.containsKey("Banana")) {
//            System.out.println("Banana exist in the map");
//        }
//
//        map.remove("Cherry");
//        System.out.println("Value for key 'Apple': " + map.get("Apple"));
//    }
//}

