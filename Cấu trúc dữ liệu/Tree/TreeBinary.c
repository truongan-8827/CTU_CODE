typedef int TData;
typedef struct Tnode{ 
    TData Data;
    TNode* left,right;
};
typedef TNode* TTree;

void MakeNullTree(TTree *T){
    (*T)=NULL; 
}
int EmptyTree(TTree T){
    return T==NULL;
}

TTree LeftChild(TTree n){ 
    if (n!=NULL) return n->left;
    else return NULL;
 }

 TTree RightChild(TTree n){
    if (n!=NULL) return n->right;
    else return NULL;
}

int IsLeaf(TTree n){ 
    if(n!=NULL)
    return(LeftChild(n)==NULL)&&(RightChild(n)==NULL);
    else return 0;
}

void PreOrder(TTree T){
    printf("%c ",T->Data);
    if (LeftChild(T)!=NULL)
    PreOrder(LeftChild(T));
    if(RightChild(T)!=NULL)
    PreOrder(RightChild(T));
}

void InOrder(TTree T){
    if (LeftChild(T)=!NULL)InOrder(LeftChild(T));
    printf("%c ",T->data);
    if(RightChild(T)!=NULL) InOrder(RightChild(T));
 }

void PosOrder(TTree T){
    if(LeftChild(T)!=NULL) PosOrder(LeftChild(T));
    if(RightChild(T)!=NULL)PosOrder(RightChild(T));
    printf("%c ",T->data);
}

int nb_nodes(TTree T){
    if(EmptyTree(T)) return 0;
    else return 1 + nb_nodes(LeftChild(T))+
    nb_nodes(RightChild(T));
 }

 TTree Create2(Tdata v,TTree l,TTree r){ 
    TTree N;
    N=(TNode*)malloc(sizeof(TNode));
    N->Data=v;
    N->left=l;
    N->right=r;
    return N;
}