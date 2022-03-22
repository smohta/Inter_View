package DynamicProgramming;
import java.util.Map;
import java.util.HashMap;
public class isPermutationPalindrome {
    public static void main(String[] args) {
        // System.out.println("Hello!");
        // int a = 2;
        isPermutationPalindrome obj=new isPermutationPalindrome();
        System.out.println(obj.isPalindromePresent("abbaaccc"));
    }
    public boolean isPalindromePresent(String str) {
        if (str == null)
            return false;
        int n = str.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int odd = 0;
        for (Integer f : map.values()) {
            if (f % 2 == 1)
                odd++;
            if (odd > 1)
                return false;
        }
        return true;
    }
}
