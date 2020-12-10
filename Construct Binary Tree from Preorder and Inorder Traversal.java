/*
# O(n^2) time and space
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if inorder is None or len(inorder) == 0:
            return None
        if preorder is None or len(preorder) == 0:
            return None
        
        rootVal = preorder[0]
        root = TreeNode(rootVal)
        idx = 0
        
        for i in range(len(inorder)):
            if inorder[i] == rootVal:
                idx = i
                break
        
        preorderLeft = preorder[1:idx+1]
        preorderRight = preorder[idx+1:len(preorder)]
        inorderLeft = inorder[0:idx]
        inorderRight = inorder[idx+1:len(inorder)]
        
        root.left = self.buildTree(preorderLeft, inorderLeft)
        root.right = self.buildTree(preorderRight, inorderRight)
        
        return root


# We can have index declared in the function. O(n) time and space
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        inHash = dict()
        for i, val in enumerate(inorder):
            inHash[val] = i
        self.index = 0
        
        def createTree(preorder, inorder, start, end):
            # base case
            if start > end:
                return None
            
            # create Tree Node
            node = TreeNode(preorder[self.index])
            
            # find index of element in inorder list using location information in the hash map.
            idx = inHash[node.val]
            self.index += 1
            
            # create left and right subtree.
            node.left = createTree(preorder, inorder, start, idx-1)
            node.right = createTree(preorder, inorder, idx+1, end)
            return node
        
        return createTree(preorder, inorder, 0, len(preorder)-1)


# We can have index declared in the the constructor. O(n) time and space
class Solution:
    def __init__(self):
        self.idx = 0
        
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        mapping = {}
        if preorder is None or len(preorder) == 0:
            return None
        
        for i in range(len(inorder)):
            mapping[inorder[i]] = i
            
        return self.helper(preorder, inorder, 0, len(inorder)-1, mapping)
    
    def helper(self, preorder, inorder, start, end, mapping): 
        if start > end:
            return None
        
        rootVal = preorder[self.idx]
        self.idx += 1
        root = TreeNode(rootVal)
        rootIdx = mapping[rootVal]
        root.left = self.helper(preorder, inorder, start, rootIdx-1, mapping)
        root.right = self.helper(preorder, inorder, rootIdx+1, end, mapping)
        return root
*/



// O(n^2) time and space
/*
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || inorder.length == 0){
            return null;
        }
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        int idx = 0;
        for (int i=0; i<inorder.length; i++){
            if (inorder[i] == rootValue){
                idx = i;
                break;
            }
        }
        
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, idx+1);
        int[] preorderRight = Arrays.copyOfRange(preorder, idx+1, preorder.length);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, idx);
        int[] inorderRight = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        
        return root;
    }
}
*/

// Time Complexity : O(N) where N is number of nodes in tree
// Space Complexity : O(N) where N is number of nodes in inorder array
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach: I maintained a hashmap for inorder and I got root from preorder


class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || inorder.length == 0){
            return null;
        }
        map = new HashMap<>();
        idx = 0;
        for (int i =0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
        
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        if (start > end){
            return null;
        }
        int rootVal = preorder[idx];
        idx ++;
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        root.left = helper(preorder, inorder, start, rootIndex-1);
        root.right = helper(preorder, inorder, rootIndex+1, end);
        return root;
    }
}
