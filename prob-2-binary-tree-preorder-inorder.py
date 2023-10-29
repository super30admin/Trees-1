class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:

        """

		Time Complexity: O(n)
            Hash Map take O(n) time
            Traversing tree takes O(n) time
            
        Space Complexity: O(n)
        Did this code successfully run on Leetcode: Yes
    
        Any problem you faced while coding this: No

        """

        # left, right are the index values of the inorder traversal
        def array_to_tree(left, right):
            print(f"left={left}  right={right}")
            nonlocal preorder_index
            # if there are no elements to construct the tree
            if left > right: return None

            # select the preorder_index element as the root and create the root node
            root_value = preorder[preorder_index]
            root = TreeNode(root_value)
            # Now increment the preorder_index 
            preorder_index += 1

            # build left and right subtree
            # exclude the root value
            # Build the left tree. 
            # Find where is the start index and end index of this tree in inorder
            # End of the tree would be to the immediate left (-1) of root_value. 
            root.left = array_to_tree(left, inorder_hashmap[root_value]-1)

            # Build the right tree
            # The start of the tree would be to the immediate right (+1) of root_value
            root.right = array_to_tree(inorder_hashmap[root_value] + 1, right)
            return root


        inorder_hashmap = {}
        for index, value in enumerate(inorder):
            inorder_hashmap[value] = index

        preorder_index = 0
        # Call the helper method with the entire length of the preorder tree
        return array_to_tree(0, len(preorder) - 1)
