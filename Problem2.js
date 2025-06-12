// ## Problem 2
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : understanding why we dont need preOrder array in optimal was hard, because we send new array for both inOrder and preOrder 
var buildTree = function(preorder, inorder) {
    //**Time Complexity : O(n) */
    //**Space Complexity : O(n) */
    let hashMap = new Map()
    for(let i=0;i<inorder.length;i++){
        //Build a map so we can get the index in constant time
        hashMap.set(inorder[i],i)
        //let rootIndex = inorder.indexOf(rootVal) // in brute force we did this
    }
    // console.log(hashMap)
    // preOrder is just for root only
    let rootIndex = 0
    function build(start,end){
        if(start>end) return null
        //PreOrder first index is always root 
        let rootVal = preorder[rootIndex]
        //Once we have the value increment becasue next call will be root
        rootIndex+=1
        //Create a TreeNode ele with root.val in it
        let root = new TreeNode(rootVal)
        //Get the root in the inOrder so we can split it in 2 section
        let inOrderIndex = hashMap.get(rootVal)
        ////     let rootIndex = inorder.indexOf(rootVal) in brute force we did this
        //left section
        root.left = build(start,inOrderIndex-1)
        //right section
        root.right = build(inOrderIndex+1,end)
        //return root
        return root
    }
    return build(0,inorder.length-1)
};

// var buildTree = function(preorder, inorder) {
//     //**Time Complexity : O(n^2)
//     //**Space Complexity : O(n) // create a subArray half(ing) it but still its O(n)
//     if(preorder.length==0 || inorder.length==0) return null
    
//     let rootVal = preorder[0]
//     let root = new TreeNode(rootVal);
//     let rootIndex = inorder.indexOf(rootVal)

//     let leftInOrder = inorder.slice(0,rootIndex)//exclusive    
//     let rightInOrder = inorder.slice(rootIndex+1)
    
//     // let leftPre = preorder.slice(rootIndex+1,leftInOrder.length) 
//     let leftPre = preorder.slice(1, 1 + leftInOrder.length);
//     let rightPre = preorder.slice(1 + leftInOrder.length);
//     // let rightPre = preorder.slice(1 + leftInOrder.length)

//     root.left = buildTree(leftPre,leftInOrder)
//     root.right = buildTree(rightPre,rightInOrder)

//     return root

// };