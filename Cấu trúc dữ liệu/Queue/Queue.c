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
    int n=1;
    printf("khách thứ %d/n",n);
    int a=120,b=15;
    printf("thời gian đến %d, thời gian đi %d, thời gian chờ %d, thời gian xử lí %d",n*b,n*a+b,n*a-(n-1)*b,n*a+b);
}

