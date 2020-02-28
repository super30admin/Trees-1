'''

Solution:
1.  The main idea is that the first element in preorder would be the root and so find that element's location in inorder
    array. Later, the subarray before this index and subarray after this index are sub trees with inorder ordering.
2.  Use either recursion or a stack (DFS) approach to build the subtrees recursively or iteratively.
3.  Return the main root node which was initialized in the beginning.

--- All Testcases successfully passed on Leetcode for both Recursive and Iterative Approaches.

Time Complexity:    Recursive -- O(n) and Iterative -- O(n)
Space Complexity:   Recursive -- O(n) and Iterative -- O(n)

'''

from collections import deque

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class BuildTreeInPre_Recursive(object):

    def __init__(self):
        # initialize these globally so that they won't be repeated
        self.preorder = []
        self.inorder = []
        self.indices = {}
        self.index = 0

    def __buildTree(self, inS, inE):
        # base case -- only variables which change throughout recursion are start and end pointers in inorder subarrays
        if (inS > inE):
            return None

        # main computation before calling recursion
        inIdx = self.indices[self.preorder[self.index]]
        currentRoot = TreeNode(self.preorder[self.index])

        self.index += 1                                         # increment index of preorder before calling recursion
        currentRoot.left = self.__buildTree(inS, inIdx - 1)     # recursion on left subarray first
        currentRoot.right = self.__buildTree(inIdx + 1, inE)    # recursion on right subarray next

        return currentRoot                                      # return main tree node

    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        # edge case check
        if (preorder == None or len(preorder) == 0):
            return None

        # store a HashMap along with given arrays as global variables or attributes of the current class
        self.preorder = preorder
        self.inorder = inorder

        for i in range(len(self.inorder)):
            self.indices[self.inorder[i]] = i

        # call helper function
        return self.__buildTree(0, len(self.inorder) - 1)


class BuildTreeInPre_Stack(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        # edge case check
        if (preorder == None or len(preorder) == 0):
            return None

        # store a HashMap containing indices of elements in inorder
        preorder = preorder
        inorder = inorder

        # initialize the stack
        # each element in stack contain -- node, count (0, 1, or 2 to check whether its children has been traversed or not),
        #                                  minimum index in inorder array, maximum index in inorder array
        indices = {}
        for i in range(len(inorder)):
            indices[inorder[i]] = i

        rootNode = TreeNode(preorder[0])
        stack = deque([[rootNode, 0, 0, len(preorder) - 1]])
        index = 1                       # appropriate location of main index in preorder to start with

        while (len(stack) > 0):
            top = stack[-1]             # top element in the stack
            topNode = top[0]
            topCount = top[1]
            topMin = top[2]
            topMax = top[3]

            if topCount == 0:           # if none of the children is visted => count is 0
                stack[-1][1] += 1
                if (index >= 0 and index < len(preorder)):      #   edge case check for node creation
                    if (topMin > indices[topNode.val] - 1):     #   push new node only if the condition satisifies
                        continue
                    topNode.left = TreeNode(preorder[index])    #   attach new node to the left
                    stack.append([topNode.left, 0, topMin, indices[topNode.val] - 1])
                index += 1                                      # increase index by 1 of preorder index

            elif topCount == 1:        # if one of the children is visted => count is 1
                stack[-1][1] += 1
                if (index >= 0 and index < len(preorder)):      #   edge case check for node creation
                    if (topMax < indices[topNode.val] + 1):     #   push new node only if the condition satisifies
                        continue
                    topNode.right = TreeNode(preorder[index])   #   attach new node to the right
                    stack.append([topNode.right, 0, indices[topNode.val] + 1, topMax])
                index += 1                                      # increase index by 1 of preorder index

            elif topCount == 2:         # if both of the children is visted => count is 2 => just pop the element
                stack.pop()

        return rootNode