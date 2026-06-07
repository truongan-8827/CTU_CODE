#include "AListLib.c"
#include "funtionsHaySuDung.c"

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


int main(){
/////////////////
   List L;
int i;
L.Last = 6;
L.Elements[0] = 0;
L.Elements[1] = 14;
L.Elements[2] = 10;
L.Elements[3] = -100;
L.Elements[4] = 14;
L.Elements[5] = 14;
normalize(&L);
for(i=0;i<L.Last;i++)
{
    printf("%d ",L.Elements[i]);
}
/////////////////
}