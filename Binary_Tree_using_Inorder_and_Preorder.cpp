Time Complexity-O(n)
Space Complexity-O(n)
Did the code run on Leetcode? Yes

#include <iostream>
#include<vector>
#include<unordered_map>
#define COUNT 10
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

void print_tree(node *root, int space)  
    {  
        if (root == NULL)  
        return;  
 
        space += COUNT;  
        print_tree(root->right, space);  
        cout<<endl;  
        for (int i = COUNT; i < space; i++)  
            cout<<" ";  
        cout<<root->data<<"\n";  
        print_tree(root->left, space); 
    }

class Solution {
public:
       node* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int,int>m;
        int pre=0;
        for(int i=0;i<inorder.size();i++)
        {
            m[inorder[i]]=i;
        }
        return building(inorder,pre,0,inorder.size()-1,preorder,m);
    }
    node* building(vector<int>& inorder,int& pre,int start,int end,vector<int>& preorder,unordered_map<int,int>&m)
    {
        if(start>end)
        {
            return NULL;
        }
        int current=preorder[pre];
        pre++;
        node* a=newNode(current);
        if(start==end)
        {
            return a;
        }
        int index=m[current];
        a->left=building(inorder,pre,start,index-1,preorder,m);
        a->right=building(inorder,pre,index+1,end,preorder,m);
        return a;
    }
};


int main() {
	vector<int>preorder={3,9,20,15,7};
	vector<int>inorder={9,3,15,20,7};
	Solution soln;
	int space=0;
	struct node *root=soln.buildTree(preorder,inorder);
    print_tree(root,0);
	return 0;
}