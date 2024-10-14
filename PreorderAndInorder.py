# Time Complexity : O(n), where n is the number of nodes in the tree. The hashmap allows O(1) time for finding the index of the root in the inorder list, and each node is visited once.
# Space Complexity : O(n) for the recursion stack (in the worst case of a skewed tree) and the hashmap, which stores the indices of all elements in the inorder list.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Understanding the traversal of tree

# Your code here along with comments explaining your approach 
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        #Optimized solution using hashmap and a stack under the hood : O(n)
        #hashmap to store the indices of the values from the inorder list for fast lookup
        self.HashMap = dict()
        #tracks the current index in preorder, which helps to find root for current subtree
        self.idx = 0
        #loop goes through the inorder list and stores each element's index in the hashmap
        for i in range(0,len(inorder)):
            self.HashMap[inorder[i]]=i
        #The helper function is called to build the tree, Initially, start is 0 and end is the last index of the inorder list
        return self.helper(preorder,0,len(inorder)-1)
    def helper(self,preorder, start, end):
        #If start is greater than end, it means there are no elements left to process in the current subtree, so the function returns None
        if(start>end):
            return None
        #The current root value is taken from the preorder list at index self.idx
        rootVal=preorder[self.idx]
        #self.idx is incremented to move to next node in preorder list for next recursive call
        self.idx+=1
        #retrieves the index of rootVal from the inorder list
        rootIdx=self.HashMap.get(rootVal)
        #new TreeNode is created with rootVal as its value
        root = TreeNode(rootVal)
        #The values for the left subtree are between start and rootIdx - 1 in the inorder list
        root.left=self.helper(preorder,start,rootIdx-1)
        #The values for the right subtree are between rootIdx + 1 and end in the inorder list
        root.right=self.helper(preorder,rootIdx+1,end)
        return root
        
        #Brute Force : O(n*2)
        # if(len(preorder)==0):
        #     return None
        # rootVal = preorder[0]
        # rootIdx = 0
        # for i in range(len(inorder)):
        #     if(inorder[i] == rootVal):
        #         rootIdx = i
        #         break
        # root = TreeNode(rootVal)
        # inleft = inorder[0:rootIdx]
        # inRight = inorder[rootIdx+1:len(inorder)]
        # preLeft = preorder[1:len(inleft)+1]
        # preRight = preorder[len(inleft)+1:len(preorder)]

        # root.left=self.buildTree(preLeft, inleft)
        # root.right=self.buildTree(preRight, inRight)
        # return root