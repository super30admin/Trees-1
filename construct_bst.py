""" Explanation: Since we're given the preorder traversal of the bst, we can assume that the first element of that list will be the root. 
    After getting the root, we can search for that root in the inorder traversal list, and since that list if the inorder traversal, we 
    now know that the elements on the left will be on the left subtree and so on and the ones on the right side of the root will be the
    right subtree and so on. Now in order to search the root in the inorder list, I used a hashmap since search is O(1). The index is the key
    and the node value is the value for the hashmap. We then recursively build the bst using the root and the left and right nodes we got from
    in order traversal.
    Time Complexcity: O(n)
    Space Complexcity: O(n)
    Code passed all cases on LC: Yes
"""


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """

        # getting the root of the bst
        node_map,n = {},len(preorder) # hashmap for storing index of inorder traversal
        self.pre_ind = 0 # current index in preorder traversal

        # storing index in map
        for i in range(n): 
            node_map[inorder[i]] = i
        
        def build(preorder,inorder,start,end,node_map):
            if start > end or len(preorder) == 0:
                return None
            
            node = TreeNode(preorder[self.pre_ind])
            self.pre_ind += 1
            indx = node_map[node.val]
            node.left = build(preorder,inorder,start,indx-1,node_map)
            node.right = build(preorder,inorder,indx+1,end,node_map)

            return node
        
        return build(preorder,inorder,0,n-1,node_map)
