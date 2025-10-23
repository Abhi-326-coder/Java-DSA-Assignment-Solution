import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class array_05_easy {

    public static void main(String[] args) {
        //[[2,8,7],[7,1,3],[1,9,5]]
        int[][] nums = {{3,7,8}, {9,11,13}, {15,16,17}};
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        int[] arr1 = {1,2,0,0};
        List<Integer> ans = new ArrayList<>(9);

//        System.out.println((addToArrayForm(arr1,n)));
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    // Build Array from Permutation

    static int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    // Concatenation of Array

    static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];       // first copy
            ans[i + n] = nums[i];   // second copy
        }
        return ans;
    }

    // Running Sum of 1d Array

    static int[] runningSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
            nums[i] = sum;
        }
        return nums;
    }

    // Richest Customer Wealth

    static int maximumWealth(int[][] accounts) {
        int n = accounts.length;
        int[] ans = new int[n];
        for (int i = 0; i < accounts.length; i++) {
            ans[i] = sumOfArray(accounts[i]);
        }
        return maxOfArray(ans);

    }

    static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    static int maxOfArray(int[] arr) {
        int max = arr[0];  
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    static int minofArray(int[]arr){
        int min = arr[0];  
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    // Shuffle the Array

    static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];       // x1, x2, x3...
            ans[2 * i + 1] = nums[n+i]; // y1, y2, y3...
        }
        return ans;
    }

    // Kids With the Greatest Number of Candies

    static boolean[] kidsWithCandies1(int[] candies, int extraCandies) {
        int n = candies.length;
        int[] ans = new int[n];
        int i = 0;
        for(int ele:candies){
            ans[i] = ele+extraCandies;
            i++;
        }
        int max = maxOfArray(candies);
        boolean[] newans = new boolean[n];
        for (int j = 0; j < n; j++) {
            if(ans[j] >= max){
                newans[j] = true;
            }else{
                newans[j] = false;
            }
        }
        return newans;
    }
    public List<Boolean> kidsWithCandies2(int[] candies, int extraCandies) {
        int max= 0;
        for(int candy:candies){
            max = Math.max(candy,max);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int candy: candies){
            ans.add(candy + extraCandies >= max);
        }
        return ans;
    }

    // Number of Good Pairs

    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int noOfGoodPair = 0;
        for(int i = 0;i<n;i++){
            for (int j=0;j<n;j++){
                // if(i==j) break;
                if(nums[i] == nums[j] && i < j ){
                    noOfGoodPair++;
                }
            }
        }
        return noOfGoodPair;
    }

    // How Many Numbers Are Smaller Than the Current Number

    static int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i<n;i++){
            for(int j=0; j<n;j++){
                if(j!=i && nums[j] < nums[i] )
                ans[i]++;
            }
        }
        return ans;
    }

    // Create Target Array in the Given Order

    static  int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]);
        }
        int[] result = new int[target.size()];
        for (int i = 0; i < target.size(); i++) {
            result[i] = target.get(i);
        }
        return result;
    }   

    // Check if the Sentence Is Pangram

    static boolean checkIfPangram(String sentence) {
        if(sentence.length()<26) return false;
        for(char ch='a';ch<='z';ch++){
            if(sentence.indexOf(ch)<0){
                return false;
            }
        }
        return true;
    }

    // Count Items Matching a Rule

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        int index = 0;

        // Map ruleKey to index
        switch (ruleKey) {
            case "type":
                index = 0;
                break;
            case "color":
                index = 1;
                break;
            case "name":
                index = 2;
                break;
        }

        // Loop through items
        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) {
                ans++;
            }
        }
        return ans;
    }

    // Find the Highest Altitude

    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        // Highest altitude currently is 0.
        int highestPoint = currentAltitude;

        for (int altitudeGain : gain) {
            // Adding the gain in altitude to the current altitude.
            currentAltitude += altitudeGain;
            // Update the highest altitude.
            highestPoint = Math.max(highestPoint, currentAltitude);
        }

        return highestPoint;
    }

    // Flipping an Image

    public int[][] flipAndInvertImage(int[][] image) {
        // Flip and invert in one pass (more efficient)
        for (int i = 0; i < image.length; i++) {
            int left = 0, right = image[i].length - 1;
            while (left <= right) {
                // swap and invert at the same time
                int temp = image[i][left] ^ 1;  // invert using XOR
                image[i][left] = image[i][right] ^ 1;
                image[i][right] = temp;

                left++;
                right--;
            }
        }
        return image;
    }

    //

    public int oddCells(int m, int n, int[][] indices) {
        //Freq of rows and columns to be incremented
        int[] r = new int[m];
        int[] c = new int[n];

        for (int i = 0 ; i < indices.length; i++) {
            r[indices[i][0]]++;
            c[indices[i][1]]++;
        }

        //Count odd rows
        int oddRows = 0;
        for(int i =0; i < m; i++) {
            if(r[i]%2 == 1) {
                oddRows++;
            }
        }

        //count odd columns
        int oddColumns = 0;
        for(int i =0; i < n; i++){
            if(c[i]%2 == 1) {
                oddColumns++;
            }
        }

        //return Final value
        return oddRows * n + oddColumns * m - 2*oddRows*oddColumns;
    }

    // Find Numbers with Even Number of Digits

    static int findNumbers(int[] nums) {
        int count = 0;
        for(int i =0;i<nums.length;i++){
            if(noOfDigits(nums[i])%2==0) count++;
        }
        return count;
    }
    static int noOfDigits(int n){
        int digit = 0;
        while(n!=0){
            n=n/10;
            digit++;
        }
        return digit;
    }

    //

    static int[][] transpose(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                ans[c][r] = A[r][c];
            }
        return ans;
    }

    // Add to Array-Form of Integer

    static List<Integer> addToArrayForm(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }

    //  Maximum Population Year

        static int maximumPopulation(int[][] logs) {
            int[] year = new int[101];


            for(int i = 0; i<logs.length; i++){
                helper(year,logs[i][0] - 1950,logs[i][1]-1950);

            }
            int max = 0;
            int temp = 0;
            for(int i = 0 ; i< year.length ; i++){
                if(year[i] > max){
                    max = year[i];
                    temp = i;
                }
            }

            return temp+1950;
        }
        static void helper(int[] arr , int b , int d) {
            for (int i = b; i < d; i++) {
                arr[i]++;
            }
        }

    // Determine Whether Matrix Can Be Obtained By Rotation

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int[][] cur = mat;

        for (int k = 0; k < 4; k++) {
            if (equalsMatrix(cur, target)) return true;
            cur = rotate90(cur);
        }
        return false;
    }
    public boolean equalsMatrix(int[][] arr1,int[][] arr2){
        int n=arr1.length;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(arr1[i][j]!=arr2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public int[][] rotate90(int[][] mat){
        int n = mat.length;
        int[][] r = new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                r[i][j]=mat[n-1-j][i];
            }
        }
        return r;
    }

    // Two Sum

    static int[] sumZero(int n) {
        int[] ans=new int[n];
        do{
            for(int i=0;i<n;i++){
                ans[i]=(int)(Math.random()*10);
            }
        }while(sumOfArray(ans)==0);
        return ans;
    }
    static float[] randomArray(int n){
        float[] ans = new float[n];
        for(int i=0;i<n;i++){
            ans[i]=(float)(Math.random()*10);
        }
        return ans;
    }
