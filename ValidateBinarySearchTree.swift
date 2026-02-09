//
//  Validate binary search tree.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/15/26.
//

/*
 inorder traversal is sorted if it is BST.
 inorder - left -> root -> right, right -> root -> left
 preorder = root -> left -> right , root -> right -> left
 postorder = left - right - root, right - left - root

 to check if it is valid bst or not -> Do inorder, if sorted, it's BST
 */

class TreeNode {
    var left: TreeNode?
    var right: TreeNode?
    var val: Int
    
    init(val: Int, left: TreeNode?, right: TreeNode?) {
        self.val = val
        self.left = left
        self.right = right
    }
}

class BinarySearchTree {
    
    var prev: TreeNode?
    var flag: Bool
    
    init() {
        flag = true
    }
    
    func inorderTraversal(_ root: TreeNode?) -> [Int] {
        //base
        if (root == nil) {
            return []
        }
        let leftTraversal: [Int] = inorderTraversal(root?.left)
        let rightTraversal = inorderTraversal(root?.right)
        return leftTraversal + [root!.val] + rightTraversal
    }
    
    func isValidBST(root: TreeNode?) -> Bool {
        self.flag = true
        inorderToCheckValidBST(root)
        return flag
    }
    
    func inorderToCheckValidBST(_ root: TreeNode?) {
        if (root == nil) {
            return
        }
        if (!flag) {
            return
        }
        inorderToCheckValidBST(root?.left)
        if (prev != nil && root!.val <= prev!.val) {
            //breach
            flag = false
        }
        prev = root
            inorderToCheckValidBST(root?.right)
    }
    
    //without flag bool
    func isValidBSTWithoutFLag(root: TreeNode?) -> Bool {
        return inorderToCheckValidBSTBooleanBased(root)
    }
    
    //boolean based recursion
    func inorderToCheckValidBSTBooleanBased(_ root: TreeNode?) -> Bool {
        if (root == nil) {
            return true
        }
        let isLeftValid: Bool = inorderToCheckValidBSTBooleanBased(root?.left)
        if (!isLeftValid) {
            return false
        }
        
        if (prev != nil && root!.val <= prev!.val) {
            //breach
            return false
        }
        prev = root
        return inorderToCheckValidBSTBooleanBased(root?.right)
    }
}

extension BinarySearchTree {
    //Without previous variable
    
    func inOrderWithoutPreviousVariable(_ root: TreeNode?) -> Bool {
        if (root == nil) {
            return true
        }
        
        let isLeftValid = inOrderWithoutPreviousVariable(root?.left)
        let isRightValid = inOrderWithoutPreviousVariable(root?.right)
        
        if (root!.left != nil && root!.val < root!.left!.val) {
            return false
        }
        
        if (root!.right != nil && root!.val > root!.right!.val) {
            return false
        }
        
        return isLeftValid && isRightValid
    }
}
/*
 at every node, we can have a potential range. Each element should lie in that range. If there is a breach, then it's not a valid BST.
 start recursion from the root.
 IF  we keep max and min in global then,
 //if going left, then max = root.val, minimum = earlier minimum only
 
 If I go right , then minimum will be root.val. maximum = earlier maximum
 Every node should have it's own minimum and maximum.
 
 time complexity -> each node will be visited once so O(n)
 */
class BinarySearchTree2 {
    
    var flag = true
    var node: TreeNode?
    init() {
        
        let isValid = validateBinarySearchUsingRange(root: node, min: Int.min, max: Int.max)
        print("isValid \(isValid)")
    }
    
    func validateBinarySearchUsingRange(root: TreeNode?, min: Int, max: Int) -> Bool {
        
        if (root == nil) {
            return true
        }
        
        //checking that the node is in the range at preorder level. We can check the same at postorder and inorder level.
        /*minimum and maximum are in the recursion stack. Whenever root is coming out, it's comin gout with it's minimum and maximum. It will remain same at the preorder, postorder and inorder*/
        if (root!.val >= max && root!.val <= min) {
            return false
        }
        
        let isLeftValid = validateBinarySearchUsingRange(root: root?.left, min: min, max: root!.val)
        
        //stopping the right side recursive calls id the flag is false.
        if (!isLeftValid) {
            return false
        }
        let isRightValid = validateBinarySearchUsingRange(root: root?.right, min: root!.val, max: max)
        
        return isLeftValid && isRightValid
    }
}
