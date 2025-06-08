# S30 Problem #44 Construct Binary Tree from Preorder and Inorder Traversal
#LeetCode #105 https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

# Author : Akaash Trivedi
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        return self.helper(preorder,inorder)
    
    def helper(self, preorder, inorder) -> TreeNode:
        #base
        if len(preorder) == 0: return None
        #logic
        # 1st element in preorder is root
        rootVal = preorder[0]
        rootIdx = -1
        root = TreeNode(rootVal)
        # find position of root in inorder
        for i in range(len(inorder)):
            print(inorder[i])
            if inorder[i] == rootVal:
                rootIdx = i
                break
        # print("rootidx",rootIdx)

        # create left subtree and right subtree for inorder
        inorderLeft = inorder[0:rootIdx]
        inorderRight = inorder[rootIdx+1:]
        
        # as we get len of left & right subtree from inorder
        # use that to find subtree in preorder
        preorderLeft = preorder[1:1+ len(inorderLeft)]
        preorderRight = preorder[1+ len(inorderLeft):]

        # recurse for sub tree problems
        root.left = self.helper(preorderLeft, inorderLeft)
        root.right = self.helper(preorderRight, inorderRight)
        
        return root

# using hashmap and two pointers
class Solution:
    def __init__(self):
        self.idx = 0 #index for preorder
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inmap = dict()
        for i in range(len(inorder)):
            inmap[inorder[i]] = i
        
        return self.helper(preorder,inmap, 0, len(inorder)-1)

    # start and end are on inorder array
    def helper(self, preorder, inmap, start, end):
        #base
        if start > end: return None
        # intially root is at 0th index and then increment it
        rootVal = preorder[self.idx]
        self.idx+=1
        root = TreeNode(rootVal)
        rootidx = inmap.get(rootVal)

        root.left = self.helper(preorder,inmap,start,rootidx-1)
        root.right = self.helper(preorder,inmap,rootidx+1,end)

        return root