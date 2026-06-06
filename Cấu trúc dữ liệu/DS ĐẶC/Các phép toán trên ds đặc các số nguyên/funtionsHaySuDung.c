void printList(List L){
    int i;
    for (i=0;i<L.Last;i++)
        printf("%d ",L.Elements[i]);
}

int member(int x, List L){
    int i;
    for(i=0;i<L.Last;i++)
        if(L.Elements[i]==x)  return 1;
    return 0;
}

void insertSet(int x,List *pL){
    if(fullList(*pL)) printf("DS full");
    else{
        pL->Elements[pL->Last]=x;
        pL->Last++;
    }
}