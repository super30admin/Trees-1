'''
PROBLEM 1

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)

- using iterative approach, go to the extreme left of the tree while adding the root in the stack, when root is null, pop the root from the stack and compare to prev
- prev indicates the previous element traversed in inorder traversal
- If prev is greater than the root at any point, return False otherwise return True


'''

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        prev=None
        stack=[]
        
        while(root!=None or len(stack)!=0):
            

                
            while(root!=None):
                stack.append(root)
                root=root.left
                
            root=stack.pop()
            
            if prev!=None:
                if prev.val>=root.val:
                    return False
            prev= root
            root=root.right
            
        return True

'''
PROBLEM 2

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)

- store the indexes of elements of inorder in a hashmap so that we can find the left subtree and right subtree indexes in O(1)
- traverse the preorder array, create a node for it and find the left and right subtree indexes for that node
- pass the indexes of left and right subtree to recursion to do the job


'''

class Solution:
    idx=0
    dicti={}
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder)==0: return None
        root=preorder[0]
        
        for i in range(len(inorder)):
            self.dicti[inorder[i]]=i
        
        return self.helper(preorder,inorder, 0, len(inorder)-1)
    
    def helper(self, preorder: List[int],inorder, start, end):
        #base case
        if start>end: return None
        
        #logic
        rootIndex= self.dicti[preorder[self.idx]]
        node=TreeNode(preorder[self.idx])
        self.idx+=1
        
        node.left= self.helper(preorder, inorder, start, rootIndex-1)
        node.right= self.helper(preorder, inorder, rootIndex+1, end)
        
        return node
        
        
        
        