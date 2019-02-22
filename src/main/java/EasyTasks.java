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
    public void reverseString(char[] s) {
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
    public int maxDepth(TreeNode root) {
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
    public int singleNumber(int[] nums) {
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
    public void moveZeroes(int[] nums) {

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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = curr.next;
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
    public void deleteNode(ListNode head, int val) {
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
    public int majorityElement(int[] nums) {
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
    public boolean isAnagram(String s, String t) {
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
    public boolean containDuplicate(Integer[] nums) {
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
    public int firstUniqueChar(String s) {
        String[] sArr = s.split("");
        Map<String, Integer> items = new HashMap<>();
        for (int i = 0; i < sArr.length; i++) {
            if (!items.containsKey(sArr[i])) items.put(sArr[i], i);
            else items.remove(sArr[i]);
        }
        List<Integer> result = items.values().stream().sorted().collect(Collectors.toList());
        return result.get(0) != null ? result.get(0) : 0;
    }


}







