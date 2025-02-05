t=int(input())

for test in range(1,t+1):
    n=int(input())

    type="a"
    count=1
    array=[[0 for _ in range(n)] for _ in range(n)]
    array[0][0]=1
    x=0
    y=0
    while(count<n*n):
        if(type=="a"):
            if(x+1<n and array[y][x+1]==0):
                x+=1
                count+=1
                array[y][x]=count
            else:
                type="b"
        if(type=="b"):
            if(y+1<n and array[y+1][x]==0):
                y+=1
                count+=1
                array[y][x]=count
            else:
                type="c"
        if(type=="c"):
            if(x-1>=0 and array[y][x-1]==0):
                x-=1
                count+=1
                array[y][x]=count
            else:
                type="d"
        if(type=="d"):
            if(y-1>=0 and array[y-1][x]==0):
                y-=1
                count+=1
                array[y][x]=count
            else:
                type="a"
    print("#{}".format(test))
    for i in range(n):
        print(*array[i])
    