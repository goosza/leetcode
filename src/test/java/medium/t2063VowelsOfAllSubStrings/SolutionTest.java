package medium.t2063VowelsOfAllSubStrings;

import com.goosza.algorithmics.medium.t2063VowelsOfAllSubStrings.Solution;
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
        assertEquals(3, solution.countVowels("abc"));
        assertEquals(0, solution.countVowels("ltcd"));
        assertEquals(6, solution.countVowels("aba"));
    }
}
