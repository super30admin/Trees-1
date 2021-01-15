
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Recursion: extra arrays and traversing inorder to find idx
# TC = O(n2)
# SC = O(n2)
# Preorder first element gives the root of binary tree. We use pre order to find root at each instant, while using inorder elements to mark sub trees. Here we are creating new arrays to represent sub trees after each root selection.  
class Solution1:
    def buildTree(self, preorder, inorder):
        if len(preorder) == 0: return None
        rootValue = preorder[0]
        root = TreeNode(rootValue)
        idx = -1
        for i in range(len(inorder)):
            if rootValue == inorder[i]:
                idx = i
        root.left = self.buildTree(preorder[1:idx+1], inorder[:idx])
        root.right = self.buildTree(preorder[idx+1:len(preorder)], inorder[idx+1:len(inorder)])
        return root

# Recursion: using hashmap to store inorder indices
# TC = O(n)
# SC = O(n)
# We follow the same process as above while maintaining inorder indices in a hashmap making it easy to access pivot index each time saving time n space.
class Solution2:
    hashmap = {}
    idx = 0
    def buildTree(self, preorder, inorder):
        if len(preorder) == 0: return None
        for i in range(len(inorder)):
            self.hashmap[inorder[i]] = i
        return self.helper(preorder, 0, len(inorder)-1)
    # pre order for fragmenting at each call and start n end indices of inorder each time.
    def helper(self, pre, start, end):
        # base
        if start > end: return None    
        # logic
        rootValue = pre[self.idx]
        root = TreeNode(rootValue)
        self.idx += 1
        rIdx = self.hashmap[rootValue] 
        root.left = self.helper(pre, start, rIdx-1)
        root.right = self.helper(pre, rIdx+1, end)
        return root


preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
obj = Solution1()
print(obj.buildTree(preorder, inorder))


