# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.ptr = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorderIdx = {val:idx for idx, val in enumerate(inorder)}

        
        def helper(start, end):
            # base condition
            if self.ptr == len(preorder) or start > end:
                return None

            val = preorder[self.ptr]
            root = TreeNode(val)
            idx = inorderIdx[val]
            self.ptr += 1
            root.left = helper(start, idx-1)
            root.right = helper(idx+1, end)
            return root

        return helper(0, len(inorder)-1)
            

#TC: O(n)
#SC: O(1)


