class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def __init__(self):
        self.preorder = []
        self.inorder = []
        self.indices = {}
        self.index = 0

    def __buildTree(self, inS, inE):
        if (inS > inE):
            return None
        inIdx = self.indices[self.preorder[self.index]]
        currentRoot = TreeNode(self.preorder[self.index])

        self.index += 1
        currentRoot.left = self.__buildTree(inS, inIdx - 1)     
        currentRoot.right = self.__buildTree(inIdx + 1, inE)   

        return currentRoot                 

    def buildTree(self, preorder, inorder):
        if (preorder == None or len(preorder) == 0):
            return None
        self.preorder = preorder
        self.inorder = inorder

        for i in range(len(self.inorder)):
            self.indices[self.inorder[i]] = i

        return self.__buildTree(0, len(self.inorder) - 1)


class BuildTreeInPre_Stack(object):
    def buildTree(self, preorder, inorder):
        if (preorder == None or len(preorder) == 0):
            return None

        preorder = preorder
        inorder = inorder

        indices = {}
        for i in range(len(inorder)):
            indices[inorder[i]] = i

        rootNode = TreeNode(preorder[0])
        stack = deque([[rootNode, 0, 0, len(preorder) - 1]])
        index = 1     

        while (len(stack) > 0):
            top = stack[-1]       
            topNode = top[0]
            topCount = top[1]
            topMin = top[2]
            topMax = top[3]

            if topCount == 0:       
                stack[-1][1] += 1
                if (index >= 0 and index < len(preorder)):     
                    if (topMin > indices[topNode.val] - 1): 
                        continue
                    topNode.left = TreeNode(preorder[index])    
                    stack.append([topNode.left, 0, topMin, indices[topNode.val] - 1])
                index += 1                         

            elif topCount == 1:    
                stack[-1][1] += 1
                if (index >= 0 and index < len(preorder)):      
                    if (topMax < indices[topNode.val] + 1):     
                        continue
                    topNode.right = TreeNode(preorder[index])   
                    stack.append([topNode.right, 0, indices[topNode.val] + 1, topMax])
                index += 1                                     
            elif topCount == 2:        
                stack.pop()

        return rootNode