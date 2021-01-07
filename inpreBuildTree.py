class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        '''
        Timecomplexity : O(log(n))
        spacecomplexity : O(log(n))
        
        for inorder traversal 
            left root right
        for preorder travarsal
            root left right
            
        step 1 : from preorder you get the root value (as the first value is root)
        step 2 : from inorder get the position of root value
        step 3 : As in preorder the travrsal is
                        [ left subtree (root) right subtree ]
        step 4 : get left subtree and right subtreee length
        step 5 : extract the left sub tree inorder travrsal from inorder travarsal using lenght of left subtree
        step 6 : extract the right sub tree inorder travrsal from inorder travarsal
        step 7 : recall the function on left subtree and right subtree
        '''
        
        if len(preorder) == 0: return None
        root = TreeNode(preorder[0])
        index = inorder.index(root.val)
        left_inorder = inorder[:index]
        right_inorder = inorder[index+1:]
        left_preorder = preorder[1:index + 1]
        right_preorder = preorder[index + 1:]
        root.left = self.buildTree(left_preorder,left_inorder)
        root.right = self.buildTree(right_preorder,right_inorder)
        return root
        