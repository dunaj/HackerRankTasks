package pl.adulek.InterviewPreparationKit;

import java.io.*;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        if (r == 1) {
            int n = arr.size();
            return n/6 *(n-1) * (n-2);
        } else {
            long counter = 0;
            for (int i = 0; i < arr.size() - 2; ++i) {
                long current = arr.get(i);
                long[] triplets = new long[3];
                int j = i;
                while (j < arr.size()) {
//                if(arr.get(j)/current == 1) {
//                    triplets[0]++;
//                } else
                    if (arr.get(j) / current == r) {
                        triplets[1]++;
                    } else if (arr.get(j) / current == r * r) {
                        triplets[2]++;
                    } else if (arr.get(j) / current > r * r) {
                        break;
                    }
                    j++;
                }
                counter += triplets[1] * triplets[2];
            }
            return counter;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}