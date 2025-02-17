from collections import deque


t=int(input())
idx=[0,0,-1,1]
idy=[1,-1,0,0]


def bfs(q,v,t):
    visited=set(q)


    while q:
        dx,dy,c=q.popleft()
        if c>=k:
            break

        if v[dx][dy]<t[dx][dy]:
            t[dx][dy]-=1

            if(dx,dy,c+1) not in visited:
                q.append((dx, dy, c + 1))
                visited.add((dx, dy, c + 1))
            continue

        if v[dx][dy]==t[dx][dy]:
            for i in range(4):
                ix=dx+idx[i]
                iy=dy+idy[i]
                if 0<=ix<300+n and 0<=iy<300+m:
                    if v[ix][iy]==0:
                        v[ix][iy]=v[dx][dy]
                        t[ix][iy]=2*v[dx][dy]
                        q.append((ix,iy,c+1))
                        visited.add((ix,iy,c+1))




        if t[dx][dy]>0:
            t[dx][dy]-=1
            if(dx,dy,c+1) not in visited:
                q.append((dx, dy, c + 1))
                visited.add((dx, dy, c + 1))





for test in range(1,t+1):
    n,m,k=map(int,input().split())
    value=[[0 for _ in range(300+m)] for _ in range(300+n)]
    time = [[0 for _ in range(300 + m)] for _ in range(300 + n)]
    arr=[list(map(int,input().split())) for _ in range(n)]
    q=deque()
    data=[]
    for i in range(150,150+n):
        for j in range(150,150+m):
            value[i][j]=arr[i-150][j-150]
            time[i][j]=2*arr[i-150][j-150]
            if arr[i-150][j-150]!=0:
                data.append([arr[i-150][j-150],i,j])
    data.sort(reverse=True)
    for x,i,j in data:
        q.append((i,j,0))

    bfs(q,value,time)
    sum=0
    for i in range(300+n):
        for j in range(300+m):
            if time[i][j]>0:
                sum+=1
    print("#{} {}".format(test,sum))





