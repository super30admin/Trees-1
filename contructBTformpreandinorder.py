# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.index=0
        inorder_map={val:i for i,val in enumerate(inorder)}
        return self.helper(preorder, 0, len(inorder)-1, inorder_map)

    def helper(self, preorder, start, end, inorder_map):
        if start>end:
            return

        root_val=preorder[self.index]
        self.index+=1
        root=TreeNode(root_val)
        root_index=inorder_map[root_val]

        root.left=self.helper(preorder,start,root_index-1,inorder_map)
        root.right=self.helper(preorder,root_index+1,end,inorder_map)
        return root