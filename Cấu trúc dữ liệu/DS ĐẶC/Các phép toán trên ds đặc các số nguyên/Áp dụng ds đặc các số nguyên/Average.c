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
double average(List L){
    double sum=0;
    for(i=0 ; i<L.Last ; i++){
        sum+=(double)L.Elements[i];
    }
    return sum/(L.Last);
}

int main(){
	List L;
	nhap(&L);
	xuat(L);
    printf("%.3lf",average(L));
}
