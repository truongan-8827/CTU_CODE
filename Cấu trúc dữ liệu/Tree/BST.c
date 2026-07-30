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

Tree searchNode(int x,Tree T){
    if(T!=NULL){
        if(x>T->Key) return searchNode(x,T->Right);
        else if(x<T->Key) return searchNode(x,T->Left);
        else return T;
    }
    else return NULL;
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
        preOrder(T->Left);//duyet trai
        preOrder(T->Right);//duyet phai
    }
}

void inOrder(Tree T){
    if(T!=NULL){
        inOrder(T->Left);
        printf("%d ",T->Key);
        inOrder(T->Right);
    }
}

void posOrder(Tree T){
    if(T!=NULL){
        posOrder(T->Left);
        posOrder(T->Right);
        printf("%d ",T->Key);
    }
}

Tree getPrevious(int x,Tree T){
    Tree pre=NULL,p=T;
    while(p!=NULL){
        if(x<p->Key) p=p->Left;
        else if(x>p->Key){
            pre=p;
            p=p->Right;
        }
        else{
            if(p->Left!=NULL){
                Tree temp=p->Left;
                while(temp->Right!=NULL) temp=temp->Right;
                return temp;
            }
            else return pre;
        }
    }
    return NULL;
}

Tree getNext(int x,Tree T){
    Tree Next=NULL,p=T;
    while(p!=NULL){
        if(x>p->Key) p=p->Right;
        else if(x<p->Key){
            Next=p;
            p=p->Left;
        }
        else{
            if(p->Right!=NULL){
                Tree temp=p->Right;
                while(temp->Left!=NULL) temp=temp->Left;
                return temp;
            }
            else return Next;
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
    int h1,h2;
    if(T!=NULL){
        h1=getHeight(T->Left);
        h2=getHeight(T->Right);
        return (h1>h2) ? (h1+1) : (h2+1);
    }
    else return -1;
}

int hNode(int x,Tree T){
    Tree p=T;
    while(p!=NULL){
        if(x>p->Key) p=p->Right;
        else if(x<p->Key) p=p->Left;
        else return getHeight(p);
    }
    return -1;
}

Tree getParent(int x,Tree T){
    Tree parent=NULL;
    Tree p=T;
    while(p!=NULL){
        if(x>p->Key){
            parent=p;
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

x = 12;
printf("Chieu cao %d la %d",x,hNode(x,T));

}