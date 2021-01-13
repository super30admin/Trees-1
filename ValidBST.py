'''
Solution:
1.  The main idea is to check whether each node's value is in a particular range or not based on its parents' values.
2.  These can be done recursively or iteratively using a stack (DFS) or a queue (BFS)
3.  Return false if any of the nodes is not in the range otherwise return true.

-- Passed all test cases on Leetcode successfully for all 3 Recursive, Iterative (Stack / Queue) approaches.

Time Complexity:    Recursive -- O(nodes), Iterative (Stack-DFS) -- O(nodes) and Iterative (Queue-BFS)-- O(nodes)
Space Complexity:   Recursive -- O(height), Iterative (Stack-DFS) -- O(height) and Iterative (Queue-BFS)-- O(nodes)

'''


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

from collections import deque


class validBST_Stack(object):

    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        #   edge case check
        if (root == None):
            return True

        # initialize the stack
        # each element in stack contain -- node, minimum value, maximum value, count (0, 1, or 2 to check whether
        #                                   its children has been traversed or not)
        stack = [[root, float('-inf'), float('inf'), 0]]

        while (len(stack) > 0):
            top = stack[-1]

            if (top[3] == 0):                       # if none of the children is visted => count is 0
                stack[-1][3] += 1
                if (top[0].left != None):
                    if (top[0].left.val >= top[1] and top[0].left.val <= top[0].val - 1):       # check if in range
                        stack.append([top[0].left, top[1], top[0].val - 1, 0])      # update max and min values from its parent
                    else:
                        return False
                continue

            elif (top[3] == 1):                     # if one of the children is visted => count is 1
                stack[-1][3] += 1
                if (top[0].right != None):
                    if (top[0].right.val >= top[0].val + 1 and top[0].right.val <= top[2]):     # check if in range
                        stack.append([top[0].right, top[0].val + 1, top[2], 0])     # update max and min values from its parent
                    else:
                        return False
                continue

            elif (top[3] == 2):                     # if both of the children is visted => count is 2, just pop
                stack.pop()

        return True                                 #   return True if all nodes are in appropriate ranges


class validBST_Recursive(object):

    def __isValidBST(self, root, minVal, maxVal):
        #   base case
        if (root == None):
            return True

        if root.val >= minVal and root.val <= maxVal:               # check if in range
            return (self.__isValidBST(root.left, minVal, root.val - 1) and  #   recurse on left by updating the range
                    self.__isValidBST(root.right, root.val + 1, maxVal))    #   recurse on right by updating the range
        return False

    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        #   call helper function
        return self.__isValidBST(root, float('-inf'), float('inf'))


class validBST_Queue(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        #   edge case check
        if (root == None):
            return True

        # initialize the queue
        # each element in queue contain -- node, minimum value, maximum value
        queue = deque([[root, float('-inf'), float('inf')]])

        while (len(queue) > 0):

            front = queue.popleft()
            currNode = front[0]
            currMin = front[1]
            currMax = front[2]

            if (currNode.left != None):             #   add left node if it exists with updated range to check
                queue.append([currNode.left, currMin, currNode.val - 1])
                if not (currNode.left.val >= currMin and currNode.left.val <= currNode.val - 1):
                    return False

            if (currNode.right != None):            #   add right node if it exists with updated range to check
                queue.append([currNode.right, currNode.val + 1, currMax])
                if not (currNode.right.val >= currNode.val + 1 and currNode.right.val <= currMax):
                    return False

        return True