Q.Count the numbers between 1 to N containing 4 as a digit.

Input:
Each line will contain the number of test cases T.Each test case will contain a number N.

Output:
Print the count of numbers for each test case in a separate line.

Constraints:
1<=T<=100
1<=N<=106

Example:
Input:
2
9
3

Output:
1
0

//Solution
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG1 {
	public static void main (String[] args) {
		//code
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		int i;
		for(i=0;i<t;i++){
		    int n=sc.nextInt();
		    int ans=0;
		    while(n!=0){//if n = 889 break it as.. 799 in first pass...remaining 89.. 79 in second pass... remaining 9... 9 in third pass.. remaining 0
		        int l=(int)Math.log10(n);
		        int d=1,num;
		        int r = n/(int)Math.pow(10,l);
		        if(l!=0){
		            num = ((int)Math.pow(10,l)*r)-1;
		            d=num/(int)Math.pow(10,(int)Math.log10(num));
		        }
		        else{
		            num=r;
		        }
		        ans = ans + check(num,(int)Math.log10(num),n);
		        if(d!=3)
		            n=n%(int)Math.pow(10,l);
		        else
		            break;
		    }
		    System.out.println(ans);
		}
	}
	public static int check(int n, int l, int k){//function to count number of occurence of 4 in a digit
	    int ans=0;
	    int f=1,v=0;
	    int flag=0;
	    if(n<4)
	        return 0;
	    if(n>=4&&n<=9)
	        return 1;
	    while(n!=0){
	        l=(int)Math.log10(n);
	        int r = n/(int)Math.pow(10,l);
	        if(r==3){
	            flag=1;
	            v=k-n;
	        }
	        if(r>=4){
	              ans+=f*(int)Math.pow(10,l);      
	              f=f*r;
	        }
	        if(r<4){
	            f=f*(r+1);
	        }
	        n=n%(int)Math.pow(10,l);
	    }
	    return ans+v;
	}
}
//complexity O(l^2) where l is number of digit in number n;
