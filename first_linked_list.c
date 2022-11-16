/* Rood Pointjour */
/* First Linked List */

#include <stdio.h>
#include <stdlib.h>
#define SIZE 100
// Declare structure of list
typedef struct Node
{
	int data;
	struct Node *next;
	
} Node;
// Define functions for insertion of nodes
Node* insertFront(Node *head, int data);
Node* insertLast(Node *list, int data);
// Define function to display the list
void printList(Node *list);


// Function to insert node at the front of the list
Node* insertFront(Node *head, int data)
{
	// Create new node
	Node *temp = (Node*)malloc(sizeof(Node)*SIZE);
	// Access the data of the node
	temp->data = data;
	// Point to the head of the list
	temp->next = head;
	// Insert node at the front of the list
	head = temp;
	
	return head;
}

// Function to insert node at the end of the list
Node* insertLast(Node *list, int data)
{
	Node *temp = (Node*)malloc(sizeof(Node)*SIZE);
	
	temp->data = data;
	// Point to the end of the list
	temp->next = NULL;
	// Traverse through the list
	while(list->next)
	{
		list = list->next;
	}
	// Insert node at the end
	list->next = temp;
	
	return list->next;
}

// Function to print the list
void printList(Node *list)
{
	// Print data and traverse through the list while the list is not NULL
	while(list != NULL)
	{
		printf(" %d ->", list->data);
		list = list->next;
	}
}

int main()
{
	// Declare head node and tail node
	Node *head, *tail;
	Node *second, *fourth;
	// Allocate the memory for the second and fourth nodes
	second = (Node*)malloc(sizeof(Node)*SIZE);
	fourth = (Node*)malloc(sizeof(Node)*SIZE);
	// Access and assign the data
	second->data = 0;
	second->next = fourth;
	fourth->data = 1;
	fourth->next = NULL;
	// Insert head at the front of the list
	head = second;
	head = insertFront(head, 12);
	// Insert tail at the end of the list
	tail = fourth;
	insertLast(tail, 1992);
	
	printf("\n");
	printf("*****Linked List***** \n\n");
	// Print the list
	printList(head);
	printf(" NULL \n");
	
	// Free the memory
	free(head);
	
	return 0;
}
