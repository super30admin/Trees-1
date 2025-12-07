from typing import List, Optional, Dict

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    PROBLEM SUMMARY:
    Given preorder and inorder traversal arrays, reconstruct the binary tree.
    
    KEY INSIGHTS:
    - Preorder: Root -> Left -> Right (first element is always root)
    - Inorder: Left -> Root -> Right (root splits left and right subtrees)
    - Use preorder to identify roots, inorder to identify subtree boundaries
    
    APPROACH COMPARISON:
    
    1. Recursive with HashMap (RECOMMENDED - Optimal)
       Summary: Use hashmap for O(1) inorder index lookup, recursively build subtrees
       Time: O(n), Space: O(n)
    
    2. Recursive without HashMap
       Summary: Linear search in inorder array to find root position each time
       Time: O(n²) worst case, Space: O(n)
    
    3. Iterative with Stack
       Summary: Use stack to simulate recursion, track parent-child relationships
       Time: O(n), Space: O(n)
    
    WHY APPROACH 1 IS BEST:
    - O(n) time complexity (optimal, must visit each node once)
    - Cleaner, more intuitive recursive logic
    - Hashmap eliminates repeated linear searches in approach 2
    - More readable than iterative stack-based approach 3
    """
    
    # ========================================================================
    # APPROACH 1: RECURSIVE WITH HASHMAP (OPTIMAL) ⭐
    # ========================================================================
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        """
        Construct binary tree using recursive approach with hashmap optimization.
        
        Time Complexity: O(n) - visit each node exactly once
        Space Complexity: O(n) - hashmap storage + O(h) recursion stack where h is height
        
        Args:
            preorder: Preorder traversal [root, left subtree, right subtree]
            inorder: Inorder traversal [left subtree, root, right subtree]
            
        Returns:
            Root node of the constructed binary tree
        """
        # Build hashmap: value -> index in inorder array
        # This allows O(1) lookup instead of O(n) linear search
        inorder_index_map = {val: idx for idx, val in enumerate(inorder)}
        
        # Track current position in preorder array (next root to process)
        self.preorder_idx = 0
        
        # Recursively build the tree
        return self._build_recursive(
            preorder, 
            inorder_index_map, 
            left_bound=0, 
            right_bound=len(inorder) - 1
        )
    
    def _build_recursive(
        self, 
        preorder: List[int], 
        inorder_index_map: Dict[int, int],
        left_bound: int, 
        right_bound: int
    ) -> Optional[TreeNode]:
        """
        Recursively construct subtree for inorder range [left_bound, right_bound].
        
        Algorithm:
        1. Base case: if left_bound > right_bound, return None (empty subtree)
        2. Get next root value from preorder (current preorder_idx)
        3. Find root's position in inorder to split left/right subtrees
        4. Recursively build left subtree (elements before root in inorder)
        5. Recursively build right subtree (elements after root in inorder)
        
        Args:
            preorder: Preorder traversal array
            inorder_index_map: Hashmap of value -> inorder index
            left_bound: Left boundary of current subtree in inorder
            right_bound: Right boundary of current subtree in inorder
            
        Returns:
            Root node of the constructed subtree
        """
        # Base case: no elements in this subtree
        if left_bound > right_bound:
            return None
        
        # Get the next root value from preorder traversal
        root_val = preorder[self.preorder_idx]
        self.preorder_idx += 1  # Move to next element for future recursive calls
        
        # Create the root node
        root = TreeNode(root_val)
        
        # Find the root's position in inorder array using hashmap (O(1))
        root_inorder_idx = inorder_index_map[root_val]
        
        # Recursively build left subtree
        # Left subtree contains elements from left_bound to (root_position - 1) in inorder
        root.left = self._build_recursive(
            preorder, 
            inorder_index_map, 
            left_bound, 
            root_inorder_idx - 1
        )
        
        # Recursively build right subtree
        # Right subtree contains elements from (root_position + 1) to right_bound in inorder
        root.right = self._build_recursive(
            preorder, 
            inorder_index_map, 
            root_inorder_idx + 1, 
            right_bound
        )
        
        return root
    
    # ========================================================================
    # APPROACH 2: RECURSIVE WITHOUT HASHMAP (LESS EFFICIENT)
    # ========================================================================
    
    def buildTree_v2(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        """
        Construct binary tree using recursive approach WITHOUT hashmap.
        
        Time Complexity: O(n²) worst case - O(n) linear search for each of n nodes
        Space Complexity: O(n) - recursion stack only
        
        DRAWBACK: Performs linear search in inorder array for each node,
                  leading to O(n²) time in worst case (skewed tree)
        """
        self.preorder_idx = 0
        return self._build_without_map(preorder, inorder, 0, len(inorder) - 1)
    
    def _build_without_map(
        self, 
        preorder: List[int], 
        inorder: List[int],
        left_bound: int, 
        right_bound: int
    ) -> Optional[TreeNode]:
        """Helper method that performs linear search in inorder array."""
        if left_bound > right_bound:
            return None
        
        root_val = preorder[self.preorder_idx]
        self.preorder_idx += 1
        root = TreeNode(root_val)
        
        # Linear search for root in inorder (O(n) per call) ❌
        root_inorder_idx = inorder.index(root_val, left_bound, right_bound + 1)
        
        root.left = self._build_without_map(preorder, inorder, left_bound, root_inorder_idx - 1)
        root.right = self._build_without_map(preorder, inorder, root_inorder_idx + 1, right_bound)
        
        return root
    
    # ========================================================================
    # APPROACH 3: ITERATIVE WITH STACK
    # ========================================================================
    
    def buildTree_v3(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        """
        Construct binary tree using iterative approach with stack.
        
        Time Complexity: O(n) - process each node once
        Space Complexity: O(n) - stack can hold up to n nodes
        
        Algorithm:
        - Use stack to track potential parent nodes
        - If current inorder value matches stack top, pop (finished left subtree)
        - Otherwise, attach as left child and push to stack
        """
        if not preorder:
            return None
        
        root = TreeNode(preorder[0])
        stack = [root]
        inorder_idx = 0
        
        # Process each preorder element (except first, already used for root)
        for i in range(1, len(preorder)):
            current_val = preorder[i]
            node = TreeNode(current_val)
            parent = None
            
            # Check if we've finished processing left subtree
            # If stack top matches inorder element, we've completed its left subtree
            while stack and stack[-1].val == inorder[inorder_idx]:
                parent = stack.pop()
                inorder_idx += 1
            
            if parent:
                # Finished left subtree, attach as right child
                parent.right = node
            else:
                # Still building left subtree, attach as left child
                stack[-1].left = node
            
            stack.append(node)
        
        return root


# ============================================================================
# VISUAL EXAMPLE
# ============================================================================
"""
Example: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]

