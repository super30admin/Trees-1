'''
1. Preorder has the root as the first element in the list. Find the index of the root in the inorder list. 
2. Left of this node -> left subtree, right of this node -> right subtree
3. Recursively build the tree with ranges for the left and right subtree

TC: O(n)
SC: O(h) where h is the height of the tree
'''

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        if preorder == None:
            return None

        # Create a hashmap to store the index of the nodes in the inorder list
        index = {}
        for i,node in enumerate(inorder):
            index[node] = i 

        # Initialize the preorder index
        preorderIndex = 0

        def arrayToTree(left,right):
            
            # Use the preorderIndex from the outer function
            nonlocal preorderIndex

            if left > right:
                return None
            
            root_value = preorder[preorderIndex]
            root = TreeNode(root_value)
            preorderIndex += 1

            root.left = arrayToTree(left,index[root_value]-1)
            root.right = arrayToTree(index[root_value]+1,right)

            return root

        return arrayToTree(0,len(preorder) - 1)
