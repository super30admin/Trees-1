# We use preorder to determine the root and a hashmap (mapping) to find the root index in inorder, 
# allowing us to recursively construct the left and right subtrees. The deque optimizes popleft() operations for efficiency.

# Time Complexity: O(n) (Each node is processed once, and hashmap lookups take O(1)).
# Space Complexity: O(n) (Hashmap storage and recursion stack in the worst case)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        mapping = {}
        for i in range(len(inorder)):
            mapping[inorder[i]] = i
        preorder = collections.deque(preorder)

        def build(start, end):
            if start > end: return None

            root = TreeNode(preorder.popleft())
            mid = mapping[root.val]

            root.left = build(start, mid - 1)
            root.right = build(mid + 1, end)

            return root
            
        return build(0, len(preorder) - 1)