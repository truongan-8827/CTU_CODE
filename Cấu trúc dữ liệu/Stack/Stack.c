#define MaxLength 100
typedef char ElementType;
typedef struct {
	ElementType  Elements[MaxLength];
	int          Top_idx; 
} Stack;

void makenullStack(Stack *pS){
	pS->Top_idx=MaxLength;
}
int emptyStack(Stack S)	{ 
	return S.Top_idx==MaxLength; 
}
int full(Stack S) {	
	return S.Top_idx==0;
}
ElementType top(Stack S) {
	return S.Elements[S.Top_idx];
}
void pop(Stack *pS) {
	if (!emptyStack(*pS))
		pS->Top_idx=pS->Top_idx+1;
	else printf("Loi! Ngan xep rong!");
}
void push(ElementType x, Stack *pS) {
	if (full(*pS))
		printf("Loi! Ngan xep day!");
	else{
		pS->Top_idx=pS->Top_idx-1;
		pS->Elements[pS->Top_idx]=x;
	}
}