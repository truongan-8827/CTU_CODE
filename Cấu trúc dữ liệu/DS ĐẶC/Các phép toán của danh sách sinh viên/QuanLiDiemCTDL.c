struct SinhVien{
   char MSSV[10];
   char HoTen[50];
   float DiemLT, DiemTH1, DiemTH2;
};
typedef struct{
    struct SinhVien A[40];
    int n;
}DanhSach;

//hàm chép những SV không đạt(LT+TH1+TH2<4.0)
DanhSach chepKhongDat(DanhSach L){
    DanhSach l;
    dsRong(l); // đề cho
    int i;
    for(i=0;i<L.n;i++)
        if((L.A[i].DiemLT + L.A[i].DiemTH1 + L.A[i].DiemTH2)<4){
            chenCuoi(L.A[i],&l);// đề cho
        }
    return l;
}

//hàm tìm vị trí sinh viên có mã số x cho trước
#include <string.h>
int tim(char *x,DanhSach L){
    int i;
    for(i=0;i<L.n;i++)
       if(!strcmp(x,L.A[i].MSSV)) return(i+1);
    return (L.n+1);
}

//hàm chèn vào cuối ds SV
void chenCuoi(struct SinhVien s,DanhSach *pL){
    int p=pL->n;
    if(p==40) printf("Loi! Danh sach day!");
    else{
        pL->A[pL->n]=s;
        (pL->n)++;
    }
}

//hàm kiểm tra có rỗng hay không
int ktRong(DanhSach L){
    return L.n==0;
}

//ham hien thi ds sinh vien va diem tong
void hienthi(DanhSach L){
    int i;
    for(i=0;i<L.n;i++)
        printf("%s - %s - %.2f - %.2f - %.2f - %.2f\n",L.A[i].MSSV,L.A[i].HoTen,L.A[i].DiemLT,L.A[i].DiemTH1,L.A[i].DiemTH2,(L.A[i].DiemLT+L.A[i].DiemTH1+L.A[i].DiemTH2));
}

//ham xoa sinh vien tai vi tri p
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

//ham hien thi DS SV DAT(tong>=4.0)
void hienthiDat(DanhSach L){
     int i;
     float tong;
    for(i=0;i<L.n;i++){
        tong=L.A[i].DiemLT+L.A[i].DiemTH1+L.A[i].DiemTH2;
        if(tong>=4.0)
            printf("%s - %s - %.2f - %.2f - %.2f - %.2f\n",L.A[i].MSSV,L.A[i].HoTen,L.A[i].DiemLT,L.A[i].DiemTH1,L.A[i].DiemTH2,tong);
    }
}

//ham tao ds rong
DanhSach dsRong(){
    DanhSach L;
    L.n=0;
    return L;
}

//xoa SV
void xoaSinhVien(char *x,DanhSach *pL){
    int p=tim(x,*pL);
    xoaTai(p,pL);
}

//hàm nhập DS SV, nếu người sau trùng MSSV thì k nhập
DanhSach nhap(){
    DanhSach L;
    L=dsRong();
    int i,n;
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