package hackerrank;


/*
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 -1 -2 -4 0
 */
public class Array2D {
    public static void main(String[] args) {
        int[][] arrint = {{1, 1, 1, 0, 0, 0},{0,1,0,0,0,0},{1,1,1,0,0,0},{0,0,2,4,4,0},{0,0,0,2,0,0},{0,0,1,2,4,0}};
        assert(hourglass(arrint) == 19);

        int[][] arrint2 = {{1, 1, 1, 0, 0, 0},{-9,1,0,0,0,0},{1,1,1,0,0,0},{0,0,2,4,4,0},{0,0,0,2,0,0},{0,0,-1,-2,-4,0}};
        assert(hourglass(arrint2) == 10);

        int[][] arrint3 = {{-1, -1, -1, -1, -1, -1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1}};
        assert(hourglass(arrint3) == -7);
    }

    static int hourglass(int[][] arrint) {
        Integer max = null;
        for (int i = 0; i <= arrint.length - 3; i++) {
            for (int j = 0; j <= arrint.length - 3; j++) {
                int sum = arrint[i][j] + arrint[i][j + 1] + arrint[i][j + 2] +
                        arrint[i + 1][j + 1] + arrint[i + 2][j] + arrint[i + 2][j + 1] + arrint[i + 2][j + 2];
                max = max == null || sum > max ? sum : max;
            }
        }
        return max;
    }
}
