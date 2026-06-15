class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] queen = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(queen[i], '.');
        }
        
        dfs(res, queen, n, 0);
        return res;
    }

    public void dfs(List<List<String>> res, char[][] queen, int n, int col){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(queen[i]));
            }
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int row=0;row<n;row++){
            if(isSafe(row, col, queen, n)){
                queen[row][col] = 'Q';
                dfs(res, queen, n, col+1);
                queen[row][col] = '.';
            }
        }
    }

    public boolean isSafe(int row, int col, char[][] queen, int n){
        for(int i=0;i<col;i++){
            if(queen[row][i] == 'Q'){
                return false;
            }
        }

        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(queen[i][j] == 'Q'){
                return false;
            }
        }

        for(int i=row, j=col; i<n && j>=0; i++, j--){
            if(queen[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
}