package hard.t2581CountNumberOfPossibleRootNodes;

import com.goosza.algorithmics.hard.t2581CountNumberOfPossibleRootNodes.Solution;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private static Solution solution;

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @Test
    void rootCount() {
        assertEquals(3, solution.rootCount(new int[][]{{0,1},{1,2},{1,3},{4,2}}, new int[][]{{1,3},{0,1},{1,0},{2,4}}, 3));
    }

    @Test
    void adjacencyMatrixTest(){
        List<List<Integer>> adjacencyMatrix = solution.adjacencyList(new int[][]{{0,1}, {1,2}, {1,3}, {4,2}}, 5);
        for (int i = 0; i < adjacencyMatrix.size(); i++) {
            System.out.println(i + ":" + adjacencyMatrix.get(i));
        }
    }
}
