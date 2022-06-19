"""Approach:
We find the root index in inorder traversal list. Then use that to divide inOrder left and right. 
Then use same rootIdx to get preOrder left and preOrder right such that 1:rootIdx+1 and rootIdx+1:till the end

TC: O(n^2) - we are creating 4 array copies and we are doing it at n roots also a for loop to find root.
SC: O(n^2)  - at each node we are creating extra arrays - for n nodes n arrays.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # None check
        if len(preorder) == 0: return None
        
        # find root in inorder
        rootVal = preorder[0]
        # create a TreeNode for rootVal
        root = TreeNode(rootVal)
        rootIdx = -1   # Index of root in Inorder traversal
        for i in range(len(inorder)):
            if inorder[i] == rootVal:
                rootIdx = i
                break
        # anything on left of rootIdx is left subtree
        inLeft = inorder[:rootIdx]
        # anything on right of rootIdx is right subtree
        inRight = inorder[rootIdx+1:]
        # first node is root, at index 0, so start at index 1 till rootIdx to get leftSubTree
        preLeft = preorder[1:rootIdx+1]
        # rootIdx+1 onward till the end is right subtree
        preRight = preorder[rootIdx+1:]
        
        # recursively call buildTree on left and right of pre and in order arrays and assign it to root.left and root.right
        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)
        
        return root


"""Approach:
Recursive approach without extra arrays. Use start and end indices for preorder.
And use map to get indices for root from inorder array in O(1)
TC: O(n) - we are going over 1 index at a time over preorder array, number of nodes in the tree is n
SC: O(n) - as we are constructing the inorder hashmap
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    m = dict()  # map inorder as k:index mapping
    idx = 0  # index that increases 1 at a time for every recursion to give us next root
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # None check
        if len(preorder) == 0: return None
        
        self.m = { k:i for i, k in enumerate(inorder)}
        print(self.m)
        
        return self.helper(preorder, 0, len(preorder)-1)
        
    def helper(self, preorder, start, end) -> Optional[TreeNode]:
        # base
        if start > end: return None
        
        # find root in inorder
        
        rootVal = preorder[self.idx]
        
        # create a TreeNode for rootVal
        root = TreeNode(rootVal)
        self.idx += 1
        rootIdx = self.m[rootVal]
        
        # recursively call buildTree on left and right of pre and in order arrays and assign it to root.left and root.right
        root.left = self.helper(preorder, start, rootIdx - 1)
        root.right = self.helper(preorder, rootIdx+1, end)
        
        return root