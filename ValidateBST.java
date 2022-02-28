

// //Using Stack

// class Solution{
//     public boolean isValidBST(TreeNode root)
//     {
//         TreeNode prev = null;
//         Stack<TreeNode> stack = new Stack<>();

//         while(root != null)
//         {
//             stack.push(root);
//             root = root.left;

//         }

//         while(!stack.isEmpty())
//         {
//             root = stack.pop();
//             //process
//             if(prev != null && prev.val >= root.val)
//             {
//                 return false;
//             }
//             prev = root;
//             root = root.right;


//             while(root!= null)
//             {
//                 stack.push(root);
//                 root = root.left;
//             }

//         }
//         return true;
//     }
// }


class Solution{

    public boolean isValidBST(TreeNode root)
    {
        return isValidBST(root , null , null);
    }


    private boolean isValidBST(TreeNode node , Integer min , Integer max)
    {
        if (node == null)
        {
            return true;
        }


        //node is not in valid range
        if ((min!= null && node.val <=min) ||( max!=null && node.val >=max))
        {
            return false;
        }

        return isValidBST(node.left , min , node.val) &&
                isValidBST(node.right , node.val , max);
    }

}