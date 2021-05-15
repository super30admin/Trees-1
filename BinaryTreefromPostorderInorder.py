# TC: O(N) where N is the number of nodes in the binary tree
# SC: O(N) or O(N + H) where N is size of hashmap used and H is the size of the recursive stack or height of the tree

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.postidx = len(postorder) - 1
        
        def builder(inStart, inEnd):
            if inStart > inEnd:
                return 
            elif inStart == inEnd:
                node = TreeNode(postorder[self.postidx])
                self.postidx -= 1
                return node
            
            rootval = postorder[self.postidx]
            rootidx = hmap[rootval]
            self.postidx -= 1
            
            root = TreeNode(rootval)
            root.right = builder(rootidx + 1, inEnd)
            root.left = builder(inStart, rootidx - 1)
            
            
            return root
    
        hmap = {}
        for idx, val in enumerate(inorder):
            hmap[val] = idx
    
        return builder(0, len(inorder) - 1)
