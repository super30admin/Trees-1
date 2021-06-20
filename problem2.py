# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    hashmap = {}
    idx = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:

        for i in range(len(inorder)):
            self.hashmap[inorder[i]] = i
        
        def helper(preorder, start, end):
            #base condition
            if start > end: return None
            
            rootVal = preorder[self.idx]
            root = TreeNode(rootVal)
            
            rootIdx = self.hashmap[preorder[self.idx]]
            self.idx +=1
            #print("before left call", start, end)
            root.left = helper(preorder, start, rootIdx-1)
            #print("before right call",start, end)
            root.right = helper(preorder, rootIdx+1, end)
            print(root)
            return root
            
        
        return helper(preorder, 0, len(inorder)-1)
    
#Space complexity is O(h) and Time Complexity is O(n)
#Recursive appraoch used to find node from Preorder list and comparing it with Inorder list
