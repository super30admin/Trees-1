'''
Time Complexity : O(n)
Space Complexity: O(n)


'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        # inorder L root Right
        # postorder L right Root
        # preorder Root Left Right
        
        # Need to see solution to understand
        
        # root will be first of preorder
        inord = {}
        for k,v in enumerate(inorder):
            inord[v] = k
        preord = deque(preorder)
        i=0
        def build(preorder,start,end):
            
            if(start>=end):
                return
            # root
            
            # can perform popleft or use a variable i in global scope
            #root_val = preorder.popleft()
            
            nonlocal i
            root_val = preorder[i]
            root = TreeNode(root_val)
            subtree_ind  = inord[root_val]
            i+=1
            # left subtree
            root.left = build(preorder,start, subtree_ind)
            # right subtree
            root.right = build(preorder,subtree_ind+1, end)
            
            return root
        return build(preord, 0, len(preord))
