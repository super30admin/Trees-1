"""
Generate tree from Inorder and preorder traversal
First node in the preorder will be the root node
Find the root node in the inorder - nodes to the left of that node belong to the left subtree and nodes to the right of that
node belong to the right subtree
We repeat the above process to find the left and the right subtrees for every node 

TC = O(n*n) - finding root and creating subpreorder and subinorder
SC = O(1) - 

"""



from re import L


class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = 0
        self.left = left
        self.right = right

class Solution : 
    def buildTree (self, preorder : list[int], inorder : list[int]) -> [TreeNode] :
        n =  len(preorder)
        if n==0 or preorder == None :
            return None
        
        root = TreeNode(preorder[0])
        self.rootidx = -1

        for i in range (n):
            if inorder[i]==root.val :
                self.rootidx  = i
        inLeft = inorder[0:self.rootidx]
        inRight = inorder[self.rootidx+1 : ]
        preLeft = preorder[1:len(inLeft)+1]
        preRight = preorder[1+len(preLeft):]


        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)

        return root
        
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
object = Solution()
ans = object.buildTree(preorder, inorder)
print(ans)

"""
Hashmap approach --
To reduce the time complexity in finding out the position of the root everytime, we create a hashmap to 
store the position of all the elements in inorder traversal 

TC = O(n)
SC = O(n)

"""
def buildTree(self, preorder, inorder):
    n = len(preorder)
    self.preIdx = 0
    if n ==0:
        return None
    #create a hashmap to store inorder elements
    map = {}
    for i in range(n):
        if inorder[i] not in map:
            map[inorder[i]]=i

    return self.helper(preorder, map,0,n-1)

def helper(self, preorder, map, startI, endI):
    if startI >endI:
        return None
    curr= preorder[self.preIdx]
    root = TreeNode(curr)
    self.preIdx+=1

    rootIdx = map[curr]

    root.left = self.helper(preorder, map, startI, rootIdx - 1)
    root.right = self.helper(preorder, map, rootIdx + 1, endI)
    return root





