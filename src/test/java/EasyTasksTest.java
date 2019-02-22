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



