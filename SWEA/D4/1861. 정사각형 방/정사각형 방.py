idx=[0,0,1,-1]
idy=[1,-1,0,0]

def back(x,y,count):
    global result
    if ans<=count:
        result=max(count,result)
    for i in range(4):
        nx=x+idx[i]
        ny=y+idy[i]
        if 0<=nx<n and 0<=ny<n and array[nx][ny]==array[x][y]+1:
           back(nx,ny,count+1)







t= int(input())
for test in range(1,t+1):
    n=int(input())
    array=[list(map(int,input().split())) for _ in range(n)]
    ans=1;
    now=[0,0];
    for i in range(n):
        for j in range(n):
            result =0
            back(i,j,1)
            if result>ans:
                ans=result
                now=[i,j]
            elif result==ans:
                if array[i][j]<array[now[0]][now[1]]:
                    now=[i,j]



    print("#{} {} {}".format(test,array[now[0]][now[1]],ans))






