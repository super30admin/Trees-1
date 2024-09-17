import java.util.HashMap;

/**
 *  * Time Complexity: O(n) n-length of the input array
 *  * Space Complexity: O(n)
 */
class Trial{
    static int index;
    static HashMap<Integer,Integer> hmap = new HashMap<>();
    static class TreeNode{
        TreeNode left, right;
        int val;
        TreeNode(int a){
            val = a;
            left = null;
            right = null;
        }
    }
    public static TreeNode bt(int[] pre, int[] in,int st, int end){
        if(st>end || st<0 || end>=in.length || index >= pre.length) return null;

        TreeNode node = new TreeNode(pre[index]);
        int inindex = hmap.get(pre[index++]);
        node.left = bt(pre,in,st,inindex-1);
        node.right = bt(pre,in,inindex+1,end);
        return node;
    }
    public static  void printTree(TreeNode node){
        if(node == null) return;
        printTree(node.left);
        System.out.println(node.val);
        printTree(node.right);
    }
    public static void main(String[] args){
        int[] pre = new int[]{3,9,20,15,7};
        int[] in = new int[]{9,3,15,20,7};
        for(int i=0;i<in.length;i++)
            hmap.put(in[i],i);
        TreeNode node = bt(pre,in,0,in.length-1);

        printTree(node);
    }

}
