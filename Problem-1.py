# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def inorder(self,root,arr):
        if not root:
            return 
        self.inorder(root.left,arr)
        arr.append(root.val)
        self.inorder(root.right,arr)
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        arr = []
        #iterate in order and save to array
        self.inorder(root,arr)
        # check if increasing order for all inputs if not return false else return true
        for i in range(1,len(arr)):
            if arr[i-1]>=arr[i]:
                return False
        return True