  ---------------------- Construct Binary Tree Inorder Preorder------------------------------------------------   
# Time Complexity : O(N) N is the number of nodes.
# Space Complexity : O(N) N is the number of nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here preorder is the order of nodes with left , curr, and right node. Inorder is the order where root node will be first. 
# In this sense, the nodes on the left indexes of element are its left nodes and right are its right nodes. Also the preorder will have all the root nodes in the first.
# So recursively , we will create a root with preorder index element and find the index of the element in inorder and assign the left elements to root.left and right elements to root.right.
# and we will call recursive function again with new preorder and inorder.

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder or not inorder:
            return None
        
        def dfs(preorder, inorder):
            if not preorder or not inorder:
                return None
            

            index = inorder.index(preorder[0])
            root = TreeNode(preorder[0])
   
            root.left = dfs(preorder[1:index+1],inorder[:index])
            root.right = dfs(preorder[index+1:], inorder[index+1:])
            
            return root
        
        return dfs(preorder, inorder)
        
    
----------------------------Iteratively------------------------------------------------  
# Time Complexity : O(N) N is the number of nodes.
# Space Complexity : O(N) N is the number of nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here preorder is the order of nodes with left , curr, and right node. Inorder is the order where root node will be first. 
# In this sense, the nodes on the left indexes of element are its left nodes and right are its right nodes. Also the preorder will have all the root nodes in the first.
# So we will create a node with preorder elements and check the position of that element with respect to the prev created node.
# If it is less the new node is left of prev else we will remove elements from stack untill we reach the right root of that node.

        
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:        
      	d = {}
        for k,v in enumerate(inorder):
            d[v] = k
        
        stack = []
        root = None
        
        for val in preorder:
            if not root:
                root = TreeNode(preorder[0])
                stack.append(root)
            else:
                curr = TreeNode(val)
                if d[curr.val]<d[stack[-1].val]:
                    stack[-1].left = curr
                else:
                    while stack and d[stack[-1].val]<d[curr.val]:
                        u = stack.pop()
                    u.right = curr
                stack.append(curr)
        return root