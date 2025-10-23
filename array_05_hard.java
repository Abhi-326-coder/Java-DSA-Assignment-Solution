
public class array_05_hard {
    public static void main(String[] args){
        int[][] ans = {{-17, 13}, {2, 1}, {8, -5}, {18, -20}};
        int[] ans1 = {7,8,9,11,12};
        System.out.println(firstMissingPositive(ans1));
    }

    // Max value of the equation
    static int findMaxValueOfEquation(int[][] points, int k) {
        int max = 0;
        int m = points.length;
        // int n = points[0].length;

        for(int i = 1;i<m;i++){
            int eq = points[i][1]+points[i-1][1]+ Math.abs(points[i-1][0]-points[i][1]);
            if( Math.abs(points[i-1][0]-points[i][1]) <= k ){
                if( eq > max )  max = eq ;
            }
            System.out.println(eq);
        }
        return max;
    }

    // First Missing Positive

    static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n + 1]; // Array for lookup

        // Mark the elements from nums in the lookup array
        for (int num : nums) {
            if (num > 0 && num <= n) {
                seen[num] = true;
            }
        }

        // Iterate through integers 1 to n
        // return smallest missing positive integer
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                return i;
            }
        }

        // If seen contains all elements 1 to n
        // the smallest missing positive number is n + 1
        return n + 1;
    }
}
