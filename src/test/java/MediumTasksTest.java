import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

public class MediumTasksTest {
    private final MediumTasks mediumTasks = new MediumTasks();


    @Test
    void productExceptSelf() {
        int[] nums = {1, 2, 3, 4};
        int[] res = mediumTasks.productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }

    @ParameterizedTest
    @CsvSource({"'1,1,1,2,2,3', 2",
            "'1', 1"
    })
    void topKFrequent(@ConvertWith(StringArrayConverter.class) Integer[] nums, int k) {
        List<Integer> res = mediumTasks.topKFrequent(nums, k);
        System.out.println(res);
    }

    @Test
    void permute() {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> res = mediumTasks.permute(nums);
        System.out.println(res);

    }

    @Test
    void shuffleArray() {
        int[] nums = {12, 3, 5, 4,6,1,1,4};
        int[] res = mediumTasks.shuffle(nums);
        System.out.println(Arrays.toString(res));

    }


}





