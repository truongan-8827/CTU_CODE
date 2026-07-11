#include<stdio.h>
#include<malloc.h>

typedef int ElementType;
struct Node{
    ElementType Element;
    struct Node* Next;
};
typedef struct Node* Position;
typedef Position List;

void makenullList(List *pL){ // đây là một con trỏ cấp 2 (*pL)
    (*pL)=(struct Node*)malloc(sizeof(struct Node));
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
    return (P->Next);
}

Position previous(Position P,List L){
    Position Q=first(L); // hoặc Q=L;
    while(Q->Next!=P)
        Q=Q->Next;
    return Q;
}

ElementType retrieve(Position P, List L){
    if (P->Next!=NULL)
        return P->Next->Element;
    return -1;
}

Position locate(ElementType X,List L){
    Position P=first(L);
    int Found=0;
    while(P->Next!=NULL && !Found)
        if(P->Next->Element==X) Found=1;
        else P=P->Next;
    return P;
}

void insertList(ElementType X, Position P, List *pL){
    Position T;
    T=(struct Node*)malloc(sizeof(struct Node));
    T->Element=X;
    T->Next=P->Next;
    P->Next=T;
}

void deleteList(Position P,List* pL){
    if(P->Next!=NULL){// phair giai phong vung nho can xoa
        Position temp=P->Next;
        P->Next=temp->Next;
        free(temp);
    }
}

Position myLocate(ElementType x, int i, List L){
    Position p=first(L);
    int count=0;
    while(next(p,L)!=NULL && count<i){
        if(retrieve(p,L)==x)   count++;
        if(count<i) p=p->Next;
    }
    return p;
}

void printList(List L){
    Position p=first(L);
    while(p!=endList(L)){
        printf("%d ",retrieve(p,L));
        p=next(p,L);
    }
    printf("\n");
}

int member(ElementType x,List L){
    Position p=L;
    while(p->Next!=NULL){
        if(p->Next->Element==x) return 1;
        p=p->Next;
    }
    return 0;
}

void append(ElementType x,List *pL){
    Position temp=endList(*pL);
    insertList(x,temp,pL);
}

void addFirst(ElementType x,List *pL){
    Position p=first(*pL);
    insertList(x,p,pL);
}

List readSet(){
    List L; 
    makenullList(&L);
    int i,n; scanf("%d",&n);
    for(i=0;i<n;i++){
        int a;
        scanf("%d",&a);
        if(!member(a,L)) addFirst(a,&L);
    }
    return L;
}

float getAvg(List L){
    float S=0.0f;
    int i=0;
    Position p=L;
    if(p->Next==NULL) return -10000.0f;
    else
        while(p->Next!=NULL){
            S+=(p->Next->Element);
            i++;
            p=p->Next;
        }
    return S/i;
}

void readList(List *pL){
    int n,i;
    scanf("%d",&n);
    makenullList(pL);
    Position p=(*pL);
    for(i=0;i<n;i++){
        int a;
        scanf("%d",&a);
       
        Position T;
        T=(struct Node*)malloc(sizeof(struct Node));
        T->Element=a; T->Next=p->Next; p->Next=T;

        p=p->Next;
    }
}

List difference(List L1,List L2){
    List L;
    makenullList(&L);
    Position P=L1;
    while(P->Next!=NULL){
        if(!member(P->Next->Element,L2)) append(P->Next->Element,&L);
        P=P->Next;
    }
    return L;
}

void normalize(List *pL){
    Position p=(*pL),q;
    while(p->Next!=NULL){
        q=p->Next;
        while(q->Next!=NULL){
            if(p->Next->Element==q->Next->Element){
                Position temp=q->Next;
                q->Next=temp->Next;
                free(temp);
            }
            else q=q->Next;
        }
        p=p->Next;
    }
}

void erase(ElementType x,List *pL){
    Position p=locate(x,*pL);
    if(p->Next==NULL) printf("Not found %d\n",x);
    else deleteList(p,pL);
}

List unionSet(List L1,List L2){
    List L;
    makenullList(&L);
    Position p=L1,q=L2;
    while(p->Next!=NULL){
        append(p->Next->Element,&L);
        p=p->Next;
    }
    while(q->Next!=NULL){
        if(!member(q->Next->Element,L)) append(q->Next->Element,&L);
        q=q->Next;
    }
    return L;
}

void copyEvenNumbers(List L1,List *pL2){
    Position p=L1;
    makenullList(pL2);
    while(p->Next!=NULL){
        if((p->Next->Element)%2==0) append(p->Next->Element,pL2);
        p=p->Next;
    }
}

void printOddNumbers(List L){
    Position p=L;
    while(p->Next!=NULL){
        if((p->Next->Element)%2!=0) printf("%d ",p->Next->Element);
        p=p->Next;
    }
    printf("\n");
}

void removeAll(ElementType x,List *pL){
    Position p=locate(x,*pL);
    while(p->Next!=NULL){
        deleteList(p,pL);
        p=locate(x,*pL);
    }
}

List intersection(List L1, List L2){
    List T;
    makenullList(&T);
    Position p=L1;
    while(p->Next!=NULL){
        if(member(p->Next->Element,L2)) append(p->Next->Element,&T);
        p=p->Next;
    }
    return T;
}

void sort(List *pL){
    Position p,q;
    p=*pL;
    while(p->Next!=NULL){
        q=p->Next;
        while(q->Next!=NULL){
            if((p->Next->Element)>(q->Next->Element)){
                int t;
                t=p->Next->Element;
                p->Next->Element=q->Next->Element;
                q->Next->Element=t;
            }
            q=q->Next;
        }
        p=p->Next;
    }
}