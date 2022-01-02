import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

class Matrix {

    List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getColumnCandidates(List<List<Integer>> values) {
        List<MatrixCoordinate> allColumnCandidate = new ArrayList<>();
        var columns = values.get(0).size();
        for (int y = 0; y < columns; y++ ) {
            List<MatrixCoordinate> columnCandidates  = new ArrayList<>();
            int finalY = y;
            var columnValues = values.stream().map(x -> x.get(finalY)).collect(Collectors.toList());
            var columnMax = columnValues.stream().min(Integer::compareTo).get();
            columnValues.stream().reduce(0, (row, value) -> {
                if (columnMax == value) {
                    columnCandidates.add(new MatrixCoordinate(row + 1, finalY + 1));
                }
                return ++row;
            });
            allColumnCandidate.addAll(columnCandidates);
        }

        return new HashSet(allColumnCandidate);
    }

    Set<MatrixCoordinate> getRowCandidate(List<List<Integer>> values) {
        List<MatrixCoordinate> allRowCandidates = new ArrayList<>();
        var columns = values.get(0).size();
        var rows = values.size();
        for (int x = 0; x < rows; x++ ) {
            List<MatrixCoordinate> rowCandidates  = new ArrayList<>();
            var row = values.get(x);
            var rowMax = row.stream().max(Integer::compareTo).get();
            int finalX = x;
            row.stream().reduce(0, (col, value) -> {
                if (rowMax == value) {
                    rowCandidates.add(new MatrixCoordinate(finalX + 1, col + 1));
                }
                return ++col;
            });
            allRowCandidates.addAll(rowCandidates);
        }

        return new HashSet(allRowCandidates);
    }

    public  Set<MatrixCoordinate> getSaddlePoints() {
        if (this.values.size() == 0)
            return new HashSet<>();

        var candidates = this.getColumnCandidates(this.values);
        candidates.retainAll(this.getRowCandidate(values));
        return candidates;
    }
}
