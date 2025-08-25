# Time Complexity : It is O(n) since we are iterating with all nodes.
# Space Complexity : It is O(h) considering the height of the tree in the stack.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

class Solution:
    preOrderTree = []
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(inorder) == 0:
             return
        root =  TreeNode(preorder[0])
        i = 0
        for inOrderNode in inorder:            
            if inOrderNode == preorder[0]:
                Solution.preOrderTree.append(inOrderNode)
                break
            i+=1
        
        inorderLeft =  inorder[:i]
        inorderRight =  inorder[i+1:]
        preorderLeft =  preorder[1:len(inorderLeft)+1]
        preorderRight =  preorder[len(inorderLeft)+1:]
        root.left = Solution.buildTree(self,preorderLeft,inorderLeft)
        root.right = Solution.buildTree(self,preorderRight,inorderRight)
        return root
