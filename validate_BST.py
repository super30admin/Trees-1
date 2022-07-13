# Time complexity: O(n)
# Space Complexity: O(n)
# Approach: do inorder traversal and put it in a list
# Check if the list is in ascending order. return true if yes, else false



class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        treelist = []
        treelist = self.inorder(root,treelist)
        for i in range(len(treelist)):
            if i ==0 or treelist[i] > treelist[i-1]:
                continue
            else:
                return False
        return True
        
    def inorder(self, root,treelist):
        if root == None:
            return
        self.inorder(root.left,treelist)
        treelist.append(root.val)
        self.inorder(root.right,treelist)
        return treelist