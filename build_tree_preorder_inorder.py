# Definition for a binary tree node.

# SC : O(n)
# TC : O(nlogn)
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

 
    
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        hashmap = dict()
        
        for i in range(len(inorder)):
            hashmap[inorder[i]] = i
            
        self.preIndex = 0
        
        def buildTreeHelper(inorder, preorder, instart, inend, hashmap):
            if instart > inend:
                return None
            # create new node from global preorder index
            curr = preorder[self.preIndex]
            self.preIndex += 1
            currNode = TreeNode(curr)
            
            if inend == instart: # no children 
                return currNode
            
            inindex = hashmap[curr]
            
            currNode.left = buildTreeHelper( inorder, preorder, instart, inindex -1 , hashmap)
            currNode.right = buildTreeHelper( inorder, preorder, inindex + 1, inend , hashmap)
            return currNode 
                
            
            
        return buildTreeHelper(inorder, preorder, 0, len(inorder)-1, hashmap ) 