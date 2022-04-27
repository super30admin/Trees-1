#Valid BST
# // Time Complexity : O(N)
# // Space Complexity : O(H) H-height of the tree
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



def isValidBST( root):
    if(root==None): return True
    return helper(root, float('-inf'), float('inf'))
    
def helper(root, mini, maxi):
    if (root==None):
        return True
    if( root.val <= mini): return False                     #if the current root's value is less than the minimum value the tree can have, then return false
    if( root.val >=maxi):return False                           #if the current root's value is more than the minimum value the tree can have, then return false
    return  helper(root.left, mini, root.val) and helper(root.right, root.val, maxi)            #if you go to the left, update max, if you go to the right, update min
        

