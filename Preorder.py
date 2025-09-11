# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Tc : O(n) travel through each node 
# sc : O(n+h)-> O(n)
# ran successfully on leetcode
class Preorder(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: Optional[TreeNode]
        """
        # intution
        # preorder = root left right always root first, inorder = left root right
        # taking a bigger testcase : inorder = [4,2,5,1,6,3] and preorder = [1,2,4,5,3,6], 1 is the root of the tree 
        # [4,2,5]-> left subtree [1]-> root [6,3]-> right subtree, recrusive approach the final tree is [[4]->2->[5]] -> 1->[[6]->3] 
      
        # approach
        # find the root index : preorder start index is the root but we have to find where in the order this index is : for that will be using a hashmap to store the 
        # value and ints index, creating the hashmap as the search to find the index of the root is O(1), ifnot i need to iteratre the array every time to find the root value in the recurssion
        # also given the inorder, preorder consist of unique values, so not an issue of duplicates here. 

        hash_map = {val: idx for idx, val in enumerate(inorder)} # sc : O(n)

        root = self.helper(preorder, 0, len(preorder)-1, inorder, 0, len(inorder)-1, hash_map)
        return root

    # indexes for the left and right subtree
    # using two pointers prestart at 0, preend at the end of the list for preorder and instart at 0, inend at the end of the list for the inorder 
    # left subtree = instart to the rootinex-1, right subtree = instart + leftsubtree +1 to end of the list in inorder
    # In preorder prestart +1 as the first index is root we iterate to next, till the leftsubtree size found in the inorder 
    # we then compare these two left arrays to again recrussively find the root and so Optional
    # right subtree  = prestart+ left_subtreesize +1( this 1 for root) gives the start index of the right subtree, end is  till end 
    # in inorder , rightsubtree starts = rootndex + 1 till end 
   
    # helper function
    def helper(self, preorder,prestart, preend, inorder, instart, inend, hashmap): # recrussive stack takes O(h)
        # base 
        # whenever the start index cross end index we return None
        if prestart > preend or instart > inend:
            return None

        # root is the first element in the preorder
        root = TreeNode(preorder[prestart])

        root_index = hashmap[root.val]

        # left subtree size
        lf_size = root_index - instart

        root.left = self.helper(preorder, prestart+1, prestart+lf_size, inorder,instart, root_index-1, hashmap)

        root.right = self.helper(preorder,prestart+lf_size+1, preend, inorder,root_index+1, inend, hashmap)

        return root




        
    
    




