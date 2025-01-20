# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # Hashmap to store indices of inorder values for quick lookup
        inIdxMap = {v: i for i, v in enumerate(inorder)}
        self.preIdx = 0  # Pointer to the current root in preorder

        def arrayToTree(l, r):
            # Base case: if the current subtree is empty
            if l > r:
                return None
            # Get the root value from preorder
            rootVal = preorder[self.preIdx]
            self.preIdx += 1
            # Create the root node
            root = TreeNode(rootVal)
            # Recursively build the left and right subtrees
            root.left = arrayToTree(l, inIdxMap[rootVal] - 1)
            root.right = arrayToTree(inIdxMap[rootVal] + 1, r)

            return root

        return arrayToTree(0, len(inorder) - 1)
        # T: O(n), S: O(n)