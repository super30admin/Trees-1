# Time: O(n^2) 
# Space: O(n^2)

# From preorder traversal we will know the root
# Then we will check in inorder traversal how many elements are there on the left of the root and how many are there on the right of the root
# We can mark the left elements and right elements on the preorder Then again in the left part we will check who is the root
# Then again check where is that element in the inorder traversal and see if how many elements we have on left and right again
# After there is no element in left recursive call start with right recursive call

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        return self.helper(preorder,inorder)
    def helper(self,preorder,inorder):
        # base
        if len(preorder) == 0:
            return None

        # logic
        # Getting the root value
        rootVal = preorder[0]
        rootIdx = 0
        root = TreeNode(rootVal)
        # Find where the root is in inorder array
        for i in range(len(inorder)):
            if inorder[i] == rootVal:
                rootIdx = i
                break

        # Differentiate elements on the right and on the left of the root
        in_left = inorder[:rootIdx]
        in_right = inorder[rootIdx + 1:] 

        # Getting pre-order array corresponding to the in_left and in_right because according to our logic preorder[0] is the root element
        pre_left = preorder[1:1 + len(in_left)]
        pre_right = preorder[1 + len(in_left):]

        root.left = self.helper(pre_left,in_left)
        root.right = self.helper(pre_right,in_right)

        return root
    

# OPTIMISED SOLUTION

# Time: O(n)
# Space: O(n)

# eliminating search with hashmap which becomes O(1) and the deep copy with pointers
# Add all the inorder elements into a hashmap to have O(1) lookup
# We have a pointer to loop over the preorder array to know what the current root value is. Find that value in the inorder array by looking into the hashmap
# while going to the left traversal the start remains the start of parent and the end changes to rootidx -1
# while going to the right traversal the start becomes rootIdx + 1 and the end changes to the end of parent
# The deep copy that we had earlier is just depicted by these start and end pointer
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # Two pointers at start an end of inorder list
        in_start = 0
        in_end = len(inorder) - 1
    # Everything in the preorder array is a node. That's the whole point of preorder
        # One pointer to pass through elements of preorder that is all the roots
        self.pre_idx = 0
        # Creating a hashmap for O(1) search in inorder list
        map_inorder = {}
        for i in range(len(inorder)):
            # It's indexes as values because we need to find the indexes and search through the values
            map_inorder[inorder[i]] = i

        return self.helper(preorder,map_inorder,in_start,in_end,self.pre_idx)
    def helper(self,preorder,map_inorder,in_start,in_end,pre_idx):
        # Base case
        if in_start > in_end:
            return
        
        # Create the node using the value in preorder list
        root_val = preorder[self.pre_idx]
        root = TreeNode(root_val)

        # When you find the root_idx in inorder
        root_idx = map_inorder.get(root_val)
        self.pre_idx += 1

        # While traversing left side start remains Papa's start and end changes to idx - 1
        root.left = self.helper(preorder,map_inorder,in_start,root_idx-1,self.pre_idx)
        # While traversing right side start changes to idx + 1 and end remains Papa's end
        root.right = self.helper(preorder,map_inorder,root_idx + 1,in_end,self.pre_idx)

        return root 