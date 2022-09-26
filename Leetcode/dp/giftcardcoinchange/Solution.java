package Leetcode.dp.giftcardcoinchange;
import java.util.*;

public class Solution {

    private static Map<String, Integer> dfs(double value, Set<String> memoSet, Map<String, Integer> currProducts, TreeMap<Double, List<String>> products) {
        if(value < 0.0 || memoSet.contains(currProducts.toString())) return null;
        if(value == 0.0) {
            return currProducts;
        }
        for(Map.Entry<Double, List<String>> prod: products.entrySet()) {
            double price = prod.getKey();
            if(value - price >= 0.0) {
                for(String prodName: prod.getValue()) {
                    Map<String, Integer> currProductCopy = new HashMap<>(currProducts);
                    currProductCopy.put(prodName, currProductCopy.getOrDefault(prodName, 0)+1);
                    Map<String, Integer> resVal = dfs(value - price, memoSet, currProductCopy, products);
                    if(resVal != null) return resVal;
                    memoSet.add(currProductCopy.toString());
                }
            }
        }
        return null;
    }

    public static Map<String, Integer> giftCard(double value, Map<String, Double> products) {
        final TreeMap<Double, List<String>> catalog = new TreeMap<>(Comparator.reverseOrder());
        products.forEach((p, v) -> {
            List<String> prods = catalog.getOrDefault(v, new ArrayList<>());
            prods.add(p);
            catalog.put(v, prods);
        });
        return dfs(value, new HashSet<>(), new HashMap<>(), catalog);
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
        Map<String, Integer> giftCards = giftCard(5.00, prices);
        System.out.println(giftCards.toString());
    }

}
