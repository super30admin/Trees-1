

class Solution:
    '''
    Iterative
    Time Complexity: O(n)
    Space Complexity: O(n)
    '''
    def isValidBST(self, root: TreeNode) -> bool:
        if not root:
            return False
        stack = [(root, -math.inf, math.inf)]

        while stack:
            node, lower, upper = stack.pop()
            if not (lower < node.val < upper):
                return False
            if node.right:
                if node.right.val <= node.val:
                    return False
                # add the right node to the stack
                stack.insert(0, (node.right, node.val, upper))

            if node.left:
                if node.left.val >= node.val:
                    return False
                stack.insert(0, (node.left, lower, node.val))
        
        return True

class Solution:
    '''
    Recursive
    Time Complexity:O(n)
    Space Complexity:O(n) 
    '''
    def isValidBST(self, root: TreeNode) -> bool:
        
        def validate(node, low, high):
            
            # check to see if tree is empty
            if not node: return True
            
            # then check if the current node value is between low and high
            if node.val <= low or node.val >= high: return False
            
            # search recursivley through both right and left
            return (validate(node.right, node.val, high) and validate(node.left, low, node.val))
        
        # you need to have some sort of boundary so you can use math.inf
        return validate(root, -math.inf, math.inf)