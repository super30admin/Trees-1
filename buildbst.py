#time complexity: O(n) n- no of nodes
#preordering process takes O(n), inorder index as we are using hash map it takes O(1) on an average. so overall O(n)
#space complexity:O(n) n- number of nodes, Cresating hashmap O(n), creating n-tree nodes - .O(n). overall O(n)



class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        #lets use hashmap for storing the indices of the inorder array 
        #otherwise we need to travel the whole array for each recursive call 
        #by doing this it will take  O(1) lookup to find the root's position

        inorder_map = {val: idx for idx, val in enumerate(inorder)}

        #lets build a helper function that constructs the tree
        #pre_start, pre_end --> current segment of the preorder array
        #in_atart, in_end --> current sgmant of the inorder array

        def build(preorder_start: int, preorder_end: int, inorder_start: int, inorder_end: int) -> Optional[TreeNode]:

            #base case: If the range is invalid (empty or reversed)
            if preorder_start > preorder_end or inorder_start > inorder_end:
                return None #this applies for every iteration
            
            #The first element of the preorder array is the root of the current subtree
            root_val = preorder[preorder_start]
            #construct a tree with that root
            root = TreeNode(root_val)

            #now we know what value is the root from preorder array . we need to find the index corresponding to that value in inorder array
            inorder_root_index = inorder_map[root_val]

            #calculate the number of elements in the left subtree from the 
            #that is the number of elements left side of root.val in the inorder array

            left_subtree_size = inorder_root_index - inorder_start

            #now lets build left and right subtree recursively

            #left subtree 
            #for preorder; the left subtree elements immiditly follw the root
            #   It starts from preorder_start + 1 till left_subtree_size elements
            #For inorder: It is the segment from inorder_start up to the inorder_root_index(excluding it)

            root.left = build(preorder_start+1, preorder_start+left_subtree_size, inorder_start, inorder_root_index -1)

            #build right subtree
            root.right = build(preorder_start + left_subtree_size +1, preorder_end, inorder_root_index+1, inorder_end)

            return root
        
        #now lets take the initial call to the recursive function
        #initially full inorder amnd preorder in initialized
        return build(0, len(preorder) - 1, 0, len(inorder) - 1)



        
