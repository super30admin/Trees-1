# Time complexity: O(n^2)
# Space complexity: O(n^2)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) == 0: return None
        rootVal = preorder[0]
        #rootIdx = -1
        root = TreeNode(rootVal)
        for i in range(len(inorder)):
            if inorder[i] == rootVal:
                rootIdx = i
        
        inorder_left = inorder[0:rootIdx]
        inorder_right = inorder[rootIdx+1:len(inorder)] 
        preorder_left = preorder[1:len(inorder_left)+1]
        preorder_right = preorder[len(inorder_left)+1:len(preorder)]

        root.left = self.buildTree(preorder_left,inorder_left)
        root.right = self.buildTree(preorder_right,inorder_right)

        return root



# Time complexity: O(n)
# Space complexity: O(n)               
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self):
        self.idx = 0
        self.hmap = {}

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        for i in range(len(inorder)):
            if inorder[i] not in self.hmap:
                self.hmap[inorder[i]] = i
        return self.helper(preorder, inorder, 0, len(inorder) - 1)

    def helper(self, preorder: List[int], inorder: List[int], start: int, end: int) -> Optional[TreeNode]:
        # base
        if start > end:
            return None
        
        # logic - get the root value
        rootVal = preorder[self.idx]
        self.idx += 1  # move to the next root in the preorder list
        root = TreeNode(rootVal)
        rootIdx = self.hmap[rootVal]
        root.left = self.helper(preorder, inorder, start, rootIdx - 1)
        root.right = self.helper(preorder, inorder, rootIdx + 1, end)

        return root
