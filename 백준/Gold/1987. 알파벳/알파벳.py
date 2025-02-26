import sys
input = sys.stdin.readline

idx=[-1,1,0,0]
idy=[0,0,-1,1]

def dfs(v,g,x,y,count):
    global ans
    ans=max(ans,count)

    v.add(g[x][y])

    for i in range(4):
        dx=x+idx[i]
        dy=y+idy[i]

        if 0<=dx<r and 0<=dy<c and g[dx][dy] not in v:
            dfs(v,g,dx,dy,count+1)
            v.pop()

r,c=map(int,input().split())
ans=1
array=[list(input().strip()) for _ in range(r)]
v=set(array[0][0])
dfs(v,array,0,0,1)

print(ans)

