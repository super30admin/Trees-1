#Approach1: Store all inorder element and map into its index into hashmap
# reverse preorder and then one by one pop from end and check root in O(1) search from inorder hashmap,and call recursively from index before and after to left and right childs

#Time Complexity: O(N): O(N) for recursion and O(N) for reversing preorder so everytime we pop from front there wont be multiple O(N)
#Space Complexity O(N): hashmap for inoder.
#It successfully runs on the leetcode

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        d= {v:i for i,v in enumerate(inorder)}
        preorder.reverse()
        return self.helperbuildtree(preorder, d, 0, len(preorder)-1)
            
    def helperbuildtree(self, preorder, d, s, e): 
        if s > e: return None
        root = TreeNode(preorder.pop())
        idx = d[root.val]
        root.left = self.helperbuildtree(preorder, d, s, idx-1)
        root.right = self.helperbuildtree(preorder, d, idx+1, e)
        return root


#Approach1: Take root from preorder and pop it, 
#find the popped one root in inorder and take all left of it to left recursion and right of it to right recursion
#so every time we will have smaller inorder preorder for left and right
#Time Complexity O(N^2) aas index traversing all lists are O(N) also pop is O(N)
#Space Complexity O(N) callstack in recursion we are storing a sublist in every recursion.
#It successfully runs on the leetcode

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not inorder: return 
        ind = inorder.index(preorder.pop(0))
        root = TreeNode(inorder[ind])
        root.left= self.buildTree(preorder, inorder[:ind])
        root.right = self.buildTree(preorder, inorder[ind+1:])
        return root

