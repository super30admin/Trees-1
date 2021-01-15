# Created by Aashish Adhikari at 11:36 AM 1/15/2021

'''
Time Complexity:
If k is the average length of the number of elements to each node, O(n . k ) since at each node we are calculating the index of the root element.

Space Complexity:
O(n)


'''



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def helper(self, preorder, inorder):

        # base case
        if len(preorder) == 0:
            return None


        # logic
        root = preorder[0]
        idx_of_root = inorder.index(root)

        left_subtree_elements_inorder = inorder[:idx_of_root]
        right_subtree_elements_inorder = inorder[idx_of_root+1 :]

        num_left_subtree_elements = len(left_subtree_elements_inorder)
        num_right_subtree_elements = len(right_subtree_elements_inorder)

        root_node = TreeNode(root)
        root_node.left = self.helper(preorder[1:num_left_subtree_elements+1] , left_subtree_elements_inorder)
        root_node.right = self.helper(preorder[num_left_subtree_elements+1:] , right_subtree_elements_inorder)

        return  root_node


    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """

        return self.helper(preorder, inorder)



