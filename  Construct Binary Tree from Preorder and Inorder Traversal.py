# Time Complexiy: O(N)
# Space Complexity: O(N)
# Yes, It ran on Leetcode
# Problems: Was not able to solve myself, saw the video for this problem.

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def buildTree(self, preorder, inorder):
        
        def helper(l,r):
            if l>r:
                return None
            root_val = next(pre)
            print(root_val)
            root = TreeNode(root_val)
            ind = Dict[root_val]
            root.left = helper(l,ind-1)
            root.right = helper(ind+1,r)
            return root
        
        Dict = {}
        for i,num in enumerate(inorder):
            Dict[num] = i
        pre = iter(preorder)
        print(Dict)
        
        return helper(0,len(inorder)-1)