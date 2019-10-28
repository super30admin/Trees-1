#Time Complexity:O(n)
#Space Complexity:O(n)
#leetcode submission: successful
#inorder of a bst will give a array in ascending order

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        output=[]
        self.inorder(root,output)
        for i in range(1,len(output)):
            if output[i-1]>=output[i]:
                return False
        return True
    
    def inorder(self,root,output):
        if root is None:
            return
        self.inorder(root.left,output)
        output.append(root.val)
        self.inorder(root.right,output)
        