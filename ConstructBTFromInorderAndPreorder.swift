//
//  ConstructBinaryTreeFromPreorder.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/19/26.
//

class BinaryTreeFromInorderPreorder {
    
    init() {
        let preOrder = [3,9,20,15,7]
        let inorder = [9,3,15,20,7]
//        let _ = constructTreeUsingSubarrays(preOrder, inorder)
        var inorderMap = Dictionary<Int, Int>()
        for (index, element) in inorder.enumerated() {
            inorderMap[element] = index
        }
        // return constructTreeUsingSubarrays(preorder, inorder)
        let _ = helper(preOrder, inMap: inorderMap, inStart: 0, inEnd: inorder.count - 1)

    }
    
    /*
     time compelxity - n recursive calls. O(n)
     2. in each recursive call - we are doing n calls for searching the inorder root - O(n)
     3. creating deep copies - O(n) Array(...)
     2nd and 3rd needs O(n) time in each recursive call
     So total time compelxity - O(n^2)
     
     Space complexity - O(n^2)
     n recursive calls. In each, creating four parts of the same array O(n)
     */
    func constructTreeUsingSubarrays(_ preorder: [Int], _ inorder: [Int]) -> TreeNode? {
        
        if (preorder.count == 0) {
            return nil
        }
        let rootVal = preorder[0]
        let rootNode = TreeNode(val: rootVal, left: nil, right: nil)

        var inorderRoot = -1
        //find out the value in inorder array
        for i in 0..<inorder.count {
            if (inorder[i] == rootVal) {
                inorderRoot = i
                break
            }
        }

        let inLeft = inorder[0..<inorderRoot] //span of inorder of left subtree
        let inRight = inorder[(inorderRoot+1)..<(inorder.count)]
        let preLeft = preorder[1..<1+inLeft.count]
        let preRight = preorder[1+inLeft.count..<preorder.count]


        rootNode.left = constructTreeUsingSubarrays(Array(preLeft), Array(inLeft))
        rootNode.right = constructTreeUsingSubarrays(Array(preRight), Array(inRight))
        return rootNode

    }
    
    /*
     Time complexity - O(n)
     space complexity - O(n)
     */
    var preOrderIdx: Int  = 0
    
    //using pointers and map
    func helper(_ preorder: [Int], inMap: Dictionary<Int,Int>, inStart: Int, inEnd: Int) -> TreeNode? {
        if (inStart > inEnd) {
            return nil
        }
        //logic
        let rootVal =  preorder[preOrderIdx]
        let root = TreeNode(val: rootVal, left: nil, right: nil)
        preOrderIdx = preOrderIdx + 1

        let inRIdx = inMap[rootVal]!

        root.left = helper(preorder, inMap: inMap, inStart: inStart, inEnd: inRIdx - 1)
        root.right = helper(preorder, inMap: inMap, inStart: inRIdx + 1, inEnd: inEnd)
        return root
    }
}
