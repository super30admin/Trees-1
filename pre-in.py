# O(n^2) time bc .index takes O(n) and you do it N times
# O(n^2) space $O(N^2)$While the recursion depth is $O(N)$, each call creates new list slices. Summing the memory of these slices across all levels of the recursion tree results in $O(N^2)$ total space used during the process.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self, val=0,left=None,right=None):
        self.val = val
        self.left = left
        self.right = right 

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # both inorder and postorder are required to reconstruct the tree
        # with just one and not the other you don't know which is root

        # in order: left, root, right
        # pre order: root, left, right

        if not preorder:
            return None
        
        rootVal = preorder[0] # 3
        rootIdx = inorder.index(rootVal) # get the index of 3 in inorder

        inLeft = inorder[:rootIdx] # inorder left subtree [8,9]
        inRight = inorder[rootIdx+1:] # inorder right subtree [15,20,7]
        preLeft = preorder[1:1+len(inLeft)] # [9,8]
        preRight = preorder[1+len(inLeft):] # [20,15,7]

        root = TreeNode(rootVal)
        root.left = self.buildTree(preLeft, inLeft)
        root.right= self.buildTree(preRight, inRight)

        return root

# How to optimize this to O(N)
# To reach linear time and space, you need to stop copying the lists and stop searching for the index manually.
# Use a Hash Map: Store the inorder values and their indices in a dictionary: {val: index}. 
# This makes finding rootIdx an O(1) operation.Use Pointers: Instead of slicing lists (which creates copies), 
# pass the start and end indices of the current subtree range.

# use a hashmap with pointers
class Solution:
    def buildTree(self, preorder, inorder):
        self.idx = 0
        # Create an empty dictionary
        inorder_map = {}

        # Use a standard loop with enumerate to fill it: { val: i }
        for i, val in enumerate(inorder):
            inorder_map[val] = i
        return self.helper(preorder, 0, len(inorder) - 1, inorder_map)

    def helper(self, preorder, start, end, inorder_map):
        if start > end:
            return None 
        # move preorder index by 1 each time
        rootVal = preorder[self.idx]
        self.idx+=1
        root = TreeNode(rootVal)
        rootIdx = inorder_map[rootVal]
        root.left = self.helper(preorder,start,rootIdx-1,inorder_map)
        root.right = self.helper(preorder, rootIdx+1,end,inorder_map)

        return root 





