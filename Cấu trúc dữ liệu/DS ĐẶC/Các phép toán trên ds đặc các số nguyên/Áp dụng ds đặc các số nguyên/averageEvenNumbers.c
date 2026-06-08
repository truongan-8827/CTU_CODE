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

void averageEvenNumbers(float *s,List *L){
    for(i=0;i<L->Last;i++){
        if(L->Elements[i]%2!=0){
            deleteList(i+1,L);
            i--;
        }
        else
            (*s)+=(L->Elements[i]);
    }
    (*s)/=(L->Last);
}

int main(){
    float s=0;
    List L;
    makenullList(&L);
    readList(&L);
    printList(L);
    averageEvenNumbers(&s,&L);
    printList(L);
    printf("%.3f",s);
}