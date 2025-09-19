class Spreadsheet {
    private int[][] grid;

    public Spreadsheet(int rows) {
        grid = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = value;
    }
    
    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = 0;
    }
    
    public int getValue(String formula) {
        String expr = formula.substring(1); // remove '='
        String[] parts = expr.split("\\+");

        return evaluate(parts[0]) + evaluate(parts[1]);
    }
    private int evaluate(String operand) {
        if (Character.isDigit(operand.charAt(0))) {
            return Integer.parseInt(operand);
        } else {
            int[] pos = parseCell(operand);
            return grid[pos[0]][pos[1]];
        }
    }

    private int[] parseCell(String cell) {
        char colChar = cell.charAt(0);
        int col = colChar - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        return new int[]{row, col};
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */