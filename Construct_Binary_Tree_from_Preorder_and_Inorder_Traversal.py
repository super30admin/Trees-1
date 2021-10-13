# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        root =  TreeNode(preorder[0])
        if len(preorder) == 0 and len(inorder) == 0:
            return []
        
        def TreeBuilder(inorder,preorder):
            if len(inorder) == 0 and len(preorder) == 0:
                return
            temp = TreeNode(preorder[0])
            # temp.left = TreeNode(None)
            # temp.right = TreeNode(None)
            
            ino_left = inorder[:inorder.index(preorder[0])]
            ino_right = inorder[inorder.index(preorder[0])+1:]
            
            pre_left = preorder[1:len(ino_left)+1]
            pre_right = preorder[1+len(ino_left):]
            
            temp.left = TreeBuilder(ino_left,pre_left)
            temp.right = TreeBuilder(ino_right,pre_right)
            
            return temp
            
        ino_left = inorder[:inorder.index(preorder[0])]
        ino_right = inorder[inorder.index(preorder[0])+1:]
        
        pre_left = preorder[1:len(ino_left)+1]
        pre_right = preorder[1+len(ino_left):]
        
        
        root.left = TreeBuilder(ino_left,pre_left)
        root.right = TreeBuilder(ino_right,pre_right)
        
        print(ino_left,preorder[1:len(ino_left)+1])
        print(ino_right,preorder[1+len(ino_left):])
        
        return root
        