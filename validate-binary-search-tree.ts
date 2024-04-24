function sumNumbers(root: TreeNode | null): number {
    let result : number = 0
    helper(root, 0)
    return result

    function helper(root: TreeNode,  curNum: number) : void{
        //basecase
        if(!root) { return }

        curNum = curNum * 10 + root.val

        if(!root.left && !root.right){
            // console.log('curNum', curNum)
            // console.log('result before', result)
            result  = result + curNum
            // console.log('result after', result)
        }
        helper(root.left, curNum)
        helper(root.right, curNum)
    }

};
