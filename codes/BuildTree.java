class Node { 
	char data; 
	Node left, right; 

	Node(char item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

public class BinaryTree { 
	Node root; 
	static int preIndex = 0; //in case of given postorder use preIndex=inorder.lenght

	Node buildTree(char in[], char pre[], int inStrt, int inEnd) 
	{ 
		if (inStrt > inEnd) 
			return null; 

		Node x= new Node(pre[preIndex++]); //in case of given postorder use preIndex--.
		if (inStrt == inEnd) 
			return x; 

		int inIndex = search(in, inStrt, inEnd, tNode.data); 

		x.right = buildTree(in, pre, inIndex + 1, inEnd); 
		x.left = buildTree(in, pre, inStrt, inIndex - 1); 
		return x; 
	} 
	int search(char arr[], int strt, int end, char value) 
	{ 
		int i; 
		for (i = strt; i <= end; i++) { 
			if (arr[i] == value) 
				return i; 
		} 
		return i; 
	} 

	/* This funtcion is here just to test buildTree() */
	void postorder(Node node) 
	{ 
		if (node!=null) {
    		printInorder(node.left); 
    		printInorder(node.right);
    		System.out.print(node.data + " "); 
		}
	} 
	public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' }; 
		char pre[] = new char[] { 'D', 'E', 'B', 'F', 'C', 'A' }; 
		int len = in.length; 
		Node root = tree.buildTree(in, pre, 0, len - 1); 
		System.out.println("Inorder traversal of constructed tree is : "); 
		tree.postorder(root); 
	} 
} 

