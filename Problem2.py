#Construct Binary Tree from Preorder and Inorder Traversal

# Time complexity -> 2(O(n)) -> On as it traverse through each element twice
# Space complexity -> O(h) -> The stack space of the depth

# Logic -> Use inorder array to find left and subtrees while preorder tree provides the current node

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    rootIndex = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        InorderIndexmap = {}
        self.rootIndex=0
        for i in range(0,len(inorder)):
            InorderIndexmap[inorder[i]] = i
        
        return self.helper(InorderIndexmap,preorder,0,len(preorder)-1)

    

    def helper(self, InorderIndexmap, preorder, leftIndex, rightIndex):
        if leftIndex > rightIndex:
            return None
        rootval = preorder[self.rootIndex]
        self.rootIndex+=1
        rootNode =  TreeNode(rootval)
        rootIndexInInOrder = InorderIndexmap[rootval]
        rootNode.left = self.helper(InorderIndexmap,preorder,leftIndex,rootIndexInInOrder-1)

        rootNode.right = self.helper(InorderIndexmap,preorder,rootIndexInInOrder+1,rightIndex)

        return rootNode