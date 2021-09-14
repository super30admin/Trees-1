# Time Complexity : O(N) 
# Space Complexity : O(N) worst case and O(logN) on average
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, took me some time to understand the recursive solution


class TreeNode:
    
    def __init__(self, val=0, left = None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        def array_to_tree(left, right):
            nonlocal preorder_index
            
            # if no elements to construct tree
            if left > right:
                return None
            
            # select preorder_index element as root and increment it
            root_value = preorder[preorder_index]
            root = TreeNode(root_value)
            
            preorder_index += 1
            
            # build left and right subtree
            # w/o inorder_index_map[root_value] as that is the root
            root.left = array_to_tree(left, inorder_map[root_value] - 1)
            root.right = array_to_tree(inorder_map[root_value] + 1, right)
            
            return root
        
        preorder_index = 0
        
        # build a hashmap to store value -> index mapping
        inorder_map = {}
        for i, v in enumerate(inorder):
            inorder_map[v] = i
        
        return array_to_tree(0, len(preorder) - 1)