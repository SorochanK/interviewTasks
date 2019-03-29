import SubClasses.ListNode;
import SubClasses.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class EasyTasksTest {

    public final EasyTasks easyTasks = new EasyTasks();

    @Test
    void reverseString() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        char[] reversed = {'o', 'l', 'l', 'e', 'h'};

        easyTasks.reverseString(s);

    }

    @Test
    void maxDepth() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(15);

        int res = easyTasks.maxDepth(root);
        assertEquals(3, res);

    }

    @Test
    void singleNumber() {
        int[] arr = {1, 4, 2, 2, 1, 4, 6};
        int res = easyTasks.singleNumber(arr);
        System.out.println(res);
    }

    @Test
    void moveZeroes() {
        int[] a = {1, 2, 0, 0, 4, 0, 3, 4};
        int[] b = {1, 2, 4, 3, 4, 0, 0, 0};

        easyTasks.moveZeroes(a);
        for (int i = 0; i < a.length; i++) assertEquals(a[i], b[i]);
    }


    @Test
    void deleteNode() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        easyTasks.deleteNode(head, 1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    @Test
    void majorityElement() {
        int[] nums = {2, 2, 1, 1, 1, 2, 2, 1, 1, 5, 5, 5, 5, 5, 5, 5};
        int res = easyTasks.majorityElement(nums);
        System.out.println(res);
        //for(int num :nums) System.out.println(num);

    }

    @ParameterizedTest
    @CsvSource({
            "kaban,banka",
            "kukla,kulak",
            "kapriz,prikaz",
            "korshun,shnurok"
    })
    void anagram(String s, String t) {
        boolean res = easyTasks.isAnagram(s, t);
        assertTrue(res);
    }


    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4'",
            "'4,2,3,77,4'",
    })
    void containDuplicate(@ConvertWith(StringArrayConverter.class) Integer[] nums) {
        boolean res = easyTasks.containDuplicate(nums);
        System.out.println(res);
    }

    @ParameterizedTest
    @ValueSource(strings = {"leetcode", "loveleetcode"})
    void firstUniqueChar(String s) {
        int res = easyTasks.firstUniqueChar(s);
        System.out.println(res);
    }

    @ParameterizedTest
    @CsvSource({"'3,0,1'", "'9,6,4,2,3,5,7,0,1'", "'4,1,2,0'"})
    void missingNumber(@ConvertWith(StringArrayConverter.class) Integer[] nums) {
        int res = easyTasks.missingNumber(nums);
        System.out.println(res);
    }

    @ParameterizedTest
    @CsvSource({"'1,2,2,1', '2,2'",
            "'4,9,5', '9,4,9,8,4'"
    })
    void intersectArray(@ConvertWith(StringArrayConverter.class) Integer[] nums1,
                        @ConvertWith(StringArrayConverter.class) Integer[] nums2) {
        List<Integer> res = easyTasks.intersect(nums1, nums2);
        System.out.println(Arrays.asList(res));
    }

    @Test
    void mergeTwoLists() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode resList = easyTasks.mergeTwoLists(l1, l2);

        while (resList != null) {
            System.out.println(resList.val);
            resList = resList.next;
        }


    }

    @Test
    void pascalTriangle() {
        List<List<Integer>> res = easyTasks.pascalTriangle(5);
        res.stream().map(Arrays::asList).forEach(System.out::println);
    }

    @Test
    void maxSubArray() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        easyTasks.maxSubArray(nums);

    }

    @Test
    void hammingWeight() {
        int res = easyTasks.hammingWeight(19);
        System.out.println(res);
    }

    @Test
    void twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        int[] res = easyTasks.twoSum(nums, target);
        System.out.println(Arrays.asList(res));
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4'",
            "'9,9'",
    })
    void plusOne(@ConvertWith(StringArrayConverter.class) Integer[] digits) {
        Integer[] res = easyTasks.plusOne(digits);
        System.out.println(Arrays.asList(res));
    }


    @ParameterizedTest
    @ValueSource(strings = {"()", "{[]}", "([})", "([{]]]"})
    void validParentheses(String s) {
        boolean res = easyTasks.isValid(s);
        System.out.println(res);
    }

    @ParameterizedTest
    @CsvSource({
            "'flower,flow,flight,flober,flickr'",
            "'dog,racecar,car'"
    })
    void longestCommonPrefix(@ConvertWith(StringToStringArray.class) String[] strs) {
        String res = easyTasks.longestCommonPrefix(strs);
        System.out.println(res);
    }

    @ParameterizedTest
    @CsvSource({
            "hello , ll",
            "aaaa ba",
            "flower r"
    })
    void strStr(String haystack, String needle) {
        int res = easyTasks.strStr(haystack, needle);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            /*"redivider",
            "civic",
            "radar",
            "level",*/
            "a man,a plan,a canal:panama"
    })
    void isPalindrome(String str) {
        boolean res = easyTasks.isPalindrome(str);
        System.out.println(res);
    }


    @Test
    void addNumberWithoutPlus() {
        int a = 10;
        int b = 4;
        System.out.println(easyTasks.add(a, b));
    }


}


class StringArrayConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
        String[] s = ((String) o).split("\\s*,\\s*");
        Integer[] intarray = new Integer[s.length];
        int i = 0;
        for (String str : s) {
            intarray[i] = Integer.parseInt(str);
            i++;
        }
        return intarray;
    }
}


class StringToStringArray extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
        return ((String) o).split("\\s*,\\s*");
    }
}



