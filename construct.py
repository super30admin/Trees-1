
//Time complexity: O(n)
//space complexity: O(n)

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        # construct hashmap mapping a value to its inorder index
        idx = {} 
        for i, val in enumerate(inorder):
            idx[val] = i 
			
	# Iterate over preorder and construct the tree 
        stack = []
        head = None
        for val in preorder:
            if not head:
                head = TreeNode(val)
                stack.append(head)
            else:
                node = TreeNode(val)
                if idx[val] < idx[stack[-1].val]:
                    stack[-1].left = node
                else:
                    while stack and idx[stack[-1].val] < idx[val]:
                        u = stack.pop()
                    u.right = node
                stack.append(node)
        return head