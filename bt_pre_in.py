#Time Complexity: O(N).
#Auxiliary Space: O(N)
#Did this code successfully run on Leetcode :Yes

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.pre_idx =0
        self.inorder_map = {}
        
    
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        
        def array_tree(left,right):
            
            if left>=right:
                return
        
            root_value = preorder[self.pre_idx]
            root_index = self.inorder_map[root_value]
            root = TreeNode(root_value)
            self.pre_idx+=1
            root.left = array_tree(left,root_index)
            root.right = array_tree(root_index+1,right)
            return root
        
        
        for index, value in enumerate(inorder):
            self.inorder_map[value] = index
            
        
        return array_tree(0,len(preorder))