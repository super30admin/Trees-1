

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        # build hashmap for quick search
        idx_map = {val: idx for idx, val in enumerate(inorder)}
        self.pre_idx = 0

        def helper(in_left, in_right):
            # base case
            if in_left > in_right:
                return None

            # get root value from pre_order using pre_idx
            root_val = preorder[self.pre_idx]
            self.pre_idx += 1

            # we create the root node, as we need to return the actual tree
            root = TreeNode(root_val)

            # find root index in inorder using hashmap
            rootidx = idx_map[root_val]

            # recurse
            root.left = helper(in_left, rootidx - 1)
            root.right = helper(rootidx + 1, in_right)

            return root

        return helper(0, len(inorder) - 1)


        # we made the tree using just an array when we make custom test cases - how? - we had nulls - in order & pre order means we are missing nulls
        # adding nulls is called serialization
        # approach 1: we get the root index from pre order. 
        # we then find the root index in inorder, and then we know that the left subtree is to the left of root, and right subtree is to the right of the root
        # we similarly split the preorder sequence in the same two subtrees
        # we follow the same steps for each subtree, until we reach base condition
