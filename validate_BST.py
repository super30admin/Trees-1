# Time complexity: O(n)
# Space Complexity: O(n)
# Approach: do inorder traversal
# while traversing, if prev is greater than the current value, make it false.



class Solution:
    global prev
    global validtree
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        global prev
        global validtree
        prev = TreeNode()
        prev = None
        validtree = True
        self.inorder(root)
        return validtree
        
    def inorder(self, root):
        global prev
        global validtree
        if root == None:
            return
        self.inorder(root.left)
        if(prev != None and prev.val >= root.val):
            validtree = False
        prev = root   
        self.inorder(root.right)