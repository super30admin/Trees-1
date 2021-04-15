# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        if not preorder or not inorder:
            return None
        def builder(in_start,in_end):
            nonlocal pre_idx
            if(in_start>in_end):
                return None
            elif (in_start == in_end):
                node= TreeNode(preorder[pre_idx])
                pre_idx +=1
                return node
            root_val=preorder[pre_idx]
            root_idx=idx_map[root_val]
            root=TreeNode(root_val)
            pre_idx +=1
            root.left=builder(in_start, root_idx-1)
            root.right=builder(root_idx+1,in_end)
            return root
            
        pre_idx=0
        idx_map={}
        for idx,val in enumerate(inorder):
            idx_map[val]= idx
        return builder(0,len(inorder)-1)
        
        
        