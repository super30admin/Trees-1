class TreeNode:
    def __init__(self,val=0,left=None,right=None):
        self.val=val
        self.left=left
        self.right=right
class Solution:
    def buildTree(self,preorder,inorder):
        inorder_index_map={val:idx for idx,val in enumerate(inorder)}
        self.pre_idx=0

        def helper(left,right):
            if left>right:
                return None
            
            root_val=preorder[self.pre_idx]
            self.pre_idx+=1
            root=TreeNode(root_val)

            index=inorder_index_map[root_val]

            root.left=helper(left,index-1)
            root.right=helper(index+1,right)

            return root
        
        return helper(0,len(inorder)-1)
    
from collections import deque

def printLevelOrder(root):
    if not root:
        return[]
    
    result=[]
    queue=deque([root])

    while queue:
        node=queue.popleft()
        if node:
            result.append(node.val)
            queue.append(node.left)
            queue.append(node.right)
        else:
            result.append(None)

    while result and result[-1] is None:
        result.pop()
    return result


sol=Solution()
root=sol.buildTree(preorder = [3,9,20,15,7], inorder = [9,3,15,20,7])
print(printLevelOrder(root))