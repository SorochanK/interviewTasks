import SubClasses.ListNode;
import SubClasses.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class EasyTasks {

    /*
     * task 1 (344)
     *
     * Write a function that reverses a string.
     * The input string is given as an array of characters char[].
     * Do not allocate extra space for another array,
     * you must do this by modifying the input
     * array in-place with O(1) extra memory.
     *
     * */
    void reverseString(char[] s) {
        char tmp;
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            tmp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = tmp;
        }
    }


    /*
    task 2 (104) - Maximum Depth of Binary Tree

    Given a binary tree, find its maximum depth.
    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    Note: A leaf is a node with no children.
    Example:
    Given binary tree [3,9,20,null,null,15,7]
    return is 3
    */
    int maxDepth(TreeNode root) {
        //NOT MY SOLUTION
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    /*
    * task 3 (136) - Single Number
    *
    *
    * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
    * Example:
      Input: [2,2,1]
      Output: 1
    *
    * */
    int singleNumber(int[] nums) {
        return 0;
    }


    /*
     * task 4(283) - Move Zeroes
     *
     * Given an array nums, write a function to move all 0's to the end of it
     * while maintaining the relative order of the non-zero elements.
     *
     * Example:
        Input: [0,1,0,3,12]
        Output: [1,3,12,0,0]
     *
     * */
    void moveZeroes(int[] nums) {

        Deque<Integer> tmp = new ArrayDeque<>();
        for (int num : nums) if (num != 0) tmp.addLast(num);

        for (int i = 0; i < nums.length; i++) {
            if (tmp.size() != 0) nums[i] = tmp.pop();
            else nums[i] = 0;
        }

        /*
        * int zero = 0, l = 0, r = nums.length;
            while (l < r) {
                if (nums[l] != 0) {
                    int tmp = nums[zero];
                    nums[zero] = nums[l];
                    nums[l] = tmp;
                    zero++;
                }
                l++;
            }
        * */
    }


    /*
    * task 5(206)
    *
    * Reverse a singly linked list
    * Example:

      Input: 1->2->3->4->5->NULL
      Output: 5->4->3->2->1->NULL
    * */
    ListNode reverseList(ListNode head) {
        //NOT MY SOLUTION
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /*
    * task 6(236) Delete Node in a Linked List
    * Example:
      Input: head = [4,5,1,9], node = 5
      Output: [4,1,9]
    *
    * */
    void deleteNode(ListNode head, int val) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr.val != val) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
    }

    /*
    * task 7(169) Majority Element
    *
    * Given an array of size n, find the majority element.
    * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
    *
    * Example 2:
        Input: [2,2,1,1,1,2,2]
        Output: 2
    * */
    int majorityElement(int[] nums) {
        Map<Integer, Integer> numQty = new HashMap<>();
        for (int num : nums) {
            if (numQty.containsKey(num)) numQty.put(num, numQty.get(num) + 1);
            else numQty.put(num, 1);
        }
        return numQty.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        /*
            Arrays.sort(nums);
            return nums[nums.length / 2];
        */
    }

    /*
     * task 8(242) valid anagram
     * Given two strings s and t , write a function to determine if t is an anagram of s.
     * */
    boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        List<String> s1 = new LinkedList<>(Arrays.asList(s.split("")));
        List<String> t1 = new LinkedList<>(Arrays.asList(t.split("")));
        for (String item : t1) if (!s1.remove(item)) return false;
        return true;
    }

    /*
    * task 9(217) contains duplicate
    *
    * Given an array of integers, find if the array contains any duplicates.
      Your function should return true if any value appears at least twice in the array,
      and it should return false if every element is distinct.
    *
    * */
    boolean containDuplicate(Integer[] nums) {
        //NOT MY SOLUTION
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i].equals(nums[i + 1])) return true;
        }
        return false;
    }


    /*
     * task 10(387) First Unique Character in a String
     * Given a string, find the first non-repeating character in it and return it's index.
     * If it doesn't exist, return -1.
     * */
    int firstUniqueChar(String s) {
        String[] sArr = s.split("");
        Map<String, Integer> items = new HashMap<>();
        for (int i = 0; i < sArr.length; i++) {
            if (!items.containsKey(sArr[i])) items.put(sArr[i], i);
            else items.remove(sArr[i]);
        }
        List<Integer> result = items.values().stream().sorted().collect(Collectors.toList());
        return result.get(0) != null ? result.get(0) : 0;
    }

    /*
     * task 11(268) missing number
     *
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
     * find the one that is missing from the array.
     *
     * */
    int missingNumber(Integer[] nums) {
        int sum = 0;
        int sumNums = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += i;
            sumNums += nums[i];
        }
        sum += nums.length;
        return sum - sumNums;
    }
    /*
    * task 12(350) intersection of two arrays
    * Given two arrays, write a function to compute their intersection.
    *
    * Example 1:

      Input: nums1 = [1,2,2,1], nums2 = [2,2]
      Output: [2,2]
      Example 2:

      Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
      Output: [4,9]
    *
    * */

    List<Integer> intersect(Integer[] nums1, Integer[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1).collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).collect(Collectors.toList());
        List<Integer> res = new ArrayList<>();
        for (Integer item : list1) if (list2.contains(item)) res.add(item);
        return res;
    }

    /*
    * task 13 (21) merge two lists
    *
    * Merge two sorted linked lists and return it as a new list.
    * The new list should be made by splicing together the nodes of the first two lists.
    *
    * Example:
      Input: 1->2->4, 1->3->4
      Output: 1->1->2->3->4->4
    *
    * */
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //NOT MY SOLUTION
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /*
     * task 14 (118) pascal`s triangle
     *
     * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
     *
     * */
    List<List<Integer>> pascalTriangle(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row;
        List<Integer> prevRow = new ArrayList<>(Arrays.asList(1));
        res.add(prevRow);

        for (int i = 0; i < numRows - 1; i++) {
            row = new ArrayList<>();
            for (int j = 0; j < prevRow.size() - 1; j++) row.add(prevRow.get(j) + prevRow.get(j + 1));
            row.add(0, 1);
            row.add(row.size(), 1);
            prevRow = row;
            res.add(row);
        }
        return res;
    }



    /*
    * task 15 (53) maximum subarray
    *
    * Given an integer array nums, find the contiguous subarray
    * (containing at least one number) which has the largest sum and return its sum.
    *
    * Example:
      Input: [-2,1,-3,4,-1,2,1,-5,4],
      Output: 6
      Explanation: [4,-1,2,1] has the largest sum = 6.
    *
    * */

    int maxSubArray(int[] nums) {
        return 0;
    }



    /*
     * task 16(191) hamming weight
     *
     *
     * Write a function that takes an unsigned integer and return the number of '1' bits it has
     * (also known as the Hamming weight).
     *
     * */

    int hammingWeight(int n) {
        int res = 0, t;
        while (n != 0) {
            t = n % 2 == 0 ? n : n - 1;
            if (n - t == 1) res += 1;
            n /= 2;
        }
        return res;
    }

    /*
    * task 17 (1) two sum
    *
    * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
      You may assume that each input would have exactly one solution, and you may not use the same element twice.
    *
    * Example:

      Given nums = [2, 7, 11, 15], target = 9,

      Because nums[0] + nums[1] = 2 + 7 = 9,
      return [0, 1].
    *
    *
    * */
    int[] twoSum(int[] nums, int target) {
        //NOT MY SOLUTION
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*
    * task 18 (66) plus one
    *
    * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
    The digits are stored such that the most significant digit is at the head of the list,
     and each element in the array contain a single digit.
    You may assume the integer does not contain any leading zero, except the number 0 itself.
    *Example 1:

     Input: [1,2,3]
     Output: [1,2,4]
     Explanation: The array represents the integer 123.

     Example 2:

     Input: [4,3,2,1]
     Output: [4,3,2,2]
     Explanation: The array represents the integer 4321.
    *
    * */
    Integer[] plusOne(Integer[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) sb.append(digit);
        String[] nums = Integer.toString(Integer.parseInt(sb.toString()) + 1).split("");
        return Arrays.stream(nums).map(Integer::parseInt).toArray(Integer[]::new);
    }

    /*
     * task 19 (20) valid parentheses
     *
     * */
    boolean isValid(String s) {
        Stack<Character> stash = new Stack<>();
        String opened = "([{";
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (opened.indexOf(ch) != -1) stash.push(ch);
            else {
                Character t = stash.pop();
                if ((t == '[' && ch != ']')
                        || (t == '(' && ch != ')')
                        || (t == '{' && ch != '}')) return false;
            }
        }
        return true;
    }


}











