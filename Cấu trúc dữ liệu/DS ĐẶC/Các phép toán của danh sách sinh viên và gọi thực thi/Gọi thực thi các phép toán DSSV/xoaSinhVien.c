#include <stdio.h>
#include <string.h>

struct SinhVien{
   char MSSV[10];
   char HoTen[50];
   float DiemLT, DiemTH1, DiemTH2;
};
typedef struct{
    struct SinhVien A[40];
    int n;
}DanhSach;

int i;

int tim(char *x,DanhSach L){
    for(i=0;i<L.n;i++)
       if(!strcmp(x,L.A[i].MSSV)) return(i+1);
    return (L.n+1);
}

void chenCuoi(struct SinhVien s,DanhSach *pL){
    int p=pL->n;
    if(p==40) printf("Loi! Danh sach day!");
    else{
        pL->A[pL->n]=s;
        (pL->n)++;
    }
}

DanhSach nhap(){
    DanhSach L;
    L.n=0;
    int n;
    scanf("%d",&n);
    struct SinhVien sv[n];
    for(i=0;i<n;i++){
        getchar();
        fgets(sv[i].MSSV,sizeof(sv[i].MSSV),stdin);     sv[i].MSSV[strlen(sv[i].MSSV)-1]='\0'; 
        fgets(sv[i].HoTen,sizeof(sv[i].HoTen),stdin);   sv[i].HoTen[strlen(sv[i].HoTen)-1]='\0'; 
        scanf("%f%f%f",&sv[i].DiemLT,&sv[i].DiemTH1,&sv[i].DiemTH2); 
    }
    for(i=0;i<n;i++)
        if(tim(sv[i].MSSV,L)==(L.n+1)) 
            chenCuoi(sv[i],&L);
    return L;
}

void hienthi(DanhSach L){
    for(i=0;i<L.n;i++) 
        printf("%s - %s - %.2f - %.2f - %.2f\n",L.A[i].MSSV,L.A[i].HoTen,L.A[i].DiemLT,L.A[i].DiemTH1,L.A[i].DiemTH2);
}

void xoaTai(int p,DanhSach *pL){
    int i; 
    if(p>=1 && p<=pL->n){
        for(i=p-1;i<pL->n;i++)
            pL->A[i]=pL->A[i+1];
        (pL->n)--;
    }
    else    
        printf("vi tri khong hop le");
}


int main(){
    DanhSach L;
    L=nhap();
    hienthi(L);
    char x[10];
    scanf("%s",x);
    int p=tim(x,L);
    if(p==L.n+1)
        printf("Khong tim thay sinh vien %s\n",x);
    else{
        printf("Tim thay sinh vien %s. Thong tin sinh vien:\n",x);
        printf("%s - %s - %.2f - %.2f - %.2f\n",L.A[p-1].MSSV,L.A[p-1].HoTen,L.A[p-1].DiemLT,L.A[p-1].DiemTH1,L.A[p-1].DiemTH2);
        xoaTai(p,&L);
    }
    
}