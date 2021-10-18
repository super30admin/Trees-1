// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
    var preIndex = Int()
    var hashmap = [Int:Int]()
    func buildTree(_ preorder: [Int], _ inorder: [Int]) -> TreeNode? {
        preIndex = 0
        if inorder == nil || preorder == nil{
            return nil
        }
        for i in 0..<inorder.count {
            hashmap[inorder[i]] = i
        }
        return buildTreeHelper(0,inorder.count-1,inorder,preorder)
        
    }
    func buildTreeHelper(_ instart: Int, _ inend: Int, _ inorder: [Int], _ preorder: [Int]) -> TreeNode?{
        if instart > inend {
            return nil
        }
        var root = TreeNode(preorder[preIndex])
        guard let index = hashmap[preorder[preIndex]] else { return root }
        preIndex += 1
        root.left = buildTreeHelper(instart,index-1,inorder,preorder)
        root.right = buildTreeHelper(index+1,inend,inorder,preorder)
        return root
    }