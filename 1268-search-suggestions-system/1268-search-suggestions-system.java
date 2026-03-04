import java.util.*;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        
        String prefix = "";
        
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            List<String> suggestions = new ArrayList<>();
            
            int index = lowerBound(products, prefix);
            
            for (int i = index; i < products.length && suggestions.size() < 3; i++) {
                if (products[i].startsWith(prefix)) {
                    suggestions.add(products[i]);
                } else {
                    break;
                }
            }
            
            result.add(suggestions);
        }
        
        return result;
    }
    
    private int lowerBound(String[] products, String target) {
        int left = 0, right = products.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (products[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
