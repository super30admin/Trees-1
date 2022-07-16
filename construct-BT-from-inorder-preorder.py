"""
Runtime Complexity:
O(n^2) - because the time taken to build a tree with 'n' nodes is O(n), we need to traverse 'n' nodes in order to construct it which takes O(n). Therefore
the overall runtime complexity is O(n^2)
Space Complexity:
O(n^2) - we build the array 'n' times and each array contains 'n' elements.
Yes, the code worked on leetcode.
"""
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder:
            return None
        root = TreeNode(preorder[0])
        index = inorder.index(root.val)
        left_in, right_in = inorder[:index], inorder[index+1:]
        left_pr,right_pr = preorder[1:index+1], preorder[index+1:]
        
        root.left = self.buildTree(left_pr,left_in)
        root.right = self.buildTree(right_pr,right_in)
        
        return root 
        
#Using Hashmap
"""
Runtime Complexity:
O(n) -  constant lookup time because of hashmap and we compute 'n' nodes from the list. So the overall runtime complexity is O(n).
Space Complexity:
O(n) - hashmap to store 'n' elements.
"""
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        hash_map = {}
        for i,num in enumerate(inorder):
            hash_map[num]=i
        index = [0]
        
        def generate(start,end):
            if start>end:
                return None
            idx = preorder[index[0]]
            mid = hash_map[idx]
            index[0]+=1
            
            root = TreeNode(idx)
            root.left = generate(start,mid-1)
            root.right = generate(mid+1,end)
            
            return root
        return generate(0,len(preorder)-1)
        
        