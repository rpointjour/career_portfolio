/* Stack2 */

#include<stdio.h>
#include<stdlib.h>
#define SIZE 8

int top;
int stack[SIZE];

void PUSH(int element);
int POP();
void display();

void PUSH(int element) {
	
	if(top>=SIZE-1)
		printf("\n\tSTACK IS FULL!");
		
		else
			stack[++top] = element;
}

int POP() {
	
	if(top<0) {
		printf("\n\tSTACK IS EMPTY!");
		return 0;
	}
		else
			return stack[top--];
}

void display() {
	
	int i;
	
	for(i=0; i<=top; i++)
		printf(" %d ", stack[i]);
}

int main() {
	
	int ele;
	int ch;
	top = -1;
	
	while(1) {
		
		printf("\n\tEnter (1) for PUSH, (2) for POP, (3) for display, (4) for exit..Enter your choice: ");
		scanf("%d", &ch);
		
		if(ch==4) {
			
			printf("\n\t<EXITING>...");
			break;
		}
		
		else if(ch==1) {
			
			printf("\n\tEnter an element to be pushed to the stack: ");
			scanf("%d", &ele);
			PUSH(ele);
		}
		
		else if(ch==2) {
			
			ele = POP();
			if(ele!=0) {
				printf("\n\tElement %d has been popped", ele);
			}
		}
		
		else if(ch==3) {
			
			display();
		}
	}
	
	return 0;
}
