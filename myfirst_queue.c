/* Rood Pointjour */
/* Fist Queue Program */

#include<stdio.h>
#include<stdlib.h>
#define MAX 5

int front=0;
int rear=0;

int queue_array[MAX];

void enQueue(int data);
int deQueue();
void display();

void enQueue(int data) {
	
	if(rear<MAX) {
		
		queue_array[rear] = data;
		rear++;
		printf("\n\tAdded to queue");
		
	}
	
	else {
		
		printf("\n\tQueue is FULL!");
	}
}

int deQueue() {
	
	if(front==rear) {
		printf("\n\tQueue is EMPTY!");
		return -999;
	}
	
	else {
		return queue_array[front++];
	}
}

void display() {
	
	int i;
	
	if(front==rear)
		printf("\n\tEmpty!");
		
	else {
		
		for(i=front; i<rear; i++)
			printf(" %d ", queue_array[i]);
			printf("\n");
	}
}

int main() {
	
	int ele;
	int ch;
	
	while(1) {
	printf("\n\tEnter (1) for enQueue, (2) for deQueue, (3) for display, (4) to exit..\n");
	printf("\n\tEnter your choice: ");
	scanf("%d", &ch);
	
	switch(ch) {
		
		case 1:
			printf("\n\tEnter data to be added to queue: ");
			scanf("%d", &ele);
			enQueue(ele);
			display();
			break;
			
		case 2:
			ele = deQueue();
			if(front>=-999)
				printf("\n\tData %d has been deleted.", ele);
				display();
				break;
		case 3:
			display();
			break;
			
		case 4:
			printf("\n\t<EXITING>...");
			exit(0);
			
		default:
			printf("\n\tWrong answer, try again.");
	}
	
}
	
	return 0;
}
