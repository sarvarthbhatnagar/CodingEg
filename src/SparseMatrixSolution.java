import java.util.*;

/**
 * A very low memory implementation of a sparse matrix
 * Good for cases with few non-nulls in a matrix
 * Space occupied is equal to the number of non-nulls
 * Retrieval is O(n) based on rowname and colname
 */
class SparseMatrix {

    private final List<String> _rows;
    private final List<String> _cols;
    private final int[][] _matrixData;
    private final Map<Integer, Integer> _elMap;

    public SparseMatrix(String[] rows, String[] cols, int[][] rowdata) {
        _rows = Arrays.asList(rows);
        _cols = Arrays.asList(cols);
        _matrixData = rowdata;
        _elMap = new HashMap<>();
        for (int i = 0; i < rowdata.length; i++) {
            for (int j = 0; j < rowdata[i].length; j++) {
                int el = rowdata[i][j];
                if (el != 0) {
                    _elMap.put(i * rowdata.length + j, el);
                }
            }
        }
    }

    public int getValue(String col, String row){
        return getValue(_cols.indexOf(col), _rows.indexOf(row));
    }
    private int getValue(int col, int row){
        if(col<0 || row < 0 || col>=getColMax() || row>=getRowMax()){
            return 0;
        }
        return _elMap.getOrDefault(row * getColMax() + col, 0);
    }

    public int getOccupiedUnits(){
        return _elMap.size();
    }

    @Override
    public String toString() {
        int rowMax = getRowMax();
        int colMax = getColMax();
        List<List<Integer>> matrixList = new ArrayList<>();
        for (int i = 0; i < rowMax; i++) {
            List<Integer> intMatrixList = new ArrayList<>();
            for (int j = 0; j < colMax; j++) {
                intMatrixList.add(_elMap.getOrDefault(i * colMax + j, 0));
            }
            matrixList.add(intMatrixList);
        }
        return matrixList.toString();
    }
    private int getColMax() {
        return _matrixData.length != 0 ? _matrixData[0].length : 0;
    }

    private int getRowMax() {
        return _matrixData.length;
    }

}

public class SparseMatrixSolution {

    public static final String[] TEST_COLS = {"col1", "col2", "col3", "col4", "col5", "col6", "col7", "col8", "col9", "col10", "col11", "col12", "col13", "col14", "col15"};
    public static final String[] TEST_ROWS = {"row1", "row2", "row3", "row4", "row5", "row6", "row7", "row8", "row9", "row10", "row11", "row12", "row13", "row14", "row15"};
    public static final int[][] TEST_MATRIX_DATA = {
            {0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};


    public static void main(String[] args) {
        SparseMatrix sm = new SparseMatrix(TEST_ROWS, TEST_COLS, TEST_MATRIX_DATA);
        //System.out.println(sm.toString());
        System.out.println(sm.getValue("col7","row1"));
        System.out.println("Occupied space : "+ sm.getOccupiedUnits());
    }
}