//    public int sumOfArray(int[] arr){
//        int sum = 0;
//        for(int i =0;i<arr.length;i++){
//            sum = sum +arr[i];
//        }
//        return sum;
//    }

    // Lucky Numbers in a Matrix

    static List<Integer> luckyNumbers(int[][] matrix) {
        int N = matrix.length, M = matrix[0].length;

        List<Integer> rowMin = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int rMin = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                rMin = Math.min(rMin, matrix[i][j]);
            }
            rowMin.add(rMin);
        }

        List<Integer> colMax = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int cMax = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {
                cMax = Math.max(cMax, matrix[j][i]);
            }
            colMax.add(cMax);
        }

        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == rowMin.get(i) && matrix[i][j] == colMax.get(j)) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }

        return luckyNumbers;
    }

    // Maximum Subarray

    class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum = Integer.MIN_VALUE;
            int currentSum = 0;

            for (int i = 0; i < nums.length; i++) {
                currentSum += nums[i];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }

                if (currentSum < 0) {
                    currentSum = 0;
                }
            }

            return maxSum;
        }
    }

    // Reshape the Matrix


        static int[][] matrixReshape(int[][] mat, int r, int c) {
            int m = mat.length;      // Number of rows in original matrix
            int n = mat[0].length;   // Number of columns in original matrix

            // 1. Check if the reshape is possible (total elements must be the same)
            if (m * n != r * c) {
                return mat; // If not possible, return the original matrix
            }

            // 2. Create the new reshaped matrix, correctly initializing all sub-arrays
            int[][] ans = new int[r][c];

            // We use a single counter 'k' to linearize the elements
            // 'k' will keep track of the current element's index in the conceptual 1D stream.
            int k = 0;

            // 3. Iterate through the original matrix to fill the new matrix 'ans'
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // Calculate the row and column in the new matrix 'ans'
                    // using the linear index 'k' and the new number of columns 'c'
                    ans[k / c][k % c] = mat[i][j];
                    k++; // Move to the next element in the conceptual 1D stream
                }
            }

            return ans;
        }

    // Plus One
        // 1. This is my code succed all 3 cases but failed on large integer [9,8,7,6,5,4,3,2,1,0] due to Integer OverFlow
        static int[] plusOne(int[] digits) {
            int n = digits.length;
            int ans = 0;

            // Convert array of digits to a number
            for (int i = 0; i < n; i++) {
                ans = ans * 10 + digits[i];
            }

            ans = ans + 1; // Add 1

            // Count number of digits in the new number
            int a = ans;
            int m = 0;
            while (a != 0) {
                a = a / 10;
                m++;
            }

            // Create new array if size increased (e.g., 999 -> 1000)
            int[] res = new int[m];

            // Fill the result array from the back
            for (int i = m - 1; i >= 0; i--) {
                res[i] = ans % 10;
                ans = ans / 10;
            }

            return res;
        }
    // Real Solution which handles large number > Integer.MAX_VALUE
    static int[] plusOne1(int[] digits) {
        int n = digits.length;

        // Iterate from the rightmost digit to the leftmost
        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9,
            // we can simply increment it and return the array.
            // No further carry is needed.
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If the digit is 9, set it to 0 and continue
            // the loop to carry over 1 to the next digit to the left.
            digits[i] = 0;
        }

        // If the loop completes, it means all digits were 9s (e.g., [9, 9, 9]).
        // In this case, we need a new array with an additional digit at the beginning.
        // For example, [9, 9] becomes [1, 0, 0].
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1; // The new leading digit is 1

        // The remaining elements of newDigits will be 0 by default,
        // which correctly represents the result (e.g., for [9,9], newDigits becomes [1,0,0]).
        return newDigits;
    }

    //  Remove Duplicates from Sorted Array

    static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int write = 1; // First element is always unique
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[write - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write; // Number of unique elements
    }

    //  Minimum Cost to Move Chips to The Same Position

    static int minCostToMoveChips(int[] position) {
        int even=0,odd=0;
        for(int i:position){
            if(i%2==0){
                even++;
            }else{
                odd++;
            }
        }
        if(even==position.length || odd==position.length) return 0;
        return Math.min(even,odd);
    }


}
