# Binary_tree_preorder_inorder
# time complexity: O(N)
# space complexity: O(N)
# Did this code successfully run on Leetcode : NA
# Any problem you faced while coding this : NA

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        preorder = deque(preorder)
        
        def helper(inorder,preorder):
            if inorder:
                root_value = preorder.popleft()
                index = inorder.index(root_value)
                node = TreeNode(root_value)
                left_arr = inorder[:index]
                right_arr = inorder[index+1:]
                node.left = helper(left_arr, preorder)
                node.right = helper(right_arr, preorder)
                return node
        
        return helper(inorder, preorder)