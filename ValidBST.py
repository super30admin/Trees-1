"""
The approach here to keep two values as boundary ranges -inf and +inf. and keep on traversing through
the tree both in left and right nodes and at every node check if the left node is smaller than the root
i.e it is between the range of -inf to value of root val and the right node is in between the range value
of root node to +inf. and finally when we each the node which does'nt have any children and satisfies
all conditions we start returning true to the above nodes.
Leetcode - running
Time complexity - O(N)
example - [5,1,4,NULL,NULL,3,6]
    5
   / \
  1   4
     / \
    3   6

step 1 - starts from 5 - checks for left node -inf < 1 < 5 - True
step 2 - checks for right node 5 < 4 < inf - False 
returns false
"""

class Node(object):
    def __init__(self,x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def ValidBST(self,root):
        mini = float('-inf')
        maxi = float('inf')
        def helper(root,mini,maxi):

            if root is None:
                return True
        
            if root.left is None and root.right is None:
                return mini < root.val < maxi
        
            if root.val <= mini or root.val >= maxi:
                return False

        return helper(root.left,mini,root.val) and helper(root.right,root.val,maxi)

    return helper(root,mini,maxi)

        



