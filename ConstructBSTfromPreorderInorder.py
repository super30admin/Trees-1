
# Brute Force DFS soltuion
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        
        if len(inorder) == 0 or len(preorder) == 0 or preorder == None:
            return
        
        root_val = preorder[0]
        root = TreeNode(root_val)
        
        for i in range(len(inorder)):
            if inorder[i] == root_val:
                root_index = i
                break
        
        
        inorder_left = inorder[0: root_index + 1]
        inorder_right = inorder[root_index + 1:]
        
        preorder_left = preorder[1: root_index + 1]
        preorder_right = preorder[root_index + 1:]
        

        
        root.left = self.buildTree(preorder_left, inorder_left)
        root.right = self.buildTree(preorder_right, inorder_right)
        
        return root
    
    # Time Complexity: O(n^2) for every n call copying n elements to a list is n^2
    # Space Complexity: O(n^2) for n nodes n arrays will be created
 
# Time and Space efficient solutio using hashmap       
class Solution:
    index = 0
    hashmap = {}
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # using hashmap to store the index for inorder so saving the space here

        for i in range(len(inorder)):
            self.hashmap[inorder[i]] = i

        return self.helper(preorder, inorder, 0, len(inorder) - 1)

    def helper(self, preorder, inorder, left, right):
        
        # using two pointers left and right to keep track of left tree and the right tree
        if left > right: # Base condition
            return
        
        root = TreeNode(preorder[self.index])
        root_index = self.hashmap[preorder[self.index]]
        self.index += 1
        
        root.left = self.helper(preorder, inorder, left, root_index - 1)
        root.right = self.helper(preorder, inorder, root_index + 1, right)
        
        
        return root
  
# Time Complexity: O(n) because we are not using extra array to copy n nodes everytime
# Space Complexity: O(n) because we are not using extra array at each node for space