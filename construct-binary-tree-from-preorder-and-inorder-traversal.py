''' Time Complexity : O(n) 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''
class Solution:

    def __init__(self):
        self.hashmap={}
        self.idx=0

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        inorder_len = len(inorder)
        self.hashmap = {}
        for i in range(inorder_len):
            self.hashmap[inorder[i]] = i

        def helper(preorder, start, end):
            if start > end:
                return None
            rootval = preorder[self.idx]
            root_idx = self.hashmap[rootval]
            self.idx += 1
            
            treenode = TreeNode(rootval)
            treenode.left = helper(preorder,start, root_idx-1)
            treenode.right = helper(preorder,root_idx+1,end)
            return treenode

        return helper(preorder,0, len(inorder)-1)