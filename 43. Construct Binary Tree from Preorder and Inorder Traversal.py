# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def __init__(self):
            self.index = 0
            self.hashmap = {}
        
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder is None: return None
        self.hashmap = {}
        for i in range(len(inorder)):
            self.hashmap[inorder[i]] = i
        return self.helper(preorder, 0, len(inorder)-1)
        
    def helper(self, preorder, start, end):
        if start>end: return None
        
        rootval = preorder[self.index]
        rootindex = self.hashmap.get(rootval)
        self.index += 1
        root = TreeNode(rootval)
        root.left = self.helper(preorder, start,  rootindex- 1)
        root.right = self.helper(preorder, rootindex + 1, end)
        
        return root


# class Solution:
#     def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
#         if preorder is None: return None
#         hashmap = dict()
#         for index, val in enumerate(inorder):
#             hashmap[val] = index
#         return self.helper(preorder, 0, len(preorder)-1, inorder, 0, len(inorder)-1, hashmap)
        
#     def helper(self, preorder, prestart, preend, inorder, instart, inend, hashmap):
#         if prestart>preend and instart>inend: return None
        
#         rootval = preorder[prestart]
#         rootindex = hashmap.get(rootval)
#         num_left = rootindex-instart
#         root = TreeNode(rootval)
#         root.left = self.helper(preorder, prestart+1, prestart+num_left, inorder, instart, rootindex-1, hashmap)
#         root.right = self.helper(preorder, prestart+num_left+1, preend, inorder, rootindex+1, inend, hashmap)
        
        
#         return root