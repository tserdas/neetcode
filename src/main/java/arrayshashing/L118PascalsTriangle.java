package arrayshashing;

import java.util.ArrayList;
import java.util.List;

public class L118PascalsTriangle {
    /*
    Given an integer numRows, return the first numRows of Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

    --https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif

    Example 1:

    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    Example 2:

    Input: numRows = 1
    Output: [[1]]


    Constraints:

    1 <= numRows <= 30
     */
    public static void main(String[] args) {
        generate(5).forEach(System.out::println);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j > 0 && i > 0 && res.get(i - 1).size() - 1 >= j) {
                    list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                } else {
                    list.add(1);
                }
            }
            res.add(list);
        }

        return res;
    }
}
