class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int firstRow = 0;
        int lastRow = matrix.length - 1;
        int firstCol = 0;
        int lastCol = matrix[0].length - 1;
        while(firstRow <= lastRow && firstCol <= lastCol){
            for(int i=firstCol;i<=lastCol;i++){
                ans.add(matrix[firstRow][i]);
            }
            for(int i=firstRow+1;i<=lastRow;i++){
                ans.add(matrix[i][lastCol]);
            }
            if(firstRow < lastRow){
                for(int i=lastCol-1;i>=firstCol;i--){
                    ans.add(matrix[lastRow][i]);
                }
            }
            if(firstCol < lastCol){
                for(int i=lastRow-1;i>=firstRow+1;i--){
                    ans.add(matrix[i][firstCol]);
                }
            }
            firstRow++;
            lastRow--;
            firstCol++;
            lastCol--;
        }
        return ans;
    }
}
