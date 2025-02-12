idx=[0,0,-1,1]
idy=[-1,1,0,0]

def dfs(x,y,g,v,k,c,check):
    global count
    if count<c:
        count=c
    for i in range(4):
        nx=x+idx[i]
        ny=y+idy[i]

        if 0<=nx<n and 0<=ny<n and v[nx][ny]==False and g[nx][ny]<g[x][y]:

            v[nx][ny] = True
            dfs(nx, ny, g, v, k, c + 1, check)
            v[nx][ny] = False
        if check==False and 0<=nx<n and 0<=ny<n and v[nx][ny]==False:
            for j in range(1,k+1):
                if(g[nx][ny]-j<g[x][y]):
                    g[nx][ny]-=j
                    v[nx][ny]=True
                    dfs(nx,ny,g,v,k,c+1,True)
                    g[nx][ny]+=j
                    v[nx][ny]=False







t=int(input())

for test in range(1,t+1):
    count=0
    n,k=map(int,input().split())
    array=[list(map(int,input().split())) for _ in range(n)]

    temp=1
    start=[]
    for i in range(n):
        for j in range(n):
            if array[i][j]==temp:
              	start.append([i,j])
            elif array[i][j]>temp:
                temp=array[i][j]
                start=[]
                start.append([i,j])

    for x,y in start:

        vis=[[False for _ in range(n)] for _ in range(n)]
        vis[x][y]=True
        dfs(x,y,array,vis,k,1,False)

    print("#{} {}".format(test,count))