Step-by-step construction:

1. preorder[0] = 3 is root
   Inorder: [9] | 3 | [15,20,7]
            left    right
   
       3
      
2. preorder[1] = 9 is next root (left subtree of 3)
   Inorder: [] | 9 | []
   
       3
      /
     9

3. preorder[2] = 20 is next root (right subtree of 3)
   Inorder: [15] | 20 | [7]
   
       3
      / \
     9   20

4. preorder[3] = 15 is next root (left subtree of 20)
   
       3
      / \
     9   20
        /
       15

5. preorder[4] = 7 is next root (right subtree of 20)
   
       3
      / \
     9   20
        / \
       15  7

Final tree constructed!
"""


# ============================================================================
# COMPLEXITY ANALYSIS SUMMARY
# ============================================================================
"""
┌──────────────────────┬─────────────────┬──────────────────┬────────────────┐
│ Approach             │ Time Complexity │ Space Complexity │ Recommended?   │
├──────────────────────┼─────────────────┼──────────────────┼────────────────┤
│ Recursive + HashMap  │ O(n)            │ O(n)             │ ✅ YES (Best)  │
│ Recursive (no map)   │ O(n²)           │ O(n)             │ ❌ NO          │
│ Iterative + Stack    │ O(n)            │ O(n)             │ ⚠️  Alternative│
└──────────────────────┴─────────────────┴──────────────────┴────────────────┘

WHY APPROACH 1 IS OPTIMAL:
✅ O(n) time - must visit each node, can't do better
✅ Clean recursive logic - easy to understand and maintain
✅ Hashmap eliminates redundant searches
✅ Industry standard solution
"""