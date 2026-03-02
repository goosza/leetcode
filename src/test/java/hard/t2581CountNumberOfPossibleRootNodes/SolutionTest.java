package hard.t2581CountNumberOfPossibleRootNodes;

import com.goosza.algorithmics.hard.t2581CountNumberOfPossibleRootNodes.Solution;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class SolutionTest {

    private static Solution solution;

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }
//    @Test
//    void rootCount() {
//
//    }

    @Test
    void adjacencyMatrixTest(){
        HashMap<Integer, List<Integer>> adjacencyMatrix = solution.adjacencyMatrix(new int[][]{{0,1}, {1,2}, {1,3}, {4,2}});
        adjacencyMatrix.forEach((k,v) -> System.out.println(k + ":" + v));
    }
}
