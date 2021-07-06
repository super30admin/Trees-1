# Time Complexity : O(n) [n = number of elements in preorder list]
# Space Complexity : O(n) [n = number of elements in preorder list]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem Approach
# 1. The preoder list helps to identify sequence in which the nodes are added in Tree
# 2. The inorder list helps to identify whether the curr_node lies to left of its parent or right
#   2.1 for example [2,1,3]. In this  2 lies to the left of 1 and 3. 1 lies to the right of 2 and left of 3.
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        # Null check
        if preorder is None or len(preorder) <= 0:
            return None
        
        # Map to check if the val lies on left of root or right
        inorder_map = {}
        for i, val in enumerate(inorder):
            inorder_map[val] = i
        
        root = TreeNode(preorder[0])
        stack = [root]
        for i in range(1, len(preorder)):
            curr_node = TreeNode(preorder[i])

            # True if , the curr_node lies to the left of node on stack top
            if inorder_map[curr_node.val] < inorder_map[stack[-1].val]:
                stack[-1].left = curr_node
            else:
                parent = TreeNode()
                # Need to find the node to which the the curr_node can be added as right child
                while stack and inorder_map[curr_node.val] > inorder_map[stack[-1].val] :
                    parent = stack.pop()
                parent.right = curr_node
            stack.append(curr_node)
        return root