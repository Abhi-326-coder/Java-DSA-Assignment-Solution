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

    // 9.Maximum Value at a Given Index in a Bounded Array

    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        int left = 0, right = maxSum, mid;
        while (left < right) {
            mid = (left + right + 1) / 2;
            if (test(n, index, mid) <= maxSum)
                left = mid;
            else
                right = mid - 1;
        }
        return left + 1;
    }

    public long test(int n, int index, int a) {
        int b = Math.max(a - index, 0);
        long res = (long)(a + b) * (a - b + 1) / 2;
        b = Math.max(a - ((n - 1) - index), 0);
        res += (long)(a + b) * (a - b + 1) / 2;
        return res - a;
    }

    // 10.Minimum absolute Sum Difference

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int)1e9+7;

        // Sorted copy of nums1 to use for binary search
        int[] snums1 = nums1.clone();
        Arrays.sort(snums1);

        int maxDiff = 0;    // maximum difference between original and new absolute diff
        int pos = 0;        // where the maximum difference occurs
        int newn1 = 0;      // nums1 value to copy to nums1[pos]

        // For each array position i from 0 to n-1, find up to two elements
        // in nums1 that are closest to nums2[i] (one on each side of nums2[i]).
        // Calculate a new absolute difference for each of these elements.
        for (int i=0; i<nums2.length; i++) {
            int n2 = nums2[i];
            int origDiff = Math.abs(nums1[i] - n2);

            // Find the largest element in nums1 that is less than or equal to
            // the current element in nums2, if such an element exists.
            int floor = arrayFloor(snums1, n2);
            if (floor > Integer.MIN_VALUE) {
                // If a valid element exists, calculate a new absolute difference
                // at the current position, and calculate how much smaller this is
                // than the current absolute difference. If the result is better
                // than what we have seen so far, update the maximum difference and
                // save the data for the current position.
                int newDiff = Math.abs(floor - n2);
                int diff = origDiff - newDiff;
                if (diff > maxDiff) {
                    pos = i;
                    newn1 = floor;
                    maxDiff = diff;
                }
            }

            // Find the smallest element in nums1 that is greater than or equal to
            // the current element in nums2, if such an element exists.
            int ceiling = arrayCeiling(snums1, n2);
            if (ceiling < Integer.MAX_VALUE) {
                // Same as above
                int newDiff = Math.abs(ceiling - n2);
                int diff = origDiff - newDiff;
                if (diff > maxDiff) {
                    pos = i;
                    newn1 = ceiling;
                    maxDiff = diff;
                }
            }
        }

        // If we found a replacement value, overwrite the original value.
        if (newn1 > 0) {
            nums1[pos] = newn1;
        }

        // Calculate the absolute sum difference with the replaced value.
        int sum = 0;
        for (int i=0; i<nums1.length; i++) {
            sum = (sum + Math.abs(nums1[i] - nums2[i])) % mod;
        }

        return sum;
    }
    // 11.Koko Eating Banana

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours += pile / k;
            if (pile % k != 0) hours++;
        }
        return hours <= h;
    }


    //
    // Array versions of TreeSet.floor and TreeSet.ceiling
    //

    // Greatest element less than or equal to val
    private int arrayFloor(int[] arr, int val) {
        int lo = 0;
        int hi = arr.length-1;
        int max = Integer.MIN_VALUE;

        while (lo <= hi) {
            int mid = lo+(hi-lo)/2;
            if (arr[mid] <= val) {
                max = arr[mid];
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }

        return max;
    }

    // Smallest element greater than or equal to val
    private int arrayCeiling(int[] arr, int val) {
        int lo = 0;
        int hi = arr.length-1;
        int min = Integer.MAX_VALUE;

        while (lo <= hi) {
            int mid = lo+(hi-lo)/2;
            if (arr[mid] >= val) {
                min = arr[mid];
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }

        return min;
    }

}
