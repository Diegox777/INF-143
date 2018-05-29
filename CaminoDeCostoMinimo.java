import java.util.*;
public class CaminoDeCostoMinimo {
    static int costo[][];
    static int n, m;
    static final int INF=1000000000;
    static int memo[][]=new int[105][105];
     
    static int solve(int i, int j){
        if(i>=n || j>=m)
            return INF;
        if(i==n-1 && j==m-1)
            return costo[i][j];
        //transiciones
        if (memo[i][j]!=-1)
            return memo[i][j];
        int ans=INF;
        ans=Math.min(ans, costo[i][j]+ solve(i+1,j));
        ans=Math.min(ans, costo[i][j]+ solve(i,j+1));
        return memo[i][j]=ans;
    }
     
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        costo =new int[n+1][m+1];
        for(int i=0; i<n;i++)
            for(int j=0; j<m;j++)
                costo[i][j]=sc.nextInt();
         
        for (int i=0;i<101;i++)
            for(int j=0;j<101;j++)
                memo[i][j]=-1;
        int ans=solve(0,0);
        System.out.println(ans);
    }
}
