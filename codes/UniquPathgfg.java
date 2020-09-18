Question: Find all unique path from 0,0 to m,n in a graph. One can move down or right only.
example :
[
	[0	0	0	0	1],
	[0	1	1	0	0],
	[0 	0	0	0	0]
]

answer would be 3.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.*;
public class UniquPathgfg {
    static int ans=0,n,m;
    public static void main(String args[]) {
      Scanner sc=new Scanner(System.in);
      m=sc.nextInt();
      n=sc.nextInt();
      int a[][]=new int [m][n];
      int i,j;
      for(i=0;i<m;i++){
          for(j=0;j<n;j++)
            a[i][j]=sc.nextInt();
      }
      A(a,0,0);
      System.out.println(ans);
    }
    static void A(int a[][],int i, int j){
        if(i==m-1&&j==n-1){
            ans=ans+1;
            return;
        }
        if(j+1<n&&i+1<m&a[i][j+1]==0&&a[i+1][j]==0){
            A(a,i,j+1);
            A(a,i+1,j);
        }
        else if(j+1<n&&a[i][j+1]==0){
            A(a,i,j+1);
        }
        else if(i+1<m&&a[i+1][j]==0){
            A(a,i+1,j);
        }
        else
            return;
    }
}
