#include<stdio.h>
#include<string.h>
#include<malloc.h>
#include<math.h>

typedef struct{
    char ID[10];
    char Name[50];
    float R1,R2,R3;
}Student;
struct Node{
    Student Element;
    struct Node* Next;
};
typedef struct Node* List;

List getList(){
    List L=(struct Node*)malloc(sizeof(struct Node));
    L->Next=NULL;
    return L;
}

struct Node* locate(char x[], List L){
    struct Node* p=L;
    while(p->Next!=NULL){
        if(!strcmp(x,p->Next->Element.ID)) return p;
        p=p->Next;
    }
    return p;
}

int append(Student s,List *pL);
    struct Node* temp,p;
    while(p->Next!=NULL) p=p->Next;
    temp=(struct Node*)malloc(sizeof(struct Node));
    temp->Element=s;
    temp->Next=p->Next;
    p->Next=temp; 
}