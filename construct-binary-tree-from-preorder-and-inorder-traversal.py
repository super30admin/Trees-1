#Time O(n*h)
# Space: O(n)
class Solution:
    preorder_index = 0
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.inorder_map = {}
        for i in range(len(inorder)):
            self.inorder_map[inorder[i]] = i
        
        return self.array_to_bt(preorder, 0, len(preorder)-1)
    
    def array_to_bt(self, preorder: List[int], left_id: int, right_id: int) -> Optional[TreeNode]:
        if left_id > right_id:
            return None
        
        rootVal = preorder[self.preorder_index]
        root = TreeNode(rootVal)
        self.preorder_index += 1
        root.left = self.array_to_bt(preorder, left_id, self.inorder_map[rootVal] - 1)
        root.right = self.array_to_bt(preorder, self.inorder_map[rootVal] + 1, right_id)

        return root

        
        