#include <stdio.h>
#include <string.h>
#include <math.h>

#define MaxLength 80
typedef struct{
    char Data[MaxLength]; 
    int n; 
}Line;

//hàm nối một ký tự x vào dòng văn bản.
void appendChar(char x,Line *pL){
    if(pL->n==MaxLength) printf("LINE IS FULL\n");
    else{
        pL->Data[pL->n]=x;
        (pL->n)++;
    }
}

//hàm nối dòng văn bản nguồn vào dòng văn bản đích
void appendLine(Line *pDestination,Line Source){
    if(pDestination->n==MaxLength) printf("LINE IS FULL\n");
    else{
        int i;
        for(i=0;i<Source.n;i++)
            appendChar(Source.Data[i],pDestination);           
    }
}

//hàm hiển thị dòng văn bản lên màn hình.
void printLine(Line L){
    int i;
    for(i=0;i<L.n;i++)
        printf("%c",L.Data[i]);
    printf("\n");
}

//hàm khởi tạo một  dòng văn bản rỗng.
void initLine(Line *pL){
    pL->n=0;
}

//hàm tìm vị trí xuất hiện đầu tiên của ký tự x trong dòng văn bản 
int locate(char x, Line L){
    int i;
    for(i=0;i<L.n;i++)
        if(L.Data[i]==x) return (i+1);
    return (L.n+1);
}

//hàm xóa vị trí tại p trong dòng văn bản
int removeAt(int p, Line *pL){
    int i;
    if(p<1 || p>pL->n) {
        return 0;
    }
    else{
        for(i=p;i<pL->n;i++)
            pL->Data[i-1]=pL->Data[i];
        (pL->n)--;
        return 1;
    }
}

//hàm xóa ký tự ch đầu tiên trong dòng văn bản
int erase(char ch,Line *pL){
    int p;
    p=locate(ch,*pL);
    return removeAt(p,pL);
}

//hàm kiểm tra dòng văn bản có rỗng hay không 
int  isEmpty(Line L){
    return L.n==0;
}

//hàm kiểm tra dòng văn bản có đầy hay không
int isFull(Line L){
    return L.n==MaxLength;
}

//hàm đếm số ký tự viết (alphabet) trong dòng văn ban. 
//Ký tự viết là những ký tự trong khoảng ['a'..'z'] hoặc ['A'..'Z']
int countAlphabet(Line L){
    int i,count=0;
    for(i=0;i<L.n;i++)
        if((L.Data[i]>='a' && L.Data[i]<='z') || (L.Data[i]>='A' && L.Data[i]<='Z'))
            count++;
    return count;
}

//hàm đếm ký tự số trong dòng văn bản.
int countDigits(Line L){
    int i,count=0;
    for(i=0;i<L.n;i++)
        if(L.Data[i]>='0' && L.Data[i]<='9')
            count++;
    return count;
}

int main(){
    
}