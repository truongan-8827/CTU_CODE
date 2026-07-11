#include "LibDSLK.c"

int main(){
List L;

		
L=(struct Node*)malloc(sizeof(struct Node));	
L->Next=NULL;
	
append(1, &L);
append(1, &L);
append(10, &L);
append(11, &L);	
append(12, &L);
append(21, &L);
	
printOddNumbers(L);
}