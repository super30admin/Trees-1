class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        time: O(n)
        space: O(height)
        """
        def helper(t, max=float("inf"), min=float("-inf")):
            if not t:
                return True
            return (max > t.val > min and
            helper_bool(t.left, t.val, min) and
            helper_bool(t.right, max, t.val))
        return helper(root)

    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        time: O(n)
        space: O(n)
        """
        elem2idx_inorder = {inorder[i]:i for i in range(len(inorder))}

        def helper(root_idx=0, inorder_start=0, inorder_end=len(inorder)-1):
            if inorder_start > inorder_end:
                return None
            root_val = preorder[root_idx]
            inorder_root_idx = elem2idx_inorder[root_val]
            
            left_tree = helper(root_idx+1, inorder_start, inorder_root_idx-1)
            left_tree_size = inorder_root_idx - inorder_start
            right_tree = helper(root_idx + left_tree_size + 1, inorder_root_idx+1, inorder_end)

            return TreeNode(root_val, left_tree, right_tree)
        return helper()

