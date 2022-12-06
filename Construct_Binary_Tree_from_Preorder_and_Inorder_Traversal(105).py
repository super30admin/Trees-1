# Time Complexity: O(N)
# Space Complexity: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Here we use the fact that the first element in the preorder is the root element followed by its left and right
# children(next roots)
# we find the root in the inorder and the left to it is the left subtree and right is the right subtree

class Solution:
    def __init__(self):
        #here we would need to look for the element in the inorder everytime
        # so we instead use a hashmap with element as key and index as value
        self.map = dict()
        self.idx = 0

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder==None or inorder==None or len(preorder)!=len(inorder):
            return None
        for i in range(len(inorder)):
            self.map[inorder[i]] = i
        return self.recurse(preorder,inorder,0,len(inorder)-1)

    def recurse(self,preorder,inorder,start,end):
        #base case
        if start>end:
            return None
        #logic
        rootVal = preorder[self.idx]
        self.idx+=1
        root = TreeNode(rootVal) #at each iteration we take the root in preorder and create a node
        rootIdx = self.map[rootVal]

        # the right subtree would be from start till rootindex
        root.left = self.recurse(preorder,inorder,start,rootIdx-1)
        # the left subtree would be from rootindex till end
        root.right = self.recurse(preorder,inorder,rootIdx+1,end)

        return root