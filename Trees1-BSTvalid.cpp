/* Time Complexity : O(n)
 * Space Complexity : O(n)
 * Did it work on LeetCode : Yes
 */


#include<iostream>
using namespace std;


class Node              // Create a class Node for each node of the Binary Search Tree.
{
public:
    int data;
    Node* left, *right;     // Create left and right pointers to store data.
};

Node* newNode(int data)         // Create a Node type function to get value and create a node in the tree.
{
    Node* new_node = new Node();
    new_node->data = data;
    new_node->left = new_node->right = NULL;        // Set the left and right child as NULL for each new node.
    return(new_node);
}



bool BinarySearchTree(Node* root, Node* left, Node* right) // Boolean function to check if the tree is BST or not.
{

    if (root == NULL)       // If root is NULL then it is BST.
        return true;


    if (left != NULL and root->data <= left->data)    // If Left child is present but root is smaller then false.
        return false;


    if (right != NULL and root->data >= right->data)    // If right child is present but smaller than root then false.
        return false;

}




int main()
{
     Node *root = newNode(5);
    root->left	 = newNode(1);
    root->right	 = newNode(4);
    root->left->left = newNode(NULL);
    root->left->right = newNode(NULL);
    root->left->right = newNode(6);

    if (BinarySearchTree(root,NULL,NULL))
        cout<< "True";
    else
        cout<<"False";

    return 0;
}
