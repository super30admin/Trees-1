# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = None
         self.right = None

from collections import deque

class Solution(object):

    def isValidBST(self, root):
        if (root == None):
            return True
        stack = [[root, float('-inf'), float('inf'), 0]]

        while (len(stack) > 0):
            top = stack[-1]

            if (top[3] == 0):                   
                stack[-1][3] += 1
                if (top[0].left != None):
                    if (top[0].left.val >= top[1] and top[0].left.val <= top[0].val - 1): 
                        stack.append([top[0].left, top[1], top[0].val - 1, 0])   
                    else:
                        return False
                continue

            elif (top[3] == 1):                 
                stack[-1][3] += 1
                if (top[0].right != None):
                    if (top[0].right.val >= top[0].val + 1 and top[0].right.val <= top[2]):  
                        stack.append([top[0].right, top[0].val + 1, top[2], 0])   
                    else:
                        return False
                continue
            elif (top[3] == 2):                
                stack.pop()
        return True  

class validBST_Recursive(object):
    def __isValidBST(self, root, minVal, maxVal):
        if (root == None):
            return True

        if root.val >= minVal and root.val <= maxVal:          
            return (self.__isValidBST(root.left, minVal, root.val - 1) and  
                    self.__isValidBST(root.right, root.val + 1, maxVal)) 
        return False

    def isValidBST(self, root):
        return self.__isValidBST(root, float('-inf'), float('inf'))

class validBST_Queue(object):
    def isValidBST(self, root):
        if (root == None):
            return True
        queue = deque([[root, float('-inf'), float('inf')]])
        while (len(queue) > 0):
            front = queue.popleft()
            currNode = front[0]
            currMin = front[1]
            currMax = front[2]
            if (currNode.left != None):       
                queue.append([currNode.left, currMin, currNode.val - 1])
                if not (currNode.left.val >= currMin and currNode.left.val <= currNode.val - 1):
                    return False
            if (currNode.right != None):     
                queue.append([currNode.right, currNode.val + 1, currMax])
                if not (currNode.right.val >= currNode.val + 1 and currNode.right.val <= currMax):
                    return False
        return True