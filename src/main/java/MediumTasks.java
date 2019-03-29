import java.util.*;
import java.util.stream.Collectors;

public class MediumTasks {

    /*
    * task 22 (238) Product of Array Except Self
    *
    * Given an array nums of n integers where n > 1,
    * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
    *
    * Example:
      Input:  [1,2,3,4]
      Output: [24,12,8,6]
    * */

    int[] productExceptSelf(int[] nums) {
        //NOT MY SOLUTION
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    /*
    * task 23 (347) Top K Frequent Elements
    *
    * Given a non-empty array of integers, return the k most frequent elements.
    *
    * Example 1:
      Input: nums = [1,1,1,2,2,3], k = 2
      Output: [1,2]

      Example 2:
      Input: nums = [1], k = 1
      Output: [1]
    *
    * */
    List<Integer> topKFrequent(Integer[] nums, int k) {
        Map<Integer, Integer> numQty = new TreeMap<>();
        for (Integer num : nums) numQty.put(num, numQty.getOrDefault(num, 0) + 1);
        return numQty.keySet().stream().limit(k).collect(Collectors.toList());
    }


    /*
     *task 24 (46) permutations
     *
     * Given a collection of distinct integers, return all possible permutations.
     *Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
    */
    List<List<Integer>> permute(int[] nums) {
        int cnt = 1, n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int j = 1; j <= n; j++) cnt *= j;

        cnt = 4;
       /* while (res.size() <= cnt) {
            for (int i = 0; i < n - 1; i++) {
                swap(nums, i, i + 1);
                List<Integer> row = Arrays.stream(nums).boxed().collect(Collectors.toList());
                res.add(row);
            }
        }*/
        res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        for (int i = 0; i < n - 1; i++) {
            swap(nums, i, i + 1);
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }


        return res;
    }

    /*
     *
     * task (384) shuffle an array
     * */
    int[] shuffle(int[] nums) {
        int k = 0;
        while (k++ < nums.length * 2) swap(nums, rand(0, nums.length - 1), rand(0, nums.length - 1));
        return nums;
    }


    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int rand(int a, int b) {
        return a + (int) (Math.random() * b);
    }


}




