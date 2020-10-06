def isValidBST(self, root: TreeNode) -> bool:
        
        def helper(node,left =float('-inf'),right=float('inf')):
            if not node:
                return True
            
            val = node.val
            if val>=left and val<=right:
                return True
            
            if helper(node.right,val,right):
                return True
            if helper(node.left,left,val):
                return True
            
            return False
        
        return helper(root)
        
     '''Approach, recursively 
        check val of node and compare it with its left and right node, recursively check it for left and right sub tree, 
        If BST condition satisfies return true, else false, time complexity is o(n) because each node is traversed once, and space complexity is o(n) because of recursion stack'''
