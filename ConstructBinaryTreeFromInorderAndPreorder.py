#Time Complexity: O(N)
#Space Complexity: O(N)
#Successfully ran on leetcode

class Solution:
    def __init__(self):
        self.hashMap = {}
        self.idx = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if inorder is None or preorder is None or len(preorder)==0: 
            return None
        for i in range(len(inorder)):
            self.hashMap[inorder[i]]=i
        return self.recurse(inorder,preorder,0,len(inorder)-1)
    def recurse(self,inorder,preorder,start,end):
        if start>end:
            return None
        rootVal = preorder[self.idx]
        self.idx+=1
        root = TreeNode(rootVal)
        rootIdx = self.hashMap[rootVal]
        root.left = self.recurse(inorder,preorder,start,rootIdx-1)
        root.right = self.recurse(inorder,preorder,rootIdx+1,end)
        return root