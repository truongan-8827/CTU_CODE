#include <stdio.h>
#include <malloc.h>

typedef int KeyType;
struct Node{
    KeyType Key;
    struct Node *Left,*Right;
};
typedef struct Node* Tree;

Tree Search(KeyType x,Tree Root){
    if(Root==NULL) return NULL;
    else if(Root->Key==x) return Root;
    else if(x>Root->Key)
        return Search(x,Root->Right);
    else if(x<Root->Key)
        return Search(x,Root->Left);
}

void insertNode(KeyType x,Tree *T){
    if((*T)==NULL){
        (*T)=(struct Node*)malloc(sizeof(struct Node));
        (*T)->Key=x;
        (*T)->Left=NULL;
        (*T)->Right=NULL;
    }
    else if(x>(*T)->Key) insertNode(x,&(*T)->Right);
    else if(x<(*T)->Key) insertNode(x,&(*T)->Left);
    else if(x==(*T)->Key) printf("Da ton tai khoa %d",x);
}

//Tim nut con nho nhat ben phai
KeyType DeleteMin(Tree *T){
    if((*T)->Left==NULL){
        KeyType t=(*T)->Key;
        (*T)=(*T)->Right;
        return t;
    }
    else return DeleteMin(&(*T)->Left);
}

//Tim nut con lon nhat ben trai
KeyType DeleteMax(Tree *T){
    if((*T)->Right==NULL){
        KeyType t=(*T)->Key;
        (*T)=(*T)->Left;
        return t;
    }
    else return DeleteMax(&(*T)->Right);
}

void deleteNode(KeyType x,Tree *T){
    if((*T)!=NULL){
        if(x>(*T)->Key) deleteNode(x,&(*T)->Right);
        else if(x<(*T)->Key) deleteNode(x,&(*T)->Left);
        else if(x==(*T)->Key){
            //x co mot nut con ben trai
            if((*T)->Right==NULL) (*T)=(*T)->Left;
            //x co mot nut con ben phai
            else if((*T)->Left==NULL) (*T)=(*T)->Right;
            //x co hai con
            else (*T)->Key=DeleteMin(&(*T)->Right);
        }
    }
    else printf("Khong tim thay x hoac cay rong");
}

void printPath(int x, Tree T){
    if(T!=NULL){
        printf("%d ",T->Key);
        if(x>T->Key) printPath(x,T->Right);
        else if(x<T->Key) printPath(x,T->Left);
        else if(x==T->Key) printf("-> Tim thay\n");
    }
    else printf("-> Khong thay\n");
}

void preOrder(Tree T){
    if(T!=NULL){
        printf("%d ",T->Key);
        if(T->Left!=NULL) preOrder(T->Left);//duyet trai
        if(T->Right!=NULL) preOrder(T->Right);//duyet phai
    }
}

void inOrder(Tree T){
    if(T!=NULL){
        if(T->Left!=NULL) inOrder(T->Left); //duyet nut la nho nhat ben trai dau tien
        printf("%d ",T->Key);
        if(T->Right!=NULL) inOrder(T->Right);
    }
}


Tree getPrevious(int x,Tree T){

}

int main(){
	
Tree T=NULL;
Tree p;
int x;

insertNode(27,&T);
insertNode(12,&T);
insertNode(40,&T);
insertNode(4,&T);
insertNode(20,&T);
insertNode(34,&T);
insertNode(30,&T);
insertNode(50,&T);
x=30;


p = getPrevious(x,T);
if (p==NULL)
   printf("%d khong co nut dung truoc",x);
else printf("Nut dung truoc la %d",p->Key);
}