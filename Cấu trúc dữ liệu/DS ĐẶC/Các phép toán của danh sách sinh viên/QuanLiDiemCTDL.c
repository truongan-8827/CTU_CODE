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
    int i,j,p;
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
    if(p>=1 && p<=40){
        int i; 
        for(i=p;i<pL->n;i++){
            pL->A[i-1]=pL->A[i];
            (pL->n)--;
        }
    }
    else    
        printf("vi tri khong hop le");
}