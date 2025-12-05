'''
In this problem we need construct a Binary tree from the given preorder and inorder traversal arrays of same BT
The Preorder traversal always starts with root node, so we can start constructing the BT by taking first element of preorder as root node.
I took a helper function which runs till my start pointer moves past my end pointer. 
To find the left and right sub trees, we can start by finding index of root element in inorder by using a hashmap.
All the elements to the left of root index in Inorder array form left sub tree, and storing each of the node elements in the root, similarly for right sub tree.
the tree is built recursively, using preorder's order of elements and inorder's left and right partitions, 
'''
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.index = 0
        self.inorderMap = {val: i for i, val in enumerate(inorder)}
        return self.helper(preorder, 0, len(inorder)-1)
    
    def helper(self, preorder, start, end):
        if start > end: return None
        # logic
        rootValue = preorder[self.index]
        self.index += 1
        root = TreeNode(rootValue)
        # finding index of root value in inorder array
        rootIndex = self.inorderMap[rootValue]

        root.left = self.helper(preorder, start, rootIndex - 1)
        root.right = self.helper(preorder, rootIndex + 1, end)

        return root
'''
Time Complexity: O(n)
Since we are iterating on the nodes of the tree once, time taken is O(n) 
Space Complexity: O(n)+O(h)
Space for the hash map is O(n) and space taken by stack is equal to the height of the tree O(h)
'''