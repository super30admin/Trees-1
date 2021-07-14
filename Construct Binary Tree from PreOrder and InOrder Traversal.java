//Time Complexity : O(n);
//Space Complexity : O(n). O(n) for hashmap and O(h) for recursive stack. 
//Here n > h hence the space complexity is O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
class Solution {
    int index;//index to get the index of the node from inorder array
    Map<Integer,Integer> map;// to get O(1) time for retriving the inorder index
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||preorder==null){
            return null;
        }
        map = new HashMap<>();
        //add the inorder elements to map
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        //helper function to bulid the tree
        return helper(preorder,0,preorder.length-1);
    }
    private TreeNode helper(int preorder[],int start, int end){
        if(start>end){
            return null;
        }
        //get the root node from preorder
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        //find this node's index in inorder
        int idx = map.get(root.val);
        //determine the node's left and right nodes
        root.left = helper(preorder,start,idx-1);
        root.right = helper(preorder,idx+1,end);
        return root;
    }
}