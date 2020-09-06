// TC:O(N) where N represents the number of elements in preoder/inorder array.
// SC: O(N) since we are using Hashmap for storing values

// We know that the first element in the preorder will be always root. So, using this concept, we find the index of same element in inorder, we know that 
// elements left of root index in inorder array will come to left of the tree. ELements right of that root element index will be added to the right of the tree.
// Using this concept, we are keeping our inorder values and its index into hashmap so that we can get index of first element in prorder. This will help us
// finding our left elements of inorder array and right elements of inorder array. We do it recursively.

import java.util.*;

public class ConstructBT {
	
	HashMap<Integer, Integer> inorderMap = new HashMap();
	public TreeNode constructBT(int[] preorder, int[] inorder) {
		
		
		for(int i=0;i<inorder.length;i++) {
			inorderMap.put(inorder[i],i);
		}
		return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	}
	
	public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		
		if(preStart>preEnd || inStart>inEnd) {
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[preStart]);
		int rootIndex = inorderMap.get(root.val);
		int numOnleft = rootIndex - inStart;
		
		root.left = helper(preorder, preStart+1, preStart+numOnleft, inorder, inStart, rootIndex-1);
		root.right = helper(preorder, preStart+numOnleft+1, preEnd, inorder, rootIndex+1, inEnd);
				
		return root;
	}
	
	public TreeNode constructBTPI(int[] preorder, int[] inorder) {
		
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode root = new TreeNode(preorder[0]);
		TreeNode curr = root;

		for(int i=1, j=0;i<preorder.length;i++) {
			
			if(curr.val!=inorder[j]) { // if the curr val not equal to inorder, we add those values to left of tree since we know that values left of root goes to left tree
				curr.left = new TreeNode(preorder[i]); 
				st.push(curr);
				curr = curr.left;
			}else {
				j++;
				while(!st.isEmpty() && st.peek().val==inorder[j]) { // if the values are same as inorder, add them to the root, and any elements after root, 
					// add them to right of the root.
					curr = st.pop();
					j++;
					
				}
				curr = curr.right = new TreeNode(preorder[i]); // adding to right of the root
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		
		ConstructBT cbt = new ConstructBT();
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
//		TreeNode root = cbt.constructBT(preorder, inorder);
		TreeNode root = cbt.constructBTPI(preorder, inorder);
		System.out.println(root.val);
		System.out.println(root.left.val+" "+root.right.val+" "+ root.right.left.val+" "+root.right.right.val);
	}

}
