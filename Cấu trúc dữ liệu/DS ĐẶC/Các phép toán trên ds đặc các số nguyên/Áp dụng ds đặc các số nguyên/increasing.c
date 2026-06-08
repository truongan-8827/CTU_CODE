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

void increasing(List *L){
    int p,q;
    for(p=0;p<L->Last;p++)
        for(q=p+1;q<L->Last;q++)
            if(L->Elements[p]>L->Elements[q]){
                int temp=L->Elements[p];
                L->Elements[p]=L->Elements[q];
                L->Elements[q]=temp;
            }
}

int main(){
    List L;
    readList(&L); 
    printList(L);
    increasing(&L);
    printList(L);
}