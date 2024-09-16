# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Problem 1: validate binary search tree
#Time Complexity: O(N), Master Theorem
#Space Complexity: O(1) (if we don't consider call stack), O(log(n)) recursive call stack
#Did it work on leetcode: Yes
'''
Brute force: We iterate through each node from the bottom, and for each node we check all the children and
see if they are valid.
'''

'''
Main idea: We keep a max and min for each call, if we go to the left, the maximum changes
to whatever that node was (since everything below need to be smaller than that number). if we go
to the right, we change the minimum to whatever that node was (since everything below needs to be bigger).
We then call recursively , while keeping track of min and max for each call. If we encounter any
invalid ones, meaning it's outside [min,max], we return false, else at the end of all the traversal, we return True.
'''
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        def helper(root,mini,maxi):
            if not root:
                return True
            if mini<root.val<maxi:
                return helper(root.left,mini,root.val) and helper(root.right,root.val,maxi)
            else:
                return False
        return helper(root,float("-inf"),float("inf"))




#time complexity O(n), Master Theorem
#space complexty O(logn) for call stack
# Worked on leetcode? : Yes

'''
This one will be a bit tricky to explain.
We know that the first element of preorder is the root. We know that the second element of preorder
should also be the root of the left subtree, etc until there aren't any left subtrees remaining
then we go up until we can go right, and we repeat this process (and we repeat this process).
So left left left left... none remaining, go up, right, left,left,left , none remaining, go up , right.
Recursively,  it would be something like this. We recur until we can't go down left anymore, then
the next call is the latest root.right call (so the closest node which we can go right).

def printPreorder(root):

    if root:

        # First print the data of node
        print(root.val),

        # Then recur on left child
        printPreorder(root.left)

        # Finally recur on right child
        printPreorder(root.right)

Now, this would be all what we woud need if we knew what are the length of the subtrees. How do we know from the preorder list
when we stop going left, when we stop going right? Comes in the inorder traversal. The inorder list is constructed such that
given a node value, everything on it's left in the inorder traversal are in the left subtree, of this node, and everything on
the right are in the right subtree.

So now that we have this information, it's easy, we know that when there's nothing else on the left (inorder list) of a node value that we are at , it means we are done going left, same thing for right. Now we just need a hashmap for fast lookup for the indices-value pair for fast lookup. We call recursively a function with arguments the min and max indices in the inorder list that represents
our present subtree (i.e [0,first_value],[first_value+1,len(inorder)] for the first iteration). If the size of the subtree
is 0, we return None, else we construct the root.left, root.right trees recursively and updating the indices accordingly
(left part of inorder is left subtree, right part is right subtree). We pop the preorder values each time.

'''
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder:
            return None
        #to know where to divide in the inorder list
        h={value:i for i,value in enumerate(inorder)}
        present_pre_idx=0
        def helper(left,right):
            if (right-left)==0:
                # it means there are no values in that subtree
                return None
            #crucial to have it non-local
            nonlocal present_pre_idx

            #the value for the present root
            present_preorder=preorder[present_pre_idx]
            root=TreeNode(present_preorder)
            #from this value, we know how to split left subtree, and right subtree
            #by spliting the inorder list
            to_split=h[present_preorder]

            #Now the we've used it, direct next one will be use on left
            # the one use on right will be after recusion on left will be done
            # by thenm present_pre_idx will be much more
            present_pre_idx+=1

            #left side of to_split is left tree
            root.left=helper(left,to_split)

            #right side of to split is right tree
            root.right=helper(to_split+1,right)

            return root
        return helper(0,len(inorder))
