#Time Complexity :O(N)
#Space Complexity: O(N)


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None

        # Create a root node with the first element of the preorder list
        root = TreeNode(preorder[0])
        stack = [root]  # Use a stack to keep track of nodes
        in_idx = 0

        for i in range(1, len(preorder)):
            pre_val = preorder[i]
            node = stack[-1]
        

            if node.val != inorder[in_idx]:
                # Create a new node from the preorder list
                node.left = TreeNode(pre_val)
                stack.append(node.left)
            else:
                # Find the node in the stack with the same value as pre_val
                while stack and stack[-1].val == inorder[in_idx]:
                    node = stack.pop()
                    in_idx += 1
                # Create a new node from the preorder list
                node.right = TreeNode(pre_val)
                stack.append(node.right)

        return root
