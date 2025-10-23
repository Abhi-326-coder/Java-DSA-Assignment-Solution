import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class array_05_medium {
    public static void main(String[] args) {
        int[] ans = {2,0,2,1,1,0};

//        System.out.println(Arrays.toString(sortColors(ans)));
//        System.out.println(canJump(ans));
        sortColors(ans);
    }

    // Spiral Matrix

    static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Top row
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // Right column
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                // Bottom row
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // Left column
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }

    // spiral Matrix I
    static int spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        int num = 1;

        while (top <= bottom && left <= right) {
            // Top row
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            // Right column
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            if (top <= bottom) {
                // Bottom row
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }

            if (left <= right) {
                // Left column
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        return num;
    }

    // Spiral matrix III

    static int[][] spiralMatrix1III(int rows, int cols, int rStart, int cStart) {
        // Store all possible directions in an array.
        int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[][] traversed = new int[rows * cols][2];
        int idx = 0;

        // Initial step size is 1, value of d represents the current direction.
        for (int step = 1, direction = 0; idx < rows * cols;) {
            // direction = 0 -> East, direction = 1 -> South
            // direction = 2 -> West, direction = 3 -> North
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < step; ++j) {
                    // Validate the current position
                    if (
                            rStart >= 0 &&
                                    rStart < rows &&
                                    cStart >= 0 &&
                                    cStart < cols
                    ) {
                        traversed[idx][0] = rStart;
                        traversed[idx][1] = cStart;
                        ++idx;
                    }
                    // Make changes to the current position.
                    rStart += dir[direction][0];
                    cStart += dir[direction][1];
                }

                direction = (direction + 1) % 4;
            }
            ++step;
        }
        return traversed;
    }

    // Spiral Matrix III

    static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int n = rows * cols;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] res = new int[n][2];
        res[0][0] = rStart;
        res[0][1] = cStart;
        int count = 0;
        int index = 1;
        int step = 1;
        while (count < n) {
            for (int times = 0; times < 2; times++) {
                int dr = directions[index % 4][0];
                int dc = directions[index % 4][1];
                for (int i = 0; i < step; i++) {
                    rStart += dr;
                    cStart += dc;
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        res[count][0] = rStart;
                        res[count][1] = cStart;
                        count++;
                    }
                }
                index++;
            }
            step++;
        }
        return res;
    }

    // Set matrix Zeroes

    static void setZeroes(int[][] matrix) {
        boolean fr = false,fc = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }}
        }
        if(fr) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // Set Matrix zeroes

//    static void setZeroes(int[][] matrix){
//        int n = matrix.length;
//
//    }

    // Product of Array Except Self
    
    static int[] productExceptSelf(int[] nums) {
        int numsLength = nums.length;
        int prefixProduct = 1;
        int suffixProduct = 1;
        int[] result = new int[numsLength];
        for(int i = 0; i < numsLength; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }
        for(int i = numsLength-1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        return result;
    }

    // Find First and Last Position of Element in Sorted Array

    static int[] searchRange(int[] nums, int target) {
        int first =findFirst(nums,target);
        int last  =findLast(nums,target);
        return new int[] {first,last};
    }
    static int findFirst(int[] nums,int target){
        int low=0, high=(nums.length-1);
        int result = -1;
        while(low<=high){
            int mid = low + (high-low)/2 ;
            if(nums[mid] == target){
                result = mid;
                high = mid -1; // left
            }else if(target < nums[mid]){
                high = mid -1;
            }else if (target > nums[mid]){
                low = mid +1;
            }
        }
        return result;
    }
    static int findLast(int[] nums,int target){
        int low=0, high=(nums.length-1);
        int result = -1;
        while(low<=high){
            int mid = low + (high-low)/2 ;
            if(nums[mid] == target){
                result = mid;
                low = mid +1; // right
            }else if(target < nums[mid]){
                high = mid -1;
            }else if (target > nums[mid]){
                low = mid +1;
            }
        }
        return result;
    }

    //  Jump game

    static boolean canJump(int[] nums) {
        int farthest = 0;  // the farthest index we can reach

        // loop through each index
        for (int i = 0; i < nums.length; i++) {
            // if current index is beyond what we can reach, stop
            if (i > farthest) {
                return false;
            }

            // update farthest index we can reach
            farthest = Math.max(farthest, i + nums[i]);
        }

        // if loop finishes, it means we can reach the last index
        return true;
    }

    // Sort colors

    static void sortColors(int[] nums) {
        int low = 0;               // boundary for 0's
        int mid = 0;               // current element
        int high = nums.length - 1; // boundary for 2's

        while (mid <= high) {
            if (nums[mid] == 0) {
                // swap nums[low] and nums[mid]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            }
            else if (nums[mid] == 1) {
                mid++; // leave it as it is
            }
            else { // nums[mid] == 2
                // swap nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
                // don't increase mid here
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    // House Robbery

    static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];

        // Base cases
        dp[0] = nums[0];  // only one house
        dp[1] = Math.max(nums[0], nums[1]); // choose the richer of first two houses

        // Fill dp array
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    //
    
}
