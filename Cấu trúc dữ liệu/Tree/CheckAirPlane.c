#include <stdio.h>
#include <malloc.h>

struct Node{
    int tTime;
    struct Node *Left, *Right;
};
typedef struct Node* TSet;

TSet initSet(){
    TSet T=NULL;
    return T;
}

int isEmpty(TSet t){
    return t==NULL;
}

int getMin(TSet T){
    if(T!=NULL){
        if(T->Left!=NULL) return getMin(T->Left);
        else return T->tTime;
    }
    else return -9999;
}

int getMax(TSet T){
    if(T!=NULL){
        if(T->Right!=NULL) return getMax(T->Right);
        else return T->tTime;
    }
    else return -9999;
}

int dMin(TSet *T){
    if((*T)->Left==NULL){
        int temp=(*T)->tTime;
        (*T)=(*T)->Right;
        return temp;
    }
    else return dMin(&(*T)->Left);
}
int requestDelete(int t,TSet *T){
    if((*T)!=NULL){
        if(t>(*T)->tTime) return requestDelete(t,&(*T)->Right);
        else if(t<(*T)->tTime) return requestDelete(t,&(*T)->Left);
        else{
            (*T)->tTime=dMin(&(*T)->Right);
            return 1;
        }
    }
    else return 0;
}

//in ra so >t
void printTime(int t,TSet T){
    if(T!=NULL){
        if(t>=T->tTime) printTime(t,T->Right);
        else{
            printTime(t,T->Left);
            printf("%d ",T->tTime);
            printTime(t,T->Right);
        }
    }
}

void registerAt(int t,TSet *T){
    if((*T)!=NULL){
        if(t>(*T)->tTime) registerAt(t,&(*T)->Right);
        else if(t<(*T)->tTime) registerAt(t,&(*T)->Left);
    }
    else{
        TSet temp=(struct Node*)malloc(sizeof(struct Node));
        temp->tTime=t; temp->Left=NULL; temp->Right=NULL;
        (*T)=temp;
    }
}

//DK thoi diem t thoa man t khac (t-k;t+k)
int registerWithin(int t, TSet *T,int k){
    TSet p=(*T),L=NULL,R=NULL,parent=NULL;
    while(p!=NULL){
        parent=p;
        if(t>p->tTime){
            L=p;
            p=p->Right;
        }
        else if(t<p->tTime){
            R=p;
            p=p->Left;
        }
        else return 0;
    }
    if((L!=NULL && (t-L->tTime)<k)  || (R!=NULL && (R->tTime-t)<k)) 
        return 0;
        
    TSet temp=(struct Node*)malloc(sizeof(struct Node));
    temp->tTime=t; temp->Left=NULL; temp->Right=NULL;
    if(parent==NULL) (*T)=temp;
    else if(t>parent->tTime) parent->Right=temp;
    else parent->Left=temp;
    return 1;
}

//tra ve thoi diem truoc t (t co the khong co trong cay)
int getPrevious(int t,TSet T){
    TSet p=T,O=NULL;
    while(p!=NULL){
        if(t>p->tTime){
            O=p;
            p=p->Right;
        }
        else if(t<p->tTime) p=p->Left;
        else break;
    }
    if(p!=NULL){//t nam trong T
        if(p->Left!=NULL){
            TSet temp=p->Left;
            while(temp->Right!=NULL) temp=temp->Right;
            return temp->tTime;
        }
    }
    if(O!=NULL) return O->tTime;
    return -9999;
}