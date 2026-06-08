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
void DS(List L1,List L2,List *L){
	makenullList(L);
	Position p=0;
	for(i=0;i<L1.Last;i++)
	    if(locate(L1.Elements[i],L2)!=(L2.Last+1)){
	        ++p;
            insertList(L1.Elements[i],p,L);	
	    }
}
void gomDanhSach(List *L){
    for ( i = 0; i < L->Last-1; i++)
        for ( j = i+1; j < L->Last; j++)
            if(L->Elements[i]==L->Elements[j]){
                deleteList(j+1,L);
                j--;
            }
                
}

int main(){
	List L1,L2,L;
	nhap(&L1); gomDanhSach(&L1);
	nhap(&L2);  gomDanhSach(&L2);
	DS(L1,L2,&L);
	xuat(L1);
	xuat(L2);
	xuat(L);
}
