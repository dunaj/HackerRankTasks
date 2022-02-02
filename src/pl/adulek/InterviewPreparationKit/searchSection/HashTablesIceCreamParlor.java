package pl.adulek.InterviewPreparationKit.searchSection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTablesIceCreamParlor {

    public static void whatFlavors(List<Integer> cost, int money) {
        int firstIndex = 0;
        int secondIndex = 0;
        Map<Integer, Integer> map = new HashMap<>(); // <price, index>
        for (int i = 0; i < cost.size(); ++i) {
            int currentPrice = cost.get(i);
            int difference = money - currentPrice;
            if (map.containsKey(difference)) {
                firstIndex = map.get(difference);
                secondIndex = i;
                break;
            } else {
                map.put(currentPrice, i);
            }
        }
        // the task states that indices are 1-based
        System.out.println(firstIndex +1 + " " + (secondIndex+1));
    }

    public static void main(String[] args) {
        whatFlavors(List.of(1,4,5,3,2), 4);
        whatFlavors(List.of(2,2,4,3), 4);
    }
}
