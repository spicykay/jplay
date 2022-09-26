package Leetcode.dp.giftcardcoinchange;
import java.util.*;

public class Solution {

    private static void dfs(double value, List<Map<String, Integer>> res, Set<String> memoSet, Map<String, Integer> currProducts, TreeMap<String, Double> products) {
        if(value < 0.0 || memoSet.contains(currProducts.toString())) return;
        if(value == 0.0) {
            res.add(currProducts);
            return;
        }
        for(Map.Entry<String, Double> prod: products.entrySet()) {
            double price = prod.getValue();
            if(value - price >= 0.0) {
                Map<String, Integer> currProductCopy = new HashMap<>(currProducts);
                currProductCopy.put(prod.getKey(), currProductCopy.getOrDefault(prod.getKey(), 0)+1);
                dfs(value - price, res, memoSet, currProductCopy, products);
                memoSet.add(currProductCopy.toString());
            }
        }
    }

    public static List<Map<String, Integer>> giftCard(double value, Map<String, Double> products) {
        List<Map<String, Integer>> res = new ArrayList<>();
        final TreeMap<String, Double> catalog = new TreeMap<>(products);
        dfs(value, res, new HashSet<>(), new HashMap<>(), catalog);
        return res;
    }

    public static void main(String[] args) {
        Map<String, Double> prices = Map.ofEntries(
            Map.entry("sandwich", 6.85),
            Map.entry("toast", 2.20),
            Map.entry("curry", 7.85),
            Map.entry("egg", 3.20),
            Map.entry("cheese", 1.25),
            Map.entry("coffee", 1.40),
            Map.entry("soup", 3.45),
            Map.entry("soda", 2.05)
        );
        List<Map<String, Integer>> giftCards = giftCard(5.00, prices);
        giftCards.forEach(c -> System.out.println(c));
    }

}
