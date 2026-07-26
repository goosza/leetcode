package medium.t3891MinimumIncreasetoMaximizeSpecialIndices;

import com.goosza.algorithmics.medium.t3891MinimumIncreasetoMaximizeSpecialIndices.Solution;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    private static Solution solution;

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @Test
    public void test() {
        assertEquals(2, solution.minIncrease(new int[]{21, 12, 18, 19}));
//        assertEquals(0, solution.countVowels("ltcd"));
//        assertEquals(6, solution.countVowels("aba"));
    }
}
