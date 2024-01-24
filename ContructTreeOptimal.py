class Solution(object):
    def buildTree(self, preorder, inorder):

        #HashMap to store element and map to their index
        inorderMap = {}

        for i in range(len(inorder)):
            inorderMap[inorder[i]] = i

        # Helper fuction
        def helper(preStart, start, end):
            if start > end:
                return None
            
        #Getting the root value to traverse & create TreeNode
            rootVal = preorder[preStart]
            root = TreeNode(rootVal)

        #Index of rootValue to slice the left & right of subtree
            rootIndex = inorderMap[rootVal]

        #Recursive call left & right in the Tree
            root.left = helper(preStart + 1, start, rootIndex - 1)
            root.right = helper(preStart + rootIndex - start + 1,rootIndex +1, end)
            return root
        
        return helper(preorder, 0, len(inorder) -1)   






        





        

        