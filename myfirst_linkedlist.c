/* First Linked List */

#include<stdio.h>
#include<stdlib.h>
#define size 10

typedef struct node {
	
	int info;
	node *prev, next;
}node;

node *root;

void insertList(int item);


void insertList(int item) {
	
	node *temp;
	
	temp = (node*)malloc(sizeof(node)*size);
	
	temp->info = item;
	temp->next = NULL;
	temp->prev = NULL;
	
	if(root==NULL || root->info>=item) {
		
		temp->next = root;
		temp->prev = NULL;
		root = temp;
		if(temp->next!=NULL)
			temp->next->prev = temp;
		
		
	}
}
