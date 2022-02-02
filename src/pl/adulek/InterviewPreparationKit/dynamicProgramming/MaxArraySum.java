package pl.adulek.InterviewPreparationKit.dynamicProgramming;


public class MaxArraySum {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int[] maxSums = new int[arr.length];
        maxSums[0] = arr[0];
        int currSum = Math.max(arr[0], arr[1]);
        maxSums[1] = currSum;
        for (int i = 2; i < arr.length; ++i) {
            currSum = Math.max(arr[i], currSum);
            currSum = Math.max(arr[i] + maxSums[i-2], currSum);
            maxSums[i] = currSum;
        }
        return maxSums[arr.length-1];
    }


    // Complete the maxSubsetSum function below.
    static int maxSubsetSumRecursive(int[] arr) {
        int[] maxSums = new int[arr.length];
        maxSubsetSumRec(arr, maxSums, 0, 0);
        maxSubsetSumRec(arr, maxSums, 1, 0);

        int max = 0;
        for (Integer i : maxSums) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    static void maxSubsetSumRec(int[] arr, int[] maxSums, int currentIndex, int currentSum) {
        if (currentSum + arr[currentIndex] > maxSums[currentIndex]) {
            maxSums[currentIndex] = currentSum + arr[currentIndex];
        }
        if (currentIndex == arr.length-1) {
            return;
        }
        if (currentIndex + 2 < arr.length)
        maxSubsetSumRec(arr, maxSums, currentIndex + 2, maxSums[currentIndex]);

        if (currentIndex + 3 < arr.length)
        maxSubsetSumRec(arr, maxSums, currentIndex + 3, maxSums[currentIndex]);

    }

    public static void main(String[] args) {
        System.out.println(maxSubsetSum(new int[]{3, 7, 4, 6, 5}));
        System.out.println(maxSubsetSum(new int[]{2, 1, 5, 8, 4}));
        System.out.println(maxSubsetSum(new int[]{3, 5, -7, 8, 10}));
    }
}
