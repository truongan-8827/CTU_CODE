#include "AListLib.c"

//hàm xóa tất cả phần tử có giá trị x trong danh sách đặc các số nguyên.
void removeAll(int x,List *pL){
    Position p=locate(x,*pL);
    while(p<=(pL->Last)){
        deleteList(p,pL);
        p=locate(x,*pL);
    }
}

//hàm tìm tập hơp hiệu của 2 tập hợp biểu diễn bởi 2 danh sách L1, L2.
void difference(List L1,List L2,List *pL){
    Position i;
    makenullList(pL);
    for(i=0;i<L1.Last;i++)
        if(!member(L1.Elements[i],L2))
             insertSet(L1.Elements[i],pL);
}

//hàm nhập một tập hợp từ bàn phím
void readSet(List *pL){
    List D;
    makenullList(pL);
    makenullList(&D);
    Position i,j;
    scanf("%d",&i);
    D.Last=i;
    for(j=0;j<i;j++)
        scanf("%d",&D.Elements[j]);
    for(j=0;j<i;j++)
        if(!member(D.Elements[j],*pL))
            insertSet(D.Elements[j],pL);
}

//hàm xóa phần tử x xuất hiện đầu tiên trong danh sách đặc các số nguyên.
void erase(int x, List *pL){
    Position p=locate(x,*pL);
    if(p!=(pL->Last+1))
        deleteList(p,pL);
}

//hàm sắp xếp danh sách 
void sort(List *pL){
    Position end=pL->Last;
    Position p=1,q;
    int change;
    while(p<end){
        q=p+1;
        while(q<=end){
            if((pL->Elements[p-1])>(pL->Elements[q-1])){
                change=pL->Elements[p-1];
                pL->Elements[p-1]=pL->Elements[q-1];
                pL->Elements[q-1]=change;
            }
            q++;
        }
        p++;
    }
}

//hàm tìm tập hơp giao của 2 tập hợp biểu diễn bởi 2 danh sách L1, L2.
void intersection(List L1, List L2,List *pL){
    makenullList(pL);
    Position i;
    for(i=0;i<L1.Last;i++)
        if(member(L1.Elements[i],L2))
            insertSet(L1.Elements[i],pL);
}

//hàm nhập danh sách số nguyên từ bàn phím.
void readList(List *pL){
    makenullList(pL);
    Position i;
    scanf("%d",&pL->Last);
    for(i=0;i<pL->Last;i++)
        scanf("%d",&pL->Elements[i]);
}

//hàm thêm phần tử x vào danh sách số nguyên
void insertList(int x,int p,List *pL){
    int q;
    if(pL->Last==Maxlength) printf("DS full");
    else if(p<1 || p>pL->Last+1) printf("vi tri khong hop le"); // nếu thêm vào thì vị trí cần thêm phải <= last+1;
    else{
        //bỏ qua for nếu p=Last+1;
        for(q=pL->Last;q>=p;q--)
            pL->Elements[q]=pL->Elements[q-1];
        pL->Elements[p-1]=x;
        pL->Last++;
    }
}

//hàm cho biết phần tử x có tồn tại trong danh sách các số nguyên hay không
int member(int x, List L){
    int i;
    for(i=0;i<L.Last;i++)
        if(L.Elements[i]==x)  return 1;
    return 0;
}

//hàm khởi tạo một ds rỗng
void makenullList(List *pL){
    pL->Last=0;
}

//hàm tìm vị trí xuất hiện đầu tiên của phần tử x trong danh sách các số nguyên.
int locate(int x,List L){
    int i;
    for (i=0;i<L.Last;i++)
        if(x==L.Elements[i]) return (i+1);
    return (L.Last+1);
}

//hàm chèn một phần tử X vào cuối danh sách chỉ bởi con trỏ pL biểu diễn 1 tập hợp;
void insertSet(int x,List *pL){
    if(fullList(*pL)) printf("DS full");
    else{
        pL->Elements[pL->Last]=x;
        pL->Last++;
    }
}

//hàm tính trung bình cộng giá trị các phần tử trong danh sách.
float getAvg(List L){
    int i;
    float s=0;
    if(L.Last==0) return -10000.0000;
    else
        for(i=0;i<L.Last;i++)
            s+=L.Elements[i];
    return s/(L.Last);
}

//hàm liệt kê các phần tử/ in ra.
void printList(List L){
    int i;
    for (i=0;i<L.Last;i++)
        printf("%d ",L.Elements[i]);
}

//hàm tìm tập hơp hợp của 2 tập hợp biểu diễn bởi 2 danh sách L1, L2.
void unionSet(List L1,List L2,List *pL){
    int j;
    makenullList(pL);
    for(j=0;j<L1.Last;j++)
        insertSet(L1.Elements[j],pL);
    for(j=0;j<L2.Last;j++)
        if(!member(L2.Elements[j],*pL))
            insertSet(L2.Elements[j],pL);
}

//hàm xóa phần tử ở vị trí p trong danh sách
void deleteList(int p,List *pL){
    if(pL->Last==0)     
        printf("DS rong");
    else if(p>pL->Last || p<1)
        printf("Vi tri khong hop le\n");
    else{
        int i;
        for(i=p;i<pL->Last;i++)
            pL->Elements[i-1]=pL->Elements[i];
        (pL->Last)--;
        }  
}

//hàm liệt kê tất cả các phần tử là số lẻ trong danh sách.
void printOddNumbers(List L){
    if(L.Last==0) printf("DS rong");
    else{
        int p;
        for(p=0;p<L.Last;p++)
            if(L.Elements[p]%2!=0) 
                printf("%d ",L.Elements[p]);
    }
}

//hàm chép toàn bộ các số chẵn trong danh sách L1 sang danh sách kết quả.
void copyEvenNumbers(List L1, List *pL2){
    if(L1.Last==0) printf("DS rong, khong the copy Even Numbers");
    else{
        int p;
        for(p=0;p<L1.Last;p++)
            if(L1.Elements[p]%2==0)
                insertSet(L1.Elements[p],pL2);
    }
}

//hàm chép toàn bộ các số chẵn trong danh sách L1 sang danh sách kết quả.
void copyEvenNumbers(List L1, List *pL2){
    makenullList(pL2);
    if(L1.Last==0) printf("DS rong, khong the copy Even Numbers");
    else{
        int j,p=0;
        for(j=0;j<L1.Last;j++)
            if(L1.Elements[j]%2==0)
                insertList(L1.Elements[j],++p,pL2);
    }
}

//hàm chuẩn hóa một danh sách, tức các phần tử trong danh sách nếu trùng nhau thì 
//chỉ giữ lại 1 phần tử, các phần tử khác bị xóa bỏ.
void normalize(List *pL){
    int p=1,q;
    while(p!=(pL->Last+1)){
        q=p+1;
        while(q!=(pL->Last)+1){
            if(pL->Elements[p-1]==pL->Elements[q-1])
                deleteList(q,pL);
            else
                q++;
        }
        p++;
    }
}
