#include<stdio.h>
#include<string.h>
#include<malloc.h>

#define Maxlength 200
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
        pQ->Rear+=1;
        pQ->Elements[pQ->Rear]=x; 
    }
}

float Time_avg(int soKH,int soQuay,float tgXL,float tgDen){
    int time=0,tgDi,tgCho,PhucVu;
    int i;
    float QuayRanh[soQuay];// mỗi chỉ số đại diện 1 quầy
    for(i=0;i<soQuay;i++) QuayRanh[i]=0;
    Queue q; makenullQueue(&q);
    //Lưu thời gian đến từng khách hàng.
    for(i=1;i<=soKH;i++) enQueue(i*tgDen,&q);
    //dùng for lồng while, giải thích:dùng for lặp sao cho chia đều vào n quầy(có TH dừng nếu khách hết giữa chừng), while lặp lại đến khi hết
    while(!emptyQueue(q))
        for(i=1;i<=soQuay;i++)
            if(!emptyQueue(q)){// điều kiện hết giữa chừng.
                //nếu thời gian khách hàng đến lớn hơn tg quầy rãnh lấy thời gian bắt đầu phục vụ từ khách hàng
                //còn k thì phải đợi tới quầy rãnh
                tgDen=front(q); deQueue(&q);
                PhucVu=( tgDen > QuayRanh[i-1] )? tgDen : QuayRanh[i-1];

                tgDi= PhucVu + tgXL;
                tgCho= tgDi-tgDen;
                //update tg quầy rãnh
                QuayRanh[i-1]=tgDi;
                time+=tgCho;
            }
    return time/soKH;
}

int main(){
    int soKH,soQuay;
    float tgXuLi,tgDen,X;
    scanf("%d%d%f%f%f",&soKH,&soQuay,&tgXuLi,&tgDen,&X);
    int i=0;
    float temp=0;
    // làm lần lượt từ 1 quầy đến soQuay.
    for(i=1;i<=soQuay;i++){
        temp=Time_avg(soKH, i, tgXuLi, tgDen);
        printf("So quay: %d; Thoi gian cho trung binh: %.1f\n",i,temp);
        //nếu thời gian trung bình nhỏ hơn print và break vòng lặp;
        if(temp<=X) break;
    }
    if(temp<=X)
        printf("=> Sieu thi se mo %d quay\n",i);
    else
        printf("Voi %d quay hien co, khach phai cho it nhat %.1f giay moi duoc phuc vu.\n",soQuay,temp);
}

