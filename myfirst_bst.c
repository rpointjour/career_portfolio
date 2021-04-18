/* First Binary Tree */

#include<stdio.h>
#include<stdlib.h>

typedef struct treeNode{	// Structure for Binary Tree
	
	int data;
	struct treeNode *left;
	struct treeNode *right;

} treeNode;


treeNode* create_Node(int val);
void inorder(treeNode *current_ptr);
treeNode* insert(treeNode *root, treeNode *element);
int add(treeNode *current_ptr);
int find(treeNode *current_ptr, int val);
int menu();

treeNode* create_Node(int val) {		// Create new node for tree
	
	treeNode *newNode;
	
	newNode = (treeNode*)malloc(sizeof(treeNode));
	
	newNode->data = val;
	newNode->left = NULL;
	newNode->right = NULL;
	
	return newNode;
	
}

void inorder(treeNode *current_ptr) {
	
	if(current_ptr!=NULL) {
		
		inorder(current_ptr->left);
		printf(" %d, ", current_ptr->data);
		inorder(current_ptr->right);
	}
}

treeNode* insert(treeNode *root, treeNode *element) {
	
	if(root==NULL) {
		
		printf("\n\tElement: %d added", element->data);
		return element;
	}
	
	else {	// Insert right
		
		if(element->data > root->data) {
			
			if(root->right!=NULL)
				insert(root->right, element);
				
			else
				root->right = element;
		}
	
	else {	// Insert left
			
			if(root->left!=NULL)
				insert(root->left, element);
				
			else
				root->left = element;
		}
		
		return root;
}

}

int menu() {
	
	int ch;
		
		printf("\n\t Enter(1) to insert into tree, (2) to display tree in order, (3) to exit...");
		printf("\n");
		scanf("%d", &ch);
		
	return ch;
}

int main() {
	
	treeNode *myTree = NULL, *item;
	int done = 0,  ans = 1, val;
	
	ans = menu();
	
	while(ans<4) {
	
	if(ans==1) {
		
		printf("\n\tInsert a value into the tree: ");
		scanf("%d", &val);
		item = create_Node(val);
		
		// Insert
		
		myTree = insert(myTree, item);

	}
	
	if(ans==2) {
		printf("\n\tHere is your tree inorder: \n");
		inorder(myTree);
		printf("\n");
	}
	
	if(ans==3) {
		printf("\n\tExiting..");
		exit(0);
	}
	
	ans = menu();
}
	
	return 0;
}

int add(treeNode *current_ptr) {
	
	if(current_ptr!=NULL)
		return current_ptr->data + add(current_ptr->left) + add(current_ptr->right);
	else
		return 0;
}

int find(treeNode *current_ptr, int val) {
	// Check for node in tree
	if(current_ptr!=NULL) {
		// Found value at root
		if(current_ptr->data==val)
			return 1;
		// Search to the left
		if(val < current_ptr->data)
			return find(current_ptr->left, val);
		// Or to the right	
		else
			return find(current_ptr->right, val);
	}
	
	else
		return 0;
}




	
