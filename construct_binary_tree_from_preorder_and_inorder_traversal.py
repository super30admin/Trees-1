'''
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I don't fully get it

Approach: hashmap and recursion
TC: O(N), SC: O(N)
'''
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def array_to_tree(left, right):
            nonlocal preorder_index
            
            #left more than right means there's no element to construct the tree
            if left > right: return None

            #create root and increment preorder index
            root_val = preorder[preorder_index]
            root = TreeNode(root_val)
            preorder_index += 1

            #create left and right subtree using recursion
            root.left = array_to_tree(left, hashmap[root_val] - 1)
            root.right = array_to_tree(hashmap[root_val] + 1, right)
            
            return root
            
        preorder_index = 0
        
        # build a hashmap to store value 
        hashmap = {}
        for i, value in enumerate(inorder):
            hashmap[value] = i
            
        return array_to_tree(0, len(preorder) - 1)