package pl.adulek.javaSection.strings;

public class Anagrams {



    static boolean isAnagram(String a, String b) {
        final int CHARS_IN_ALPHABET = 26;
        if(a.equalsIgnoreCase(b)) {
            return true;
        }
        if (a.length() != b.length()) {
            return false;
        }
        String aLower = a.toLowerCase();
        String bLower = b.toLowerCase();
        int[] aChars = new int[26];
        int[] bChars = new int[26];
        for (int i = 0; i < aLower.length(); ++i) {
            char aChar = aLower.charAt(i);
            char bChar = bLower.charAt(i);
            aChars[aChar - 'a']++;
            bChars[bChar - 'a']++;
        }
        for (int i = 0; i < CHARS_IN_ALPHABET; ++i) {
            if (aChars[i] != bChars[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("", ""));
        System.out.println(isAnagram("aaa", "aaa"));
        System.out.println(isAnagram("aaab", "aaa"));
        System.out.println(isAnagram("aaab", "baaa"));
    }
}
