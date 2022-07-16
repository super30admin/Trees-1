#Iterative inorder traversal
"""
Runtime Complexity:
O(n)- because we traverse 'n' nodes by moving left and right and append it to stack and check whether the current root val is greater then previous val, if it is then it is a valid BST else not. 
Space Complexity:
O(h) -  recursive stack stores node of 'h' levels where h is the depth/height of the tree. Because in first call to our root.left, it reaches the depth of tree, whereas other elements are not added to stack at this time and we continue our procedure by performing push and pop.
Yes, the code worked on leetcode.
"""
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
            stack, prev = [],-math.inf
            
            while root or stack:
                while root:
                    stack.append(root)
                    root = root.left
                root = stack.pop()
                if root.val <= prev:
                    return False
                prev = root.val
                root = root.right
            return True

#Recursive inorder traversal
"""
Runtime Complexity: O(n)
Space Complexity: O(h)
Yes, the code worked on leetcode
"""
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def inorder(root):
            if not root:
                return True
            if not inorder(root.left):  #if no left child but right child present
                return False
            if self.prev>=root.val:
                return False
            self.prev = root.val
            return inorder(root.right)
        self.prev = -math.inf
        return inorder(root)
        
                
                    
                