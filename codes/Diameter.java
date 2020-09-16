Question: Diameter of a tree.

import java.util.*;
class Node{
    Node left,right;
    int key;
    Node(int data){
        left=null;
        right=null;
        key=data;
    }
}
public class Tree{
    static Node root=null;
    public static void main(String args[]){
        Tree t=new Tree();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            t.addNode(new Node(sc.nextInt()));
        }
        System.out.println(t.diameter(root,0));
    }
    static int sum=0;
    static int diameter(Node root,int f){
        if(root==null)
            return 0;
        int l=diameter(root.left,f+1);
        int r=diameter(root.right,f+1);
        sum=Math.max(sum,r+l);
        if(f==0)
            return sum;
        return 1+Math.max(r,l);
    }
    void addNode(Node newNode){
        if(root==null){
            root=newNode;
        }
        else{
            Node x = root;
            if(x.key>=newNode.key){
                if(x.left==null){
                    x.left=newNode;
                }
                else{
                    x=x.left;
                    check(x,newNode);
                }
            }
            else{
                if(x.right==null){
                    x.right=newNode;
                }
                else{
                    x=x.right;
                    check(x,newNode);
                }
            }
        }
    }
    void check(Node x,Node newNode){
        while(x!=null){
            if(x.key>=newNode.key){
                if(x.left==null){
                    x.left=newNode;
                    break;
                }
                else
                    x=x.left;
            }
            else{
                if(x.right==null){
                    x.right=newNode;
                    break;
                }
                else
                    x=x.right;
            }
        }
    }
}
