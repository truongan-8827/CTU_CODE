#include "AListLib.c"

int i;

void readList(List *L){
    scanf("%d",&L->Last);
    for(i=0;i<L->Last;i++)
        scanf("%d",&L->Elements[i]);
}

void printList(List L){
    for(i=0;i<L.Last;i++)
        printf("%d ",L.Elements[i]);
    printf("\n");
}

int member(int x,List L){
    if(locate(x,L)!=(L.Last+1)) return 1;
    return 0;
}

void sort(List *L){
    int p,q;
    for(p=0;p<L->Last;p++)
        for(q=p+1;q<L->Last;q++)
            if(L->Elements[p]==L->Elements[q]){
                deleteList(q+1,L);
                q--;
            }
}

void combine(List L1,List L2,List *L){
    for(i=0;i<L1.Last;i++)
        insertList(L1.Elements[i],i+1,L);
    for(i=0;i<L2.Last;i++)
        if(!member(L2.Elements[i],*L)){
            L->Elements[L->Last]=L2.Elements[i];
            (L->Last)++;
        }
}

int main(){
    List L1,L2,L;
    makenullList(&L);
    readList(&L1);  sort(&L1);
    readList(&L2);  sort(&L2);  
    combine(L1,L2,&L);
    printList(L1);
    printList(L2);
    printList(L);
}