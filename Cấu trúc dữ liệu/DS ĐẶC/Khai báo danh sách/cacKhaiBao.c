//viết khai báo cho kiểu dữ liệu dòng văn bản Line (trong đó Số ký tự tối đa = 80) 
//với các thành phần được mô tả như hình trên để là một danh sách đặc các ký tự
#define Maxlength 80
typedef int Position;
typedef struct{
    char Elements[Maxlength];
    Position last;
}Line;

//Giả sử người ta biểu diễn một đa giác bằng một danh sách đặc có tối đa là 100 điểm.
//Hãy viết khai báo cho kiểu dữ liệu Polygon biểu diễn các đa giác theo mô tả trên.
#define Maxpoint 100
typedef struct{
    int x,y;
}coordinates;
typedef struct{
    coordinates Elements[Maxpoint];
    int Point;
}Polygon;

//viết khai báo kiểu DaThuc là một danh sách đặc dùng để lưu trữ 1 đa thức gồm các trường:
//A: mảng các DonThuc (có thể chứa tối đa 100 đơn thức)
//so_luong: số lượng đơn thức có trong đa thức
#define max 100
typedef struct{
    int he_so;
    int bac;
}DonThuc;
struct DaThuc{
    DonThuc A[max];
    int so_luong;
};

//viết khai báo cho kiểu dữ liệu List (trong đó Maxlength=100) 
//với các thành phần được mô tả như hình trên để là một danh sách đặc các số thực float
#define Maxlength 100
typedef float ElementType;
typedef int Position;
typedef struct{
    ElementType Elements[Maxlength];
    Position Last;
}List;   

// Người ta cần quản lý điểm thi môn Cấu trúc dữ liệu của các sinh viên trong lớp (tối đa 40 sinh viên) bằng một danh sách đặc. 
// Mỗi sinh viên (cấu trúc SinhVien) là một phần tử trong danh sách đặc có các thông tin: mã số sinh viên (chuỗi 10 ký tự), 
// họ và tên (chuỗi 50 ký tự), điểm thi lý thuyết, điểm thi thực hành 1, điểm thi thực hành 2.
// Khi biểu diễn bằng danh sách đặc List, người ta dùng một cấu trúc có 2 trường:
//    - Mảng A chứa các sinh viên
//    - Số phần tử trong danh sách: n
#define MaxSV 40
typedef struct{
    char MSSV[10];
    char name[50];
    float LT,TH1,TH2;
}SinhVien;
typedef struct{
    SinhVien A[MaxSV];
    int n;
}List;