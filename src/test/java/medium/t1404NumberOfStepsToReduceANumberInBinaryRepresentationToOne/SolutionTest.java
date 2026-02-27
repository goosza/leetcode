package medium.t1404NumberOfStepsToReduceANumberInBinaryRepresentationToOne;

import com.goosza.algorithmics.medium.t1404NumberOfStepsToReduceANumberInBinaryRepresentationToOne.Solution;
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
    public void numSteps() {
        assertEquals(6, solution.numSteps("1101"));
        assertEquals(85, solution.numSteps("1111011110000011100000110001011011110010111001010111110001"));
    }

}
