#tc = O(n)
#sc = O(h)



class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def inorder(root):
            if root == None:
                return
            inorder(root.left)

            nonlocal flag
            nonlocal prev
            if (prev != None) and (prev.val >= root.val):
                flag = False
            prev = root
            if flag:
                inorder(root.right)
                
        flag = True
        prev = None
        inorder(root)
        return flag