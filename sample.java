//Problem 1
//Time: O(n)
//Space: O(depth of Tree)
class Solution1 {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        
        //previous node
        TreeNode prev = null;

        //stack to store the nodes
        Stack<TreeNode> stack = new Stack<>();
        

        //loop to copy node elements to the stack
        //inorder traversal]
        while(!stack.isEmpty() || root != null){

            //we keep adding the left nodes until we reach a leaf
            // and then start procesing
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            //removing the element after it is processed
            TreeNode curr = stack.pop();
            
            //comparing the last node(the left most) with the current(root)
            //if prev is > curr then not a BST
            if(prev != null && prev.val >= curr.val){
                return false;
            }

            //otherwise move up the tree and to the right side
            prev = curr;
            root = curr.right;
        }

        //if we reach here then we have processed the whole tree and 
        //it is BST
        return true;
    }
}

//Problem 1
//Time: O(n)
//Space: O(depth of Tree)


class Solution2 {
    //global Index
    private int preIndex;

    //map to store indices for inorder traversal
    //so that we can easily access the index of the root with O(1)
    private HashMap<Integer, Integer> hashMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        hashMap = new HashMap<>();
        preIndex = 0;
        
        //storing values mapped to indices from inorder array
        for(int i = 0; i < inorder.length; i++){
            hashMap.put(inorder[i],i);
        }
        
        return buildNewTree(inorder, preorder, 0, inorder.length - 1);
         
    }

                                                                 
    private TreeNode buildNewTree(int[] inorder, int[] preorder, 
                                int inStart,//starting point of the node in the inorder array
                                int inEnd //ending point of the node in the inorder array) 
                                {
        
        //if starting Index > ending Index
        //then not a valid node
        //meaning its a leaf
        if(inStart > inEnd){
            return null;
        }

        //get the root from the preorder(starting at 0, then 1,......)
        TreeNode root = new TreeNode(preorder[preIndex]);
        
        //Increment Index for the next root
        preIndex++;
        
        //get the value of the root from the hashmap
        int index = hashMap.get(root.val);

        //move to the left(recurssion)
        root.left = buildNewTree(inorder, preorder, inStart, index-1);
        //move to the right(recurrsiom)
        root.right = buildNewTree(inorder, preorder, index+1, inEnd);
        
        //get the binary tree
        return root;
    }
    
}