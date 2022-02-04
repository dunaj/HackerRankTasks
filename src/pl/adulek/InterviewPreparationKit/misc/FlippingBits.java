package pl.adulek.InterviewPreparationKit.misc;

import java.util.LinkedList;

public class FlippingBits {
    /*
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long flippingBits(long n) {
        long input = n;
        long[] binary = new long[32];
        int index = 0;
        while (input != 0) {
            long remainder = input % 2;
            binary[index] = remainder;
            input/=2;
            index++;
        }
        long multiplier = 1;
        long result = 0;
        for (int i = 0; i < binary.length; ++i) {
            if (binary[i] == 0) {
                result += multiplier;
            }
            multiplier*=2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(flippingBits(2147483647));
        System.out.println(flippingBits(1));
        System.out.println(flippingBits(0));
        System.out.println(flippingBits(4));
        System.out.println(flippingBits(123456));
    }
}
