########98. Validate Binary Search Tree########################################################################################################################
// Time Complexity : n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
We took previous pointer as NULL and started traversing tree in INORDER and making last visited node as PREV and current node as CURR and comparing always prev to be less than current 

98. Validate Binary Search Tree
        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev=TreeNode(None)
        self.flag=True

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inOrder(root)
        return self.flag


    def inOrder(self,root):
        if not root:
            return
        self.inOrder(root.left)
        print('1. root and prev: ',root.val,self.prev.val)
        if self.prev.val is not None and self.prev.val>=root.val:
            print('in if')
            self.flag=False
        self.prev=root
        print('2. root and prev: ',root.val,self.prev.val)
        self.inOrder(root.right)


        
        

#######105. Construct Binary Tree from Preorder and Inorder Traversal###################################################################################################################


// Time Complexity : n
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I coded without using index  and instead passing new ignorer and preorder array each time but than performed white boarding and did it by using index so extra space was used

// Your code here along with comments explaining your approach in three sentences only
We use index to traverse in preorder, so each index give us next node the problem is to identify which are left node which was helped using inorder by find the location of root in ignorer array and all element on its left are eft side of tree



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.idx=0

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        dict1={}
        #self.idx=0
        #print(self.idx)
        for i,val in enumerate(inorder):
            dict1[val]=i
        return self.helper(dict1,inorder, preorder, 0, (len(inorder)-1))
        
    def helper(self,dict1,inorder,preorder,s,e):
        #base
        if s>e:
            return None

        #logic
        #print(self.idx)
        rootval=preorder[self.idx]
        root=TreeNode(rootval)
        idx_inorder=dict1[rootval]
        self.idx+=1
        root.left=self.helper(dict1,inorder,preorder,s,idx_inorder-1)
        root.right=self.helper(dict1,inorder,preorder,idx_inorder+1,e)
        return root

        

