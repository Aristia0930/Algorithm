from collections import deque
n,m=map(int,input().split())
array=[list(map(int,input().split())) for _ in range(m)]
#m는 x

v=[[-1]*n for _ in range(m)]
q=deque()
for i in range(m):
    for j in range(n):
        if array[i][j]==1:
            q.append((i,j))
            v[i][j]=0
        if array[i][j]==-1:
            v[i][j]=-2

dix=[1,-1,0,0]
diy=[0,0,-1,1]

while q:
    x,y=q.popleft()

    for i in range(4):
        dx=x+dix[i]
        dy=y+diy[i]

        if 0<=dx<m and 0<=dy<n and array[dx][dy]==0:
            v[dx][dy]=v[x][y]+1
            array[dx][dy]=1
            q.append((dx,dy))


ans=-1
for i in range(m):
    for j in range(n):
        if v[i][j]>ans:
            ans=v[i][j]
        if v[i][j]==-1:
            ans=-1
            break
    if ans==-1:
        break



print(ans)