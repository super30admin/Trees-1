# Time Complexity : It is O(n) since we are iterating with all nodes.
# Space Complexity : It is O(h) considering the height of the tree in the stack.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

class Solution:
    isTreeValid = True
    prevNode = TreeNode
    prevNodeVal = 0
    def isValidBST(self, root: Optional[TreeNode]) -> bool:  
        Solution.isTreeValid =True  
        Solution.prevNodeVal =  -math.inf  
        self.recursiveBST(root)
        return Solution.isTreeValid

    def recursiveBST(self, root: [TreeNode]):        
        #base
        if(root == None):
             return
       
        print(root.val)
        self.recursiveBST(root.left)   

        Solution.prevNodeVal=root.val   

        self.recursiveBST(root.right)
        
