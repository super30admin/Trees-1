class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder: return None
        root = TreeNode(preorder[0])
        rootIndex = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1:rootIndex + 1], inorder[:rootIndex])
        root.right = self.buildTree(preorder[rootIndex+1:], inorder[rootIndex+1:])
        return root
    
    
#T.C => O(h)
#S.C => O(n) => Since we using recursion and stack
#Approach => Check the first element of preorder which is always root, then search the same elemnt in inorder and that will partion the array in two size one as left and right. the left value are for the left subtree and right values are for right subtree.

# we have to recurse this continuously to form a tree. 
        