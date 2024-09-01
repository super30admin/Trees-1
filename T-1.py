# Trees-1

## Problem 1 https://leetcode.com/problems/validate-binary-search-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
# using stack
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        stack = []
        prev = None
        while root != None or len(stack) > 0:
            while root != None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev != None and prev.val >= root.val:
                return False
            prev = root
            root = root.right
        return True
# TC = O(n), SC = O(n)

# Recursion
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root  == None:
            return True
        self.isValid = True
        self.dfs(root, None, None)
        return self.isValid
    
    def dfs(self, root: Optional[TreeNode], Min: int, Max: int) -> None:
        if root == None:
            return 
        if (Min != None and root.val <= Min) or (Max != None and root.val >= Max):
            self.isValid = False
            return
        self.dfs(root.left, Min, root.val)
        self.dfs(root.right, root.val, Max)
 # TC = O(n), SC = O(n)

## Problem 2 https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder == None or len(preorder) == 0 or len(inorder) == 0:
            return None
        root = TreeNode(preorder[0])
        rootIdx = 1
        for i in range(len(inorder)):
            if inorder[i] == root.val:
                rootIdx = i
                break
        inorderLeft = inorder[:rootIdx + 1]
        inorderRight = inorder[rootIdx + 1:]
        
        preorderLeft = preorder[1:rootIdx + 1]
        preorderRight = preorder[rootIdx + 1:]

        root.left = self.buildTree(preorderLeft, inorderLeft)
        root.right = self.buildTree(preorderRight, inorderRight)

        return root

# TC = O(n^2) , SC = O(nh)

#  alternate solution using Hashmap:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder == None or len(preorder) == 0 or len(inorder) == 0:
            return None
        self.hashMap = dict()
        for i in range(len(inorder)):
            self.hashMap[inorder[i]] = i
            self.index = 0
        return self.createTree(preorder,0, len(preorder)-1)


    def createTree(self, preorder, start, end):
        #base
        if start > end:
            return None

        #logic
        root =TreeNode(preorder[root.index])
        self.index = self.index+1
        rootIdx = self.hashMap[root.val]

        root.left = self.createTree(preorder, start, rootIdx -1)
        root.right = self.createTree(preorder, rootIdx -1, end)
        
        return root
    
#TC = O(n), SC = O(n)