'''

Did  it run on leet code: Yes
Did you face any problems: Yes, how do we slice preorder array for left and right subtree

Time Complexity: 0(n2)
- 0(N) :To contruct tree
- 0(N): To search root in inorder array

Space Complexity: 0(N)

Algorithm:

- The first node in preorder traversal is always a root.
- The elements left and right to a node in inorder traversal are its left subtree and right subtree
- Recursively repeated this process
'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    
    
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        return self.build(inorder,0,len(inorder)-1,postorder,0,len(postorder)-1)
    
    
    def build(self,inorder,iLeft,iRight,postorder,pLeft,pRight):
        
        if pLeft>pRight:
            return None
        
        rootVal = postorder[pRight]
        rootNode = TreeNode(rootVal)
        
        index = inorder.index(rootVal)
        
        rootNode.left = self.build(inorder,iLeft,index-1,postorder,pLeft,pLeft+(index-iLeft)-1)
        rootNode.right = self.build(inorder,index+1,iRight,postorder,pLeft+(index-iLeft),pRight-1)
        
        return rootNode