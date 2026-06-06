#include "AListLib.c"
#include "funtionsHaySuDung.c"


void unionSet(List L1,List L2,List *pL){
    int j;
    makenullList(pL);
    for(j=0;j<L1.Last;j++)
        insertSet(L1.Elements[j],pL);
    for(j=0;j<L2.Last;j++)
        if(!member(L2.Elements[j],*pL))
            insertSet(L2.Elements[j],pL);
}

int main(){
    List L1,L2,L;
int i;

makenullList(&L1);
makenullList(&L2);

for(i=0;i<=5;i++){
    insertSet(2*i, &L1);
}
for(i=10;i>=4;i--){
    insertSet(2*i, &L2);
}

for(i=0;i<L1.Last;i++){
    printf("%d ",L1.Elements[i]);
}
printf("\n");
for(i=0;i<L2.Last;i++){
    printf("%d ",L2.Elements[i]);
}
printf("\n");
unionSet(L1,L2,&L);
for(i=0;i<L.Last;i++){
    printf("%d ",L.Elements[i]);
}
}