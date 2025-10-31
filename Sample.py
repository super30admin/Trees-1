#Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        self.helper(root,result)
        return result
    
    def helper(self, root, result):
        if root == None:
            return

        # left
        self.helper(root.left, result)

        # root
        result.append(root.val)

        # right
        self.helper(root.right, result)
    
        return result
        

#Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None
        self.flag = True
        self.helper(root)
        return self.flag
    
    def helper(self, root):
        # base
        if root is None:
            return

        # left
        self.helper(root.left)

        # root
        if self.prev is not None and self.prev.val >= root.val:
            self.flag =  False

        # right
        self.prev = root
        self.helper(root.right)


#Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

# preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
# Make hashmap of inorder
# get root index from inorder by traversing on preorder
# go root.left -> start =parent start, end = rootidx -1
# go root.right -> start = rootidx +1, end = parent end
# parent is inorder
# also set an index tracker to traverse preorder list as well
# return root. Root has to be a TreeNode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.preidx = 0
        self.hashmap = {val:i for i, val in enumerate(inorder)}
        return self.helper(preorder,0,len(preorder)-1)

    
    def helper(self, preorder, start, end):
        # base
        if start > end:
            return None

        # logic
        rootval = preorder[self.preidx]
        rootidx = self.hashmap[rootval]
        self.preidx += 1

        # traversal
        root = TreeNode(rootval)
        root.left = self.helper(preorder,start,rootidx-1)
        root.right = self.helper(preorder,rootidx+1, end)
        return root


        


        