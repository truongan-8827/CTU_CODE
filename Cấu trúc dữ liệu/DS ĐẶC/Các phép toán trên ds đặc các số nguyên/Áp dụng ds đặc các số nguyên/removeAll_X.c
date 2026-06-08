#include "AListLib.c"

Position i; 

void nhap(List *L){
	scanf("%d",&L->Last);
	for(i=0;i<L->Last;i++)
		scanf("%d",&L->Elements[i]);
}
void xuat(List L){
	for(i=0;i<L.Last;i++)
		printf("%d ",L.Elements[i]);
	printf("\n");
}
void deleteX(int x,List *L){
    for(i=0;i<L->Last;i++)
        if(L->Elements[i]==x){
            deleteList(i+1,L);
            i--;
        }
}


int main(){
	List L;
    int x;
	nhap(&L);
    scanf("%d",&x);
	xuat(L);
    deleteX(x,&L);
    xuat(L);
}
