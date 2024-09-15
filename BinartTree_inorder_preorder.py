class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        Hashmap=collections.defaultdict(int)
        index=0
        def helper(self,preorder,inorder,start,end):
            nonlocal index
            if index==len(preorder) or start > end:
                return None
            rootindex=Hashmap.get(preorder[index])
            root=TreeNode(preorder[index])
            
            index+=1
            root.left=helper(self,preorder,inorder,start,rootindex-1)
            root.right=helper(self,preorder,inorder,rootindex+1,end)
            return root
        if len(preorder)==0 or len(inorder)==0:
            return None
        for i in range(len(inorder)):
            Hashmap[inorder[i]]=i
        return helper(self,preorder,inorder,0,len(inorder)-1)
#Time-Complexity: O(N)
#Space-Complexity: O(N)