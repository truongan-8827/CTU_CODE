#include <stdio.h>
#include <malloc.h>

typedef int KeyType;
struct Node{
    KeyType Key;
    struct Node *Left,*Right;
};
typedef struct Node* Tree;

Tree initTree(){
    Tree T=NULL;
    return T;
}

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
    else{
    if(x>(*T)->Key) insertNode(x,&(*T)->Right);
    else if(x<(*T)->Key) insertNode(x,&(*T)->Left);
    else printf("Da ton tai khoa %d",x);    
    }
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
        if(T->Left!=NULL) posOrder(T->Left);
        printf("%d ",T->Key);
        if(T->Right!=NULL) posOrder(T->Right);
    }
}

void posOrder(Tree T){
    if(T!=NULL){
        if(T->Left!=NULL) posOrder(T->Left);
        if(T->Right!=NULL) posOrder(T->Right);
        printf("%d ",T->Key);
    }
}

Tree getPrevious(int x,Tree T){
    Tree sp=NULL;
    Tree p=T;
    while(p!=NULL){
        if(x<p->Key){
            p=p->Left;
        }
        else if(x>p->Key){
            sp=p;
            p=p->Right;
        }
        else if(x==p->Key){
            if(p->Left!=NULL){
                Tree temp=p->Left;
                while(temp->Right!=NULL) temp=temp->Right;
                return temp;
            }
            else return sp;
        }
    }
    return NULL;
}

Tree getNext(int x,Tree T){
    Tree sp=NULL;
    Tree p=T;
    while(p!=NULL){
        if(x>p->Key){
            p=p->Right;
        }
        else if(x<p->Key){
            sp=p;
            p=p->Left;
        }
        else{
            if(p->Right!=NULL){
                Tree temp=p->Right;
                while(temp->Left!=NULL) temp=temp->Left;
                return temp;
            }
            else return sp;
        }
    }
    return NULL;
}

Tree rightSibling(int x,Tree T){
    Tree sp=NULL;
    Tree p=T;
    while(p!=NULL){
        if(x<p->Key){
            sp=p->Right;
            p=p->Left;
        }
        else if(x>p->Key){
            if(sp!=NULL) sp=sp->Left;
            p=p->Right;
        }
        else{
            return sp;
        }
    }
    return NULL;
}

int getHeight(Tree T){
    if(T==NULL) return -1;
    int left=getHeight(T->Left);
    int right=getHeight(T->Right);
    if(left>right) return left+1;
    return right+1;
}

int hNode(int x,Tree T){
    Tree p=T;
    while(p!=NULL && p->Key!=x){
        if(x>p->Key){
            p=p->Right;
        }
        else if(x<p->Key){
            p=p->Left;
        }
    }
    return getHeight(p);
}

Tree getParent(int x,Tree T){
    Tree parent=NULL;
    Tree p=T;
    while(p!=NULL){
        if(x>p->Key){
            parent =p;
            p=p->Right;
        }
        else if(x<p->Key){
            parent=p;
            p=p->Left;
        }
        else{
            return parent;
        }
    }
    return NULL;
}

int main(){
Tree T=NULL;
int x;

insertNode(27,&T);
insertNode(12,&T);
insertNode(40,&T);
insertNode(4,&T);
insertNode(20,&T);
insertNode(34,&T);
insertNode(30,&T); 
insertNode(50,&T); 

x = 27;
printf("Chieu cao %d la %d",x,hNode(x,T));
}