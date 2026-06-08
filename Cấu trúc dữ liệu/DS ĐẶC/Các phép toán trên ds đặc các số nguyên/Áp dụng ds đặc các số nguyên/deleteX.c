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

void deleteX(int x,List *L){
    int p=locate(x,*L);
    if(p!=L->Last+1)
        deleteList(p,L);
}

int main(){
    List L;
    int x;
    readList(&L); 
    scanf("%d",&x);
    printList(L);
    deleteX(x,&L);
    printList(L);
}