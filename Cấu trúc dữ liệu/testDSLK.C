#include<stdio.h>

typedef int ElementType;
typedef struct Node{
    ElementType Element;
    struct Node* Next;
};
typedef struct Node* Position;
typedef Position List;

void makenullList(List *pL){ // đây là một con trỏ cấp 2 (*pL)
    (*pL)=(struct Node*)malloc(sizof(struc Node));
    (*pL)->Next=NULL;
}

int emptyList(List L){
    return (L->Next==NULL);
}

Position first(List L){
    return L;
}

Position endList(List L){
    Position P=first(L);
    while(P->Next!=NULL)
        P=P->Next;
    return P;
}

Position next(Position P,List L){
    if(P->Next!=NULL)
        return P->Next;
}

Position previous(Position P,List L){
    Position Q=first(L); // hoặc Q=L;
    while(Q->Next!=P)
        Q=Q->Next;
    return Q;
}

ElementType retrieve(Poistion P,List L){ // lấy element của P->next
    if(P->Next!=NULL)
        return P->Next->Element;
}

Position locate(Element X,List L){
    Poistion P=first(L);
    int Found=0;
    while(P->Next!=NULL && !Found)
        if(P->Next->Element==X) Found=1;
        else P=P->Next;
    return P;
}



int main(){

}