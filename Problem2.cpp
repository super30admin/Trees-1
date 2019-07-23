//
// Created by shazm on 7/22/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
//    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
//        TreeNode* Node = new TreeNode(preorder[0]);
//        vector<int>::iterator it = find(inorder.begin(),inorder.end(),preorder[0]); int lower = it-inorder.begin();
//        vector<int>::iterator it2 = find(inorder.begin(),inorder.end(),preorder[0]); int higher = it2-inorder.begin()+1;
//
//        vector<int> leftInorder{inorder.begin(),inorder.begin()+lower}; vector<int> rightInorder{inorder.begin()+higher,inorder.end()};
//        vector<int> leftPreorder{preorder.begin(),preorder.begin()+lower}; vector<int> rightPreorder{preorder.begin()+higher,preorder.end()};
//
////        for(int x: rightPreorder){
////            cout<<x<<endl;
////        }
//
//        Node->left = recurr(leftPreorder,leftInorder);
//        Node->right = recurr(rightPreorder,rightInorder);
//
//        return Node;
//    }

    TreeNode* recurr(vector<int>& preorder, vector<int>& inorder) {
        if(inorder.size()==1){
            TreeNode* node = new TreeNode(inorder[0]);
            return node;
        }else if(inorder.empty()){
            return NULL;
        }

        TreeNode* Node = new TreeNode(preorder[0]);
        vector<int>::iterator it = find(inorder.begin(),inorder.end(),preorder[0]); int lower = it-inorder.begin();
        vector<int>::iterator it2 = find(inorder.begin(),inorder.end(),preorder[0]); int higher = it2-inorder.begin()+1;

        vector<int> leftInorder{inorder.begin(),inorder.begin()+lower}; vector<int> rightInorder{inorder.begin()+higher,inorder.end()};
        vector<int> leftPreorder{preorder.begin(),preorder.begin()+lower}; vector<int> rightPreorder{preorder.begin()+higher,preorder.end()};

        Node->left = recurr(leftPreorder,leftInorder);
        Node->right = recurr(rightPreorder,rightInorder);

        return Node;
    }
};

int main(){
    Solution s;
    vector<int> preorder{3,9,20,15,7};
    vector<int> inorder{9,3,15,20,7};

    TreeNode* node = s.recurr(preorder,inorder);

    cout<<node->left->val<<" "<<node->right->val<<endl;

//    TreeNode* Node = new TreeNode(preorder[0]);
//    vector<int>::iterator it2 = find(inorder.begin(),inorder.end(),preorder[0]); int higher = it2-inorder.begin()+1;
//    cout<<higher<<endl;
//    vector<int> right{inorder.begin()+higher,inorder.end()};
//
//    for(int x : right){
//        cout<<x<<endl;
//    }
//    cout<<it-inorder.begin()<<endl;
    return 0;
}