package s30Coding;

//Time Complexity :- O(n) where n is the number of nodes in the tree
//Space Complexity :- O(h) where h is the height of the tree


class ListNode{
	int val;
	ListNode left;
	ListNode right;
	ListNode(int val){
		this.val = val;
	}
}

public class ValidBST {
	public boolean BST(ListNode node) {
		return helper(node,null,null);
	}
	
	public boolean helper(ListNode node,Integer min, Integer max) {
		if(node == null)return true;
		if((max != null && node.val >= max) && (min !=null && node.val <= min)) return false;
		
		return helper(node.left,min,node.val) && helper(node.right,node.val,max);
	}
}
