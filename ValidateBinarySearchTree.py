from collections import deque
class TreeNode:
    def __init__(self,val=0,left=None,right=None):
        self.val=val
        self.left=left
        self.right=right

class Solution:
    def isValidBST(self,root):
        self.prev=None
    
        def inorder(node):
            if not node:
                return True
            if not inorder(node.left):
                return False
            if self.prev is not None and node.val <= self.prev:
                return False
            self.prev=node.val
            return inorder(node.right)
    
        return inorder(root)
    
def buildTree(values):
    if not values:
        return None
    root=TreeNode(values[0])
    queue=deque([root])
    i=1
    while queue and i<len(values):
        current=queue.popleft()

        if i<len(values)and values[i] is not None:
            current.left=TreeNode(values[i])
            queue.append(current.left)
        i+=1
        if i<len(values)and values[i] is not None:
            current.right=TreeNode(values[i])
            queue.append(current.right)
        i+=1
    return root

input=[2,1,3]
root=buildTree(input)
sol=Solution()
print(sol.isValidBST(root))
