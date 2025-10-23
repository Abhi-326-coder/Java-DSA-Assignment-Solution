import java.util.Arrays;

public class Searching_medium {
    public static void main(String[] args) {
    int[] ans = {2,5,6,0,0,1,2};
    System.out.println(reachNumber(-1));
    Arrays.sort(ans);
//    System.out.println(Arrays.toString(ans));
    }

    // Searching Medium Problems

    // 1.Find First and Last Position of Element in Sorted Array

    static int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[] {-1,-1};
        }
        int n = nums.length;
        int s = 0, l = n-1, m ,j=0;
        int[] ans = new int[2];

        while(s<=l){
            m = s + (l-s)/2;
            if(nums[m] == target){
                ans[j] = m;
                j++;
                if(ans.length==2){
                    return ans;
                }
            }else if(nums[m] > target){
                l = m-1;
            }else{
                s = m+1;
            }
        }
        if(ans[0]==0 && ans[1]==0){
            return new int[] {-1,-1};
        }
        return ans;
    }

    // 2.Single Element in a Sorted Array

    static int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if( (mid % 2 == 0 && nums[mid] == nums[mid +1]) || (mid %2 == 1 && nums[mid] == nums[mid - 1]) )
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }


    // 3.Search in rotated Sorted Array

    static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1; // start searching in the left
                } else {
                    left = mid + 1;  // start searching in the right
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1; //
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
    // 4.Search in rotated Sorted Array II

    static boolean search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] == nums[left]) {
                left++;
                continue;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    // 5.Find minimum in Rotated Sorted Array


    static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }

    // 6.Find Peak Element

    static int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 1, high = n - 2;
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // 7.Find Right Interval

    // 8. Reach Number

    static int reachNumber(int target) {
        //convert negative target to positive
        if(target < 0) {
            target *= -1;
        }

        int start = 0;
        int end = target;
        int move = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            long sum = (long) mid * (mid + 1) / 2;

            if (sum >= target) {
                move = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        long sum = (long) move * (move + 1) / 2;

        while ((sum - target) % 2 != 0) {
            move++;
            sum += move;
        }

        return move;
        
    }

    static int reachNumber1(int target) {
        target = Math.abs(target); // Target can be negative
        int sum = 0, steps = 0;

        while (sum < target || (sum - target) % 2 != 0) {
            steps++;
            sum += steps;
        }
        return steps;
    }




}
