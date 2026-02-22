import java.util.ArrayList;
import java.util.List;

public class pascaltriangle {
    public List<List<Integer>> generate(int n) {
       List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int row = 1; row <= n; row++) {
            pascalTriangle.add(generateRow(row));
        }
        
        return pascalTriangle; 
    }

    private List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        
        ansRow.add(1); 

        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }
        
        return ansRow; 
    }
}
