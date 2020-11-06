"""
The approach here is to find the root node in the preorder array. which is in the first index. now set
that value to root. and set the root = index and search for the root in the inorder. now the root will
be present in the middle between the left and the right nodes of the main-tree in the inorder array.
now create new inorder and preorder sub-aarrays for each left and right sub-tree. this can be formed by
passing the parameters mentioned. and in the new preorder and inorder arrays find root. and create new
sub-arrays for preoder and inorder. keep on doing this recursively until we at the end of each sub-tree.

Time complexity = O(N)
space complexity = O(1)
Leetcode - running
"""

def buildTree(inorder,preorder):
    def buildTree(self,preorder,inorder):
        if not inorder or not preorder:
            return None
        root = TreeNode(preorder[0])
        index = -1
        for i in range(len(inorder)):
            if inorder[i] == root.val:
                index = i
    
        NewPreorderLeft = preorder[1:index+1]
        NewInorderLeft = inorder[0:index]
        NewPreorderRight = preorder[index+1:len(preorder)]
        NewInorderRight = inorder[index+1:len(inorder)]

        root.right = self.buildTree(NewPreorderRight,NewInorderRight)
        root.left = self.buildTree(NewPreorderLeft,NewInorderLeft)

        return root