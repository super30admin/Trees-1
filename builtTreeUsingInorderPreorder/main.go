/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
/*
    approach:
    
    Preorder -> root-left-right
    Inorder -> left-root-right
    
    * The trick here is to recursively collect all root nodes and pass them back to parent.Left and parent.Right
    
    1. Get the initial root value from preorder : it will always be the 0th idx
    2. Find the index of the root value in inorder
        - All elements to the left of rootIdx in inorder is the left subtree
        - All elements to the right to rootIdx in inorder is the right subtree
    3. Using the rootIdx found in inorder, we can locate the left and right subtree in preorder
        - Why do we need to do this?
        - Well we will always look for a starting root in recursive call for a parent.Left and parent.Right
        - Once a recursive call at the lowest level is done, the root obj gets passed back to its parent.Left and or parent.Right
        - So we are setting/finding root at each recursive call and caller parent will set the return value to root.Left and root.Right
    4. How can we find the preorder left and right subtree in preorder using rootIdx from inorder?
        - Well it happens to be that in preorder;
            - preOrder[1:rootIdx+1] - is the left subtree in preorder
                - Why start from 1 here? because 0 is already used - ITS THE INITIAL ROOT!
            - preOrder[rootIdx+1:] is the right subtree in preorder
    5. Now we have preLeft and preRight - i.e we have root for left subtree and right subtree
    6. Which means we can recursively call the buildTree with updated preorder and inorder
        - Inorder left would be everything to the left of rootIdx in inorder
        - Inorder right would be everything to the right of rootIdx in inorder
        - Which means its also important that we send down the updated inorder list to each recursive call so we can correctly find the rootIdx again relative to the new updated preOrder list
        
    
*/
// func buildTree(preorder []int, inorder []int) *TreeNode {
    
//     if len(preorder) != len(inorder) || len(preorder) == 0 && len(inorder) == 0 {
//         return nil
//     }
    
//     // get the root value from preorder[0] ( since preorder is root-left-right)
//     root := &TreeNode{Val: preorder[0]}
    
//     // then look for the same root val in inorder
//     rootIdx := -1
//     // time: o(len(inorder))
//     for i := 0; i < len(inorder); i++ {
//         if inorder[i] == root.Val {
//             rootIdx = i
//             break
//         }
//     }
    
//     // all elements to left of rootIdx in inorder is the left subtree from inorder's perspective
//     // all elements to right of rootIdx in inorder is the right subtree from inorder's perspective
//     // now using the rootIdx, we can locate the preOrder left and right and recursively call buildTree for this root.Left and root.Right
//     root.Left = buildTree(preorder[1:rootIdx+1], inorder[0:rootIdx])
//     root.Right = buildTree(preorder[rootIdx+1:], inorder[rootIdx+1:])
    
//     // at some point 1 root node will return and pop all of the parents from recursion stack and build the tree from bottom up
//     return root
// }



// the above approach works however time complexity wise, we have o(n^2) because at each recursive call
// we search in o(n) time in inordet to find rootIdx
// and we also take (n) for each preOrder and inorder slicing 
// same thing for space, at each recursive call, we allocated a new smaller inorder and preorder list : o(n^2) 


// for searching over and over again, lets toss inorder into a val:idx map initially
// and for slicing inorder left and right , we will use 2 pointers as boundary idx ( start and end ) 

// time: o(n)
// space: o(n)


// This is to scope down the global var access to be only within an instance of this class or we will end up with global pollution
type btree struct {
    inordermap map[int]int
    idx int
}

func buildTree(preorder []int, inorder []int) *TreeNode {
    btree := &btree{inordermap: map[int]int{}, idx: 0}
    for i := 0; i < len(inorder); i++ { // o(len(inorder)) time and space for inordermap
        btree.inordermap[inorder[i]] = i
    }
    return btree.build(preorder, 0, len(inorder)-1)
}


// why are we not passing inorder list here?
// we dont need it because we only used inorder to find our rootIdx
func (b *btree) build(preorder []int, start, end int) *TreeNode{
    if start > end {
        return nil
    }
    
    root := &TreeNode{Val: preorder[b.idx]}
    rootIdxInInorder := b.inordermap[root.Val]
    b.idx++
    root.Left = b.build(preorder, start, rootIdxInInorder-1)
    root.Right = b.build(preorder, rootIdxInInorder+1, end)
    return root
}
