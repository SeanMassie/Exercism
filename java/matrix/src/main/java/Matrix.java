import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Matrix {

    List<List<Integer>> arr;

    Matrix(String matrixAsString) {
        arr = matrixAsString.lines()
                .map(x -> x.split(" "))
                .map(x -> Arrays.stream(x).map(y -> Integer.valueOf(y)).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    int[] getRow(int rowNumber) {
        return arr.get(rowNumber-1).stream().mapToInt(Integer::intValue).toArray();
    }

    int[] getColumn(int columnNumber) {
        return arr.stream().map(x -> x.get(columnNumber-1)).mapToInt(Integer::intValue).toArray();
    }
}
