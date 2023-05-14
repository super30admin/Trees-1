TC:O(N),SC:O(N)

// Getting root from preorder and the left and right node estimates from inorder 

class Solution {
public:
// Using map to store inorder array position
unordered_map<int,int>m;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) 
    {
        
        for(int i=0;i<inorder.size();i++)
        {
            m.insert(make_pair(inorder[i],i));
        }

        return helper(preorder,0,preorder.size()-1,0,inorder.size()-1);
    }

    TreeNode* helper(vector<int>&preorder,int ps,int pe,int ist, int ie)
    {
        if(ps>pe)
        return nullptr;
        // creating new node for each root
        TreeNode* head =new TreeNode(preorder[ps]);
        // checking the index in inoreder array to get estimate of left and right tree sizes   
        int idx=m[preorder[ps]];
        // and based on this claculating the start and end indexes
        head->left=helper(preorder,ps+1,ps+idx-ist,ist,idx-1);
        head->right=helper(preorder,ps+idx-ist+1,pe,idx+1,ie);

        return head;
    }
};