#include<stdio.h>
#include<string.h>
#include<malloc.h>

#define Maxlength 80
typedef int ElementType;
typedef struct{
    ElementType Elements[Maxlength];
    int Front,Rear;
}Queue;

void makenullQueue(Queue *pQ){
    pQ->Front=-1;
    pQ->Rear=-1;
}

void deQueue(Queue *pQ){
    if(pQ->Front==-1) printf("loi! hang rong");
    else{
        pQ->Front+=1;
        if(pQ->Front>pQ->Rear) makenullQueue(pQ);
    }
}

int emptyQueue(Queue q){
    return q.Front==-1;
}

int fullQueue(Queue q){
    return ((q.Rear-q.Front+1)==Maxlength);
}

ElementType front(Queue q){
    if(emptyQueue(q)) printf("hang rong");
    else{
        return q.Elements[q.Front];
    }
    return -1;
}

void enQueue(ElementType x,Queue *pQ){
    if(fullQueue(*pQ)) printf("Loi! hang day");
    else{
        if(emptyQueue(*pQ)) pQ->Front=0;
        if(pQ->Rear==Maxlength-1){
            int i;
            for(i=pQ->Front;i<=pQ->Rear;i++){
                pQ->Elements[i-pQ->Front]=pQ->Elements[i];
            }
            pQ->Rear=Maxlength-1-pQ->Front;
            pQ->Front=0;
        }
    }
    pQ->Rear+=1;
    pQ->Elements[pQ->Rear]=x;
}

void nhap(int n, Queue *pQ){
    int i;
    for(i=0;i<n;i++){
        int temp; scanf("%d",&temp);
        enQueue(temp,pQ);
    }
}

int main(){
    char string[400],chuoiso[200];
    fgets(string,400,stdin); if(string[strlen(string)-1]=='\n') string[strlen(string)-1]='\0';
    fgets(chuoiso,100,stdin); if(chuoiso[strlen(chuoiso)-1]=='\n') chuoiso[strlen(chuoiso)-1]='\0';
    Queue q; makenullQueue(&q);
    int i;
    for(i=0;i<strlen(chuoiso);i++) enQueue(chuoiso[i],&q);   
    for(i=0;i<strlen(string);i++){
        string[i]=string[i]+(front(q)-'0');
        enQueue(front(q),&q);
        deQueue(&q);
    }
    printf("%s",string);
}
