//3points :  Learned from Geek For Greek  
// A Tree is called a Binary Search Tree if it follows these conditions
// 1. The left subtree of a node contains only nodes with keys less than the node's key.
// 2. The right subtree of a node contains only nodes with keys greater than the node's key. 
// 3. Both the left and right subtrees must also be binary search trees  


// Time Complexity : O(n) 
// Space Complexity : O(1) if Function Call Stack size is not considered, otherwise O(n)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public class isValidBST {
	
	//A binary tree node has data, pointer to 
	//left child && a pointer to right child / 
	static class Node 
	{ 
		int data; 
		Node left, right; 
	}; 

	//Returns true if given tree is BST. 
	static boolean isBST(Node root, Node l, Node r) 
	{ 
		// Base condition 
		if (root == null) 
			return true; 

		// if left node exist then check it has 
		// correct data or not i.e. left node's data 
		// should be less than root's data 
		if (l != null && root.data <= l.data) 
			return false; 

		// if right node exist then check it has 
		// correct data or not i.e. right node's data 
		// should be greater than root's data 
		if (r != null && root.data >= r.data) 
			return false; 

		// check recursively for every node. 
		return isBST(root.left, l, root) && 
			isBST(root.right, root, r); 
	} 

	//Helper function that allocates a new node with the 
	//given data && null left && right pointers. / 
	static Node newNode(int data) 
	{ 
		Node node = new Node(); 
		node.data = data; 
		node.left = node.right = null; 
		return (node); 
	} 

	public static void main(String[] args) {

		Node root = newNode(2); 
		root.left = newNode(1); 
		root.right = newNode(3); 
		//root.left.left = newNode(1); 
		//root.left.right = newNode(4); 

		if (isBST(root,null,null)) 
			System.out.print("BST : True"); 
		else
			System.out.print("BST : False"); 
	} 

}






