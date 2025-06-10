# TC: O(n)
# SC: O(n)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        hmap={}
        for i,j in enumerate(inorder):
            hmap[j]=i
        idx=0

        def helper(start, end):
            nonlocal idx
            # base
            if start> end:
                return None
            
            #logic
            root_val=preorder[idx]
            idx+=1
            root=TreeNode(root_val)

            ridx=hmap[root_val]

            #left
            root.left=helper(start, ridx-1)
            #right
            root.right=helper(ridx+1, end)

            return root
            
        return helper(0, len(inorder)-1)