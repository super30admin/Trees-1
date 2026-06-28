# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        """
        Logic:
        1. The first element in the `preorder` array is always the root of the current tree/subtree.
        2. We locate this root value in the `inorder` array. 
        3. In an inorder traversal, everything to the left of the root belongs to the left subtree, 
           and everything to the right belongs to the right subtree.
        4. We use the size of the left subtree (from `inorder`) to figure out which elements in 
           `preorder` belong to the left vs. right subtrees.
        5. We recursively repeat this process for the left and right subtrees.

        Time Complexity: O(N^2) in the worst case (where N is the number of nodes). 
                         For each node, we are searching for its index in `inorder` which takes O(N) time.
                         Additionally, list slicing takes O(N) time. In a skewed tree, the recursion depth 
                         is N, resulting in N * O(N) = O(N^2) time.
        
        Space Complexity: O(N^2) in the worst case. At each recursive call, we are creating new arrays 
                          via list slicing (`inLeft`, `inRight`, etc.). For a skewed tree with depth N, 
                          creating these slices repeatedly consumes O(N^2) memory. The recursion stack 
                          also takes O(N) space.
        """
        
        # Base case: If there are no elements left, the subtree is empty
        if len(preorder) == 0:
            return None

        # The root of the current subtree is always the first element in preorder
        rootVal = preorder[0]
        
        # Find the index of this root in the inorder list
        inorderRootIdx = -1
        for i in range(len(inorder)):
            if inorder[i] == rootVal:
                inorderRootIdx = i
                break

        # Split the inorder list into left and right subtrees
        inLeft = inorder[0:inorderRootIdx]
        inRight = inorder[(inorderRootIdx + 1):len(inorder)]
        
        # Split the preorder list into left and right subtrees
        # The number of elements in the left subtree is len(inLeft). 
        # We take that many elements from preorder (skipping the first element, which is the root).
        preLeft = preorder[1:(1 + len(inLeft))]
        preRight = preorder[(1 + len(inLeft)):len(preorder)]

        # Construct the root node
        root = TreeNode(rootVal)
        
        # Recursively construct the left and right subtrees using the sliced arrays
        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)

        return root