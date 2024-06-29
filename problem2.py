#Time Complexity : O(n)
#Space Complexity : O(n) - hashmap
#Any problem you faced while coding this : -

#The approach is to perform use the inorder list for getting the roots at every level and inorder list for getting the left and right subtrees. We keep track of the start and end indices for the preorder list at every recursive call to create the nodes accordingly. The root node has value fetched from the hashmap and we recursively call the function for left subarray and right subarray. 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.map_inorder = defaultdict(int)
        self.idx = 0

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        for i, node in enumerate(inorder):
            self.map_inorder[node] = i

        return self.helper(preorder, 0, len(inorder)-1)

    def helper(self, preorder, start, end):
        if start > end:
            return None

        rootVal = preorder[self.idx]
        self.idx += 1
        root = TreeNode(rootVal)
        rootIdx = self.map_inorder[rootVal]
        root.left = self.helper(preorder, start, rootIdx-1)
        root.right = self.helper(preorder, rootIdx + 1, end)

        return root



