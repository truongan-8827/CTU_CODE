#include "AListLib.c"

Position i,j; 

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
void tachChanLe(List *soLe, List *soChan){
    Position i,p=0;
    for( i=0 ; i < soChan->Last ; i++){
        if(soChan->Elements[i]%2!=0){
            insertList(soChan->Elements[i],++p,soLe);
            deleteList(i+1,soChan);
            i--;
        }
    }
}

int main(){
	List soLe,L;
	nhap(&L);
    xuat(L);
    makenullList(&soLe);
    tachChanLe(&soLe,&L);
	xuat(soLe);
	xuat(L);
}
