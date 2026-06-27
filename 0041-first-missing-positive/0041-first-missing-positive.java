class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // sorting function using sort funciton according to logic that arr[i]=arr[arr[i]-1]
        Sort(nums, n);
// j to be used for iterating over array
        int j = 0;
        // 1 is supposed to be the first positive element
        int i = 1;
        // iteration going to start on arr
        while (j < n) {
            //if element at j is not equal to i that means i is missing from array and we return it 
            if (nums[j] != i) {
                return i;
            }
            // increment to check aheads
            i++;
            j++;
        }
        // if nothing is returned means everything is there in array then we return n+1
        return n + 1;
    }

    void Sort(int[] arr, int n) {
        int i = 0;
        while (i < n) {
            if (arr[i] > 0 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
                swap(arr, i);
            } else {
                // if not to be swap we dont and just move ahead
                i++;
            }
        }
    }

    void swap(int[] arr, int i) {
        int temp = arr[arr[i] - 1];
        arr[arr[i] - 1] = arr[i];
        arr[i] = temp;
    }
}