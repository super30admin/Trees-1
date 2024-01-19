# Solution

# // Time Complexity : O(N) since we are navigating to each root and its left or right once and create the root
# // Space Complexity : O(N) since we are using recursion, there will be stack used to hold recursive calls. It would be
#                       O(H) but H can be N in worst case. 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : In leetcode, global variables are not getting cleared between test cases
#                                              causing an issue where though code is correct, consecutive test cases fail
#                                              so always refresh global variables within the main solution function/method


# // Your code here along with comments explaining your approach
# Approach is to use preorder array as reference for all the roots to be created. Since preorder will always follow root-left-right
# logic. Then we can create a dictionary for elements of inorder array, telling which element is in which index.
# Now root picked from preorder can be used in dictionary to perform O(1) search and figure out the index of that in inorder array
# Since inorder follows left-root-right logic, elements which are left to the index of root we got just now will be the left
# tree of the root and elements found on the right to the index of root is the right subtree of the root. If we do this recursively
# we will be able build binary tree in preorder fashion(create root first, then recursively go to left tree, then recursively
# got to right tree, creating roots as we go recursively and coming back)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

nodeDict = {}
index = 0

def helper(preorder,start,end):
    global index
    if start>end:
        return None
    
    root = TreeNode(preorder[index])
    rootidx = nodeDict[preorder[index]]
    index += 1

    root.left = helper(preorder,start,rootidx-1)
    root.right = helper(preorder,rootidx+1,end)

    return root

def buildTree(preorder, inorder):
    global nodeDict
    global index
    index = 0
    nodeDict = {}

    for i in range(len(inorder)):
        nodeDict[inorder[i]] = i

    
    return helper(preorder,0,len(inorder)-1)

if __name__ == "__main__":
    preorder = [3,9,20,15,7]
    inorder = [9,3,15,20,7]
    root = buildTree(preorder,inorder)
    print(root)