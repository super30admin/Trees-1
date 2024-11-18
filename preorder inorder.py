#TC: O(n)
#SC: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def construct_tree(preorder_index: int, inorder_index: int, tree_size: int):
            if tree_size <= 0:
                return None

            root_value = preorder[preorder_index]
          
            inorder_root_index = value_to_index[root_value]
          
            left_subtree = construct_tree(preorder_index + 1, inorder_index, inorder_root_index -inorder_index)
          
            right_subtree = construct_tree(preorder_index + 1 + inorder_root_index - inorder_index, 
                                           inorder_root_index + 1, 
                                           tree_size - inorder_root_index + inorder_index - 1)
         
            return TreeNode(root_value, left_subtree, right_subtree)

        value_to_index = {value: i for i, value in enumerate(inorder)}
     
        return construct_tree(0, 0, len(preorder))
