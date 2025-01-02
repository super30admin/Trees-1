#Problem 1
#Time complexity: O(n)
#Space complexity: O(n)

class Solution:
    prev = None
    flag = True 
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inorder(root)
        return self.flag
    def inorder(self, root: Optional[TreeNode]):
        if root==None: return
        if(self.flag):
            self.inorder(root.left)
        if (self.prev!=None and self.prev.val >= root.val):
            self.flag = False
        self.prev = root
        if(self.flag):
            self.inorder(root.right)    

#problem 2
#Time complexity: O(n)
#Space complexity: O(1)

# inorder: left root right - will give you sense of left and right subtree
# predorder: root left right - will give you root

# Brute force (Time/Spce is O(n^2))
# maintain 4 lists inLeft, preLeft, inRight, preRight and recurse
# if preorder is None or len(preorder)==0: return None
#         rootVal = preorder[0]
#         root = TreeNode(val=rootVal)
#         rootIdx = -1
#         for i in range(len(inorder)):
#             if inorder[i] == rootVal:
#                 rootIdx = i
#         inLeft = inorder[0:rootIdx]
#         inRight = inorder[rootIdx+1:len(inorder)]
#         preLeft = preorder[1:len(inLeft)+1]
#         preRight = preorder[len(inLeft)+1:len(preorder)]
#         root.left = self.buildTree(preLeft, inLeft)
#         root.right = self.buildTree(preRight, inRight)
#         return root

# optimized
# make hashmap of inorder, two pointers on inorder(get start and end of subtree) and one pointer on preorder(main reference list)

class Solution:
    Idx = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        hashmap = {}
        for i in range(len(inorder)):
            hashmap[inorder[i]] = i
        #rootIdx => preorder
        def helper(in_start, in_end):
            if in_start > in_end: return None
            rootVal = preorder[self.Idx]
            rootIdx = hashmap[rootVal]
            self.Idx+=1
            root = TreeNode(rootVal)
            root.left = helper(in_start, rootIdx -1)
            root.right = helper(rootIdx + 1, in_end)
            return root

        return helper(0, len(inorder)-1)

        
