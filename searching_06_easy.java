import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class searching_06_easy {
    public static void main(String[] args) {
        int[] ans = {2,7,11,15};

//        System.out.println(Arrays.toString(twoSum(ans,9)));
        char[] arr = {'c','f','j'};
        int[] arr1 = {23,32,443,2,3,4,7,11};

        Arrays.sort(arr1);
        System.out.println();
        List<Integer> areer = new ArrayList<>();
        int[] a={1,1};
        int[] b={2,2};
//        System.out.println(Arrays.toString(fairCandySwap(a,b)));
        System.out.println(specialArray(new int[] {3,4}));
    }
    // Easy LeetCode questions

    // 1.sqrt(x)

    static int mySqrt(int x) {
        if(x==0 || x==1)
            return x;

        int start = 1;
        int end = x;
        int mid = -1;

        while(start <= end){
            mid = start +(end-start) / 2;
            if((long)mid*mid >(long)x){
                end = mid-1;
            }else if(mid*mid==x){
                return mid;
            }else{
                start = mid +1;
            }
        }
        return Math.round(end);
    }

    // 2.Guess number Higher or Lower

    static int guessNumber(int n) {
        int start = 1;
        int end = n;
        int mid =-1;
        while(start <= end){
            mid = start +(end-start)/2;
            if(guess(mid)==0){
                return mid;
            }else if(guess(mid)==-1){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return mid;
    }
    static int guess(int n){
        // This function is given by the leetcode checkout We know only what is returns on the pick
        return n;
    }

    // 3.First bad Version

    static int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (!isBadVersion(m)) l = m + 1;
            else r = m;
        }
        return r;
    }
    static boolean isBadVersion(int m){
        return true;
    }

    // 4.Two Sum II - input array is sorted

    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((numbers[i]+numbers[j])==target){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[]{-1,-1};
    }

    // 5.Valid Perfect Square

    // 6.Arranging Coins

    static int arrangeCoins(int n) {
        // if(n==1) return 0;
        int i =1;
        while(true){
            n=n-i;
            // if(n==0) return 0;
            if(n<0) {
                return i-1;
            }
            i++;
        }
    }

    // 7.Find Smallest Letter Greater Than Target

    static char nextGreatestLetter(char[] letters, char target) {
        int low=0, high=letters.length -1;
        int mid;
        int pos=-1;
        while(low<=high)
        {
            mid = (low+high)/2;
            if(letters[mid]>target)
            {
                pos=mid;
                high = mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return pos == -1 ? letters[0] : letters[pos];

    }
    // 8.Kth Missing Positive Number

    static int findKthPositive(int[] A, int k) {
        int l = 0, r = A.length, m;
        while (l < r) {
            m = (l + r) / 2;
            if (A[m] - 1 - m < k)
                l = m + 1;
            else
                r = m;
        }
        return l + k;
    }

    // 9.Search Insert Position

    static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        // 'ans' will store the potential insertion index.
        // Initialize it to nums.length to handle the case where target is
        // greater than all elements and should be inserted at the very end.
        int ans = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate mid-point safely

            if (nums[mid] == target) {
                return mid; // Target found, return its index
            } else if (nums[mid] < target) {
                // If nums[mid] is less than target, target must be in the right half.
                // We discard mid and the left half, so search from mid + 1.
                low = mid + 1;
            } else { // nums[mid] > target
                // If nums[mid] is greater than target, then mid is a potential
                // insertion point (ans), and target might be in the left half
                // (before mid). So, we record mid as a possible answer and
                // search in the left half by setting high = mid - 1.
                ans = mid;
                high = mid - 1;
            }
        }
        // If the loop finishes, target was not found.
        // 'ans' now holds the correct insertion index:
        // - It's the index of the first element >= target.
        // - Or it's nums.length if target is > all elements.
        return ans;
    }

    // 10.Peak index in a Mountain Array

    static int peakIndexInMountainArray(int[] arr)
    {
        int start = 0;
        int end = arr.length - 1;

        while (start < end)
        {
            // Continue until pointers meet
            int m = (start + end) / 2;
            // If middle element is greater than next element,
            // we are on the descending slope of the mountain
            if (arr[m] > arr[m + 1])
            {
                end = m;            // trim right half since peak is mid or to the left
            }
            // Else, middle element is smaller than next element,
            // we are on the ascending slope of the mountain
            else if (arr[m] < arr[m + 1])
            {
                start = m + 1;      // trim left half since peak is to the right
            }
        }

        // After loop ends, start == end → pointing to the peak index
        return end;                 // or return start; both are same
    }

    // 11. Count negative numbers in sorted Matrix

    static int countNegatives(int[][] grid) {
        int ans =0;
        for(int i=0; i<grid.length; i++){
            ans = ans + negInArr(grid[i]);
        }
        return ans;
    }
    static int negInArr(int[] arr){
        int negative = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                negative++;
            }
        }
        return negative;
    }

    // 12. Intersection of Two Array

    static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<nums1.length ;i++){
            for(int j = 0;j<nums2.length;j++){
                if(ans.contains(nums1[i])) break;
                if(nums1[i] == nums2[j]){
                    ans.add(nums1[i]);
                }
            }
        }
        int[] ans1 = new int[ans.size()];
        for(int i=0;i<ans.size(); i++){
            ans1[i] = ans.get(i);
        }
        return ans1;
    }

    // 13.Intersection of Two Arrays II

    static int[] intersect(int[] nums1, int[] nums2) {
        // Sort both arrays to enable the two-pointer approach.
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        List<Integer> intersection = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else { // nums1[i] == nums2[j]
                intersection.add(nums1[i]);
                i++;
                j++;
            }
        }

        // Convert the list of integers to an array of primitives.
        int[] result = new int[intersection.size()];
        for (int k = 0; k < intersection.size(); k++) {
            result[k] = intersection.get(k);
        }

        return result;
    }

    // 14. Fair Candy Swap

    static int hasBox(int[] a, int b) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == b)
                return mid;
            else if (a[mid] < b)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aSum = 0, bSum = 0;
        Arrays.sort(bobSizes);
        for (int i : aliceSizes)
            aSum += i;
        for (int i : bobSizes)
            bSum += i;
        int half = (bSum - aSum) / 2;
        for (int i : aliceSizes) {
            int temp = hasBox(bobSizes, half + i);
            if (temp != -1)
                return new int[] { i, bobSizes[temp] };
        }
        return new int[] { 0, 0 };
    }

    // 15. Check if N and it's double exists

    static boolean checkIfExist(int[] arr) {
        // Step 1: Iterate through all pairs of indices
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                // Step 2: Check the conditions
                if (i != j && arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }
        // No valid pair found
        return false;
//        Arrays.binarySearch()
    }

    // 16. Special Array With X Elements Greater Than or Equal X

    static int specialArray(int[] nums) {
        Arrays.sort(nums);
        // We are iterating from 1 to highest number of nums which is sorted
        for(int x=0; x<=nums[nums.length-1]; x++){
            int val =0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]>=x){
                    val++;
                }
            }
            if(x==val){
                return x;
            }
        }
        return -1;
    }

    // 17. Binary Search

    static int search(int[] nums, int target) {
        if(Arrays.binarySearch(nums,target)<0){
            return -1;
        }else{
            return Arrays.binarySearch(nums,target);
        }
    }


}
