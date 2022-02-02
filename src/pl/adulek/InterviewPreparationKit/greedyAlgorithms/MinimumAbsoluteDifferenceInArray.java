package pl.adulek.InterviewPreparationKit.greedyAlgorithms;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinimumAbsoluteDifferenceInArray {

    /*
     * Complete the 'minimumAbsoluteDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        List<Integer> sortedList = arr.stream().sorted().collect(Collectors.toList());
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < sortedList.size()-1; ++i) {
            int diff = absDiff(sortedList.get(i), sortedList.get(i+1));
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    static int absDiff(int smallerInt, int biggerInt) {
        return biggerInt - smallerInt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> intList = Stream.of(bufferedReader.readLine()
                .replace("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = minimumAbsoluteDifference(intList);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
