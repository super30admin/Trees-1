Time Complexity-O(n)
Space Complexity-O(1) if recursive stack space is not considered or else it will be O(h) where h=height of tree
Did the code run on Leetcode? Yes

#include <iostream>
using namespace std;

struct node  
{ 
    int data; 
    struct node *left; 
    struct node *right; 
};

struct node* newNode(int data) 
{ 
  struct node* node = (struct node*)malloc(sizeof(struct node)); 
  node->data = data; 
  node->left = NULL; 
  node->right = NULL; 
  return(node); 
} 

class Solution {
public:
    bool isValidBST(node* root) {
        return isValidUtil(root, NULL, NULL);
    }
    bool isValidUtil(node* root, node* l,node* r){
        if(root == NULL) return true;
        
        if(l != NULL && root->data >= l->data)
            return false;
        if(r != NULL && root->data <= r->data)
            return false;
        return isValidUtil(root->left,root,r) 
            && isValidUtil(root->right,l,root);
    }
};

int main() {
	struct node *root = newNode(2);
	root->left=newNode(1);
	root->right=newNode(3);
	Solution soln;
	bool result=soln.isValidBST(root);
	cout<<result;
	return 0;
}