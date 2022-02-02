package pl.adulek.InterviewPreparationKit.DictionariesAndHashMaps;

import java.util.*;

public class SherlockAndAnagrams {

    static class Pair {
        public int first;
        public int second;
        public int length;

        public Pair(int first, int second, int length) {
            this.first = first;
            this.second = second;
            this.length = length;
        }

        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return ((first == pair.first && second == pair.second)
                    || (first == pair.second && second == pair.first))
                    && length == pair.length;
        }

        @Override
        public int hashCode() {
            return first + second + length;
        }
    }

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int sherlockAndAnagrams2(String s) {
        final int sLength = s.length();
        Set<Pair> pairSet = new HashSet<>();
        for (int firstIndex = 0; firstIndex < sLength - 1; ++firstIndex ) {
            for (int secondIndex = firstIndex +1; secondIndex < sLength; ++secondIndex) {
                for (int wordLength = 0; wordLength <= (sLength - firstIndex - 1); wordLength++) {
                    String mainWord = s.substring(firstIndex, firstIndex+wordLength+1);
                    if (secondIndex - wordLength >= 0 && secondIndex -  wordLength != firstIndex) {
                        String backWord = s.substring(secondIndex - wordLength, secondIndex +1);
                        if (isAnagram(mainWord, backWord)) {
                            pairSet.add(new Pair(secondIndex - wordLength, firstIndex, wordLength));
                        }
                    }
                    if (secondIndex + wordLength < sLength) {
                        String forwardWord = s.substring(secondIndex, secondIndex + wordLength);
                        if (isAnagram(mainWord, forwardWord)) {
                            pairSet.add(new Pair(firstIndex, secondIndex + wordLength, wordLength));
                        }
                    }
                }
            }
        }
        return pairSet.size();
    }

    private static boolean isAnagram(String a, String b) {
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

    public static int sherlockAndAnagrams(String s) {
        int inputLength = s.length();
        Map<String, Integer> strMap = new HashMap<>();
        for (int firstIndex = 0; firstIndex < inputLength; ++firstIndex) {
            for (int secondIndex = firstIndex + 1; secondIndex <= inputLength; ++secondIndex) {
                String word = s.substring(firstIndex, secondIndex);
                char arrWord[] = word.toCharArray();
                Arrays.sort(arrWord);
                word = new String(arrWord);
                if (strMap.containsKey(word)) {
                    int newQuantity = strMap.get(word) +1;
                    strMap.put(word, newQuantity);
                } else {
                    strMap.put(word, 1);
                }
            }
        }
        int nAnagrams = 0;
        for (String key : strMap.keySet()) {
            nAnagrams += nMinusOneSum(strMap.get(key));
        }
        return nAnagrams;
    }

    private static int nMinusOneSum(Integer integer) {
        int sum = 0;
        for (int i = 1; i <= integer -1; ++i) {
            sum+=i;
        }
        return sum;

    }

    public static void main(String[] args) {
//        Pair aPair = new Pair (0,1,2);
//        Pair bPair = new Pair (1,0,2);
//        System.out.println(aPair.hashCode());
//        System.out.println(bPair.hashCode());
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
        System.out.println(sherlockAndAnagrams("kkkk"));
        System.out.println(sherlockAndAnagrams("abba"));
        System.out.println(sherlockAndAnagrams("abcd"));
        System.out.println(sherlockAndAnagrams("cdcd"));
    }
}
