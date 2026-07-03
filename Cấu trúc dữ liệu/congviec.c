#include<stdio.h>

void doiCuoi(int d,int s[],int n){
    int i;
    for(i=0;i<n-1;i++) s[i]=s[i+1];
    s[n-1]=d;
    n--;
}

int main(){
    int n; scanf("%d",&n);
    int i,s1[n],s2[n];
    for(i=0;i<n;i++) scanf("%d",&s1[i]);
    for(i=0;i<n;i++) scanf("%d",&s2[i]);
    int count=0,end=0;
    int d=n;
    while(1){
        if(s1[0]!=s2[0]) {
            doiCuoi(s1[0],s1,n-end);
            count++;
        }
        else{// so lan thuc hien duoc dung bang n nen ta ket thuc tai end=n;
            doiCuoi(s1[0],s1,n-end);
            doiCuoi(s2[0],s2,n-end);
            end++;
            if(end==n) break;
        }
    }
    count+=end;
    printf("%d",count);
    printf("\n");

    for(i=0;i<n;i++) printf("%d ",s1[i]);
    printf("\n");
    for(i=0;i<n;i++) printf("%d ",s2[i]);
}