#Time Complexity: O(N)
#Space Complexity: O(N)



# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: Optional[TreeNode]
        """
        # Step 1: Build a hashmap for quick index lookup in inorder
        inorder_index_map = {val: idx for idx, val in enumerate(inorder)}
        
        # Step 2: Use a variable to keep track of the current index in preorder
        self.pre_idx = 0

        def helper(left, right):
            if left > right:
                return None

            # Step 3: Pick root from preorder using pre_idx and move index
            root_val = preorder[self.pre_idx]
            self.pre_idx += 1
            root = TreeNode(root_val)

            # Step 4: Get inorder index of the root from map
            index = inorder_index_map[root_val]

            # Step 5: Recursively build left and right subtrees
            root.left = helper(left, index - 1)
            root.right = helper(index + 1, right)

            return root

        return helper(0, len(inorder) - 1)