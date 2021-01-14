# Approach: To build the tree we are given the preorder and inorder traversal 
# Since pre order is root --> left ---> right, we can get root from index 0
# Using this root, find the index of the root value appearing in inorder 
# With this we can obtain the left and right subtrees

# Time Complexity: O(N ^ 2) since we are performing the recursive calls on N elements N times
# Space Complexity is also O(N^2)


def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:

    if len(preorder) == 0:
        return None

    root_val = preorder[0]
    
    # with value form the root node
    root = TreeNode(root_val)

    root_idx = inorder.index(root_val) # Index of root in Inorder , this takes place in O(N) time looping through list to find the index

    inLeft = inorder[0 : root_idx + 1]
    inRight = inorder[root_idx + 1 : len(inorder)]
    
    preLeft = preorder[1 : root_idx + 1]
    preRight = preorder[root_idx + 1 : len(preorder)]

    root.left = self.buildTree(preLeft, inLeft)
    root.right = self. buildTree(preRight, inRight)

    return root



# Optimized Solution
# Instead of having an array we can look up the values from a map instead
# Time Complexity: O(N) since for finding the root we only use map with constant lookups 
# Space Complexity: O(N) # aux map space + O(N) recursive calls made ~~ O(2N) ie O(N)

class Solution:

    idx = 0
    hashmap = {}

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:

        if len(preorder) == 0:
            return None

        for idx, val in enumerate(inorder): # unique values are only given to us
            hashmap[val] = idx

        return self.helper(preorder, inorder, 0, len(inorder) - 1)

    def helper(self, preorder, inorder, startIdx, endIdx):

        # base case
        if (startIdx > endIdx):
            return None

        # logic

        root_val = preorder[self.idx]
        root = TreeNode(root_val)

        self.index += 1 # to get the next root
        root_idx = self.hashmap[root_val]

        root.left = self.helper(preorder, inorder, start, root_idx - 1) 
        root.right = self.helper(preorder, inorder, root_idx + 1, endIdx)

        return root

