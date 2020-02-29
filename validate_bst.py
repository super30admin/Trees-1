using min-max method :

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach



class Solution(object):
    def BST(self,root,maxi,mini):
        if root==None:
            return True
        if root.val>=maxi or root.val<=mini:
            return False
        return self.BST(root.left,root.val,mini) and self.BST(root.right,maxi,root.val)
        
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        maxi=float('inf')
        mini=float('-inf')
        return self.BST(root,maxi,mini)

using stack:

// Time Complexity : O(n)
// Space Complexity : O(h) height of the tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None but trying to do using stack is complex when compared to queue.


// Your code here along with comments explaining your approach
we used BFS traversal and traversed to the leaf node and then we check with the root if the root element  is greater than the left traversal element then we traverse to the right to check the same.In this way we traverse to the end of the tree if it is vaid BST.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        prev=float('-inf')
        if root==None:
            return True
        stack=[]
        while len(stack)!=0 or root!=None:
            while root!=None:
                stack.append(root)
                root=root.left
            root=stack.pop()
            if root.val<=prev:
                return False
            prev=root.val
            root=root.right
        return True


using queue:
// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
we used a BFS approach and used the bounds from the previous element to check  the bounds of the current element.If every element is within the given bounds then we get True else False.


from collections import deque
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root==None:
            return True
        maxi=float('inf')
        mini=float('-inf')
        d=deque([[root,mini,maxi]])
        while len(d)!=0:
            s=d.popleft()
            if s[0].val>=s[2] or s[0].val<=s[1]:
                return False
            if s[0].left!=None:
                d.append([s[0].left,s[1],s[0].val])
            if s[0].right!=None:
                d.append([s[0].right,s[0].val,s[2]])
        return True
