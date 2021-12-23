#include <iostream>
#include <vector>
#include <map>
#include <set>
#include <string>

using namespace std;
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

// Time Complexity --> O(n) --> n be the number of elements in a tree
// Space Complexity --> O(n) -->n be the number of elements in a tree
class Solution {
        int index=0;
        HashMap<Integer,Integer>hm=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
            for(int i=0;i<inorder.length;i++){
                hm.put(inorder[i],i);
            }
            return helper(preorder,0,preorder.length-1);
        }

    private TreeNode helper(int []preorder,int start,int end){
            if(start>end){
                return null;
            }
            TreeNode root=new TreeNode(preorder[index++]);
            int i=hm.get(root.val);
            root.left=helper(preorder,start,i-1);
            root.right=helper(preorder,i+1,end);
            return root;
        }
    }

/*int main() {
    string pattern = "abba";
    string s = "dog dog dog dog";
    wordPattern(pattern,s);
    return 0;
}*/
