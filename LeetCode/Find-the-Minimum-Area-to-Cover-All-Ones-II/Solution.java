class Solution {
    public int grid[][];
    public int minAreaOfOneRectangle(int rowb,int rowe,int colb,int cole){
        int minRow=Integer.MAX_VALUE;
        int minCol=Integer.MAX_VALUE;
        int maxRow=0;
        int maxCol=0;
        for(int i=rowb;i<rowe;i++){
            for(int j=colb;j<cole;j++){
                if(grid[i][j]==1){
                    minRow=Math.min(minRow,i);
                    minCol=Math.min(minCol,j);
                    maxRow=Math.max(maxRow,i);
                    maxCol=Math.max(maxCol,j);
                }
            }
        }
        return (maxRow-minRow+1)*(maxCol-minCol+1);
    }

    public int minAreaOfTwoRectangles(int rowb,int rowe,int colb,int cole){
        int ans=Integer.MAX_VALUE;

        for(int i=rowb;i<rowe;i++){
            int top=minAreaOfOneRectangle(rowb,i,colb,cole);
            int down=minAreaOfOneRectangle(i,rowe,colb,cole);
            ans=Math.min(top+down,ans);
        }

        for(int j=colb;j<cole;j++){
            int left=minAreaOfOneRectangle(rowb,rowe,colb,j);
            int right=minAreaOfOneRectangle(rowb,rowe,j,cole);
            ans=Math.min(left+right,ans);
        }
        
        return ans;
    }

    public int minimumSum(int[][] grid) {
        this.grid=grid;
        int ans=Integer.MAX_VALUE;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            int top=minAreaOfTwoRectangles(0,i,0,n);
            int down=minAreaOfOneRectangle(i,m,0,n);
            ans=Math.min(top+down,ans);
        }

        for(int i=0;i<m;i++){
            int top=minAreaOfOneRectangle(0,i,0,n);
            int down=minAreaOfTwoRectangles(i,m,0,n);
            ans=Math.min(top+down,ans);
        }

        for(int j=0;j<n;j++){
            int left=minAreaOfTwoRectangles(0,m,0,j);
            int right=minAreaOfOneRectangle(0,m,j,n);
            ans=Math.min(left+right,ans);
        }

        for(int j=0;j<n;j++){
            int left=minAreaOfOneRectangle(0,m,0,j);
            int right=minAreaOfTwoRectangles(0,m,j,n);
            ans=Math.min(left+right,ans);
        }

        return ans;
    }
}