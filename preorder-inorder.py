# Time Complexity: O(n)
# Space Complexity: O(n)
# Approach: 
# Use the preorder traversal to get the root element
# Recurse on the left and right half of the inorder array to construct the tree

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        def helper(p_start, p_end, i_start, i_end):
            # Base Case
            if p_start > p_end:
                return None
            if p_start == p_end:
                return TreeNode(preorder[p_start])
            
            root_val = preorder[p_start]
            root_index = ino_map[root_val]
            root = TreeNode(root_val)
            
            # Number of elements in left subtree:
            numleft = root_index - i_start
            # Number of elements in right subtree:
            numright = i_end - root_index
            
            # Recursively construct left and right subtrees
            root.left = helper(p_start + 1, 
                               p_start + numleft, 
                               i_start, 
                               root_index - 1)
            root.right = helper(p_start + numleft + 1,
                                p_end,
                                root_index + 1,
                                i_end)
            return root            
            
        # Maintain a hashmap of indexes of inorder array
        ino_map = {}
        for i in range(len(inorder)):
            ino_map[inorder[i]] = i
        
        return helper(0, len(preorder) - 1, 0, len(inorder) - 1)
            