package arrayshashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L554BrickWall {
    /*
There is a rectangular brick wall in front of you with n rows of bricks. The ith row has some number of bricks each of the same height (i.e., one unit) but they can be of different widths. The total width of each row is the same.

Draw a vertical line from the top to the bottom and cross the least bricks. If your line goes through the edge of a brick, then the brick is not considered as crossed. You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

Given the 2D array wall that contains the information about the wall, return the minimum number of crossed bricks after drawing such a vertical line.
Input: wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
Output: 2
Example 2:

Input: wall = [[1],[1],[1]]
Output: 3


Constraints:

n == wall.length
1 <= n <= 104
1 <= wall[i].length <= 104
1 <= sum(wall[i].length) <= 2 * 104
sum(wall[i]) is the same for each row i.
1 <= wall[i][j] <= 231 - 1
     */
    public static void main(String[] args) {
        List<List<Integer>> ex = new ArrayList<>();
        ex.add(List.of(1,2,2,1));
        ex.add(List.of(3,1,2));
        ex.add(List.of(1,3,2));
        ex.add(List.of(2,4));
        ex.add(List.of(3,1,2));
        ex.add(List.of(1,3,1,1,1));
        System.out.println(leastBricks(ex));
    }
    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxGaps = 0;

        for(List<Integer> row : wall) {
            int pos = 0;
            for(int i=0; i<row.size()-1; i++) {
                pos += row.get(i);
                map.put(pos, map.getOrDefault(pos, 0)+1);
                maxGaps = Math.max(maxGaps, map.get(pos));
            }
        }

        return wall.size() - maxGaps;
    }
}
