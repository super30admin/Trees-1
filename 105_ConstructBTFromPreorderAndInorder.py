# time complexity : O(n)
# space complexity: O(n)



# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right





class Solution:
    def __init__(self) -> None:
        self.idx = 0   # index in preorder for hashmap solution
        self.hashmapInorder = dict()  # create hashmap for hashmap solution

# Recursive Solution ------->
# time complexity : O(n^2) --> iterates over inorder to find root
# space complexity: O(n^2) --> at each node creating copy of array
# set first element of PreOrder to the root
# find that element in Inorder
# in Inorder, set the left of root to the left elements of the tree 
# find index of the root in Inorder = idxRoot
# in PreOrder, set elements from index 1 to idx(idxRoot) to left elements of the tree and rest of are right elements
    def buildTree(self, preorder, inorder):
        if len(preorder) == 0:
            return None
        
        rootVal = preorder[0]
        rootIdx = -1  # idx of root in inorder
        n = len(inorder)
        
        # iterates over inorder and find root, set it index to rooIdx
        for i in range(0,n + 1):
            if inorder[i-1] == rootVal:
                rootIdx = i-1
                
        # make new list for right elements and left elements from inorder and postorder list
        inLeft = inorder[0:rootIdx]
        preLeft = preorder[1:rootIdx+1]
        inRight = inorder[rootIdx+1:]
        preRight = preorder[rootIdx+1:]
        
        root = TreeNode(rootVal)
        root.left = self.buildTree(preLeft, inLeft)
        root.right  = self.buildTree(preRight, inRight)
        return root


    


# Using Hashmap instead to itrates ove inorder and find a root --->
# time complexity : O(n)
# space complexity: O(n)
    def buildTree1(self, preorder, inorder):
        if len(preorder) == 0:
            return None
        
        n = len(inorder)
        for i in range(0,n+1):
            self.hashmapInorder[inorder[i-1]] = i-1
        return self.helper(preorder,0,n-1)

    def helper(self, preorder, start, end, ):
        if start > end:
            return None
        
        rootVal = preorder[self.idx]
        root = TreeNode(rootVal)
        self.idx = self.idx +1
        rootIdx = self.hashmapInorder[rootVal]  # idx of root in inorder
        root.left = self.helper(preorder, start, rootIdx - 1)
        root.right = self.helper(preorder, rootIdx + 1, end)
        return root

obj = Solution()
print(obj.buildTree([3,9,20,15,7],[9,3,15,20,7]))
print(obj.buildTree1([3,9,20,15,7],[9,3,15,20,7]))