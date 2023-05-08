package gr.aueb.cf.projects;

public class MaxSubArrayApp {

    public static void main(String[] args) {
        int maximum = 0;

        int arr[] =  {-2, 1,-3,4,-1, 2, 1,-5, 4};

        maximum = maxSubArray(arr);

        System.out.println(maximum);
    }


    public static int maxSubArray(int[] arr) {

        int globalMaximum = Integer.MIN_VALUE;
        int first = 0;
        int last = 0;



        for (int i = 0; i < arr.length; i++) {
            int localMaximum = 0;
            for (int j = i; j < arr.length; j++) {
                localMaximum += arr[j];

                if (localMaximum > globalMaximum) {
                    globalMaximum = localMaximum;
                    first = i;
                    last = j;
                }
            }
        }
        return globalMaximum;
    }
}
