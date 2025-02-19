idx=[0,0,-1,1]
idy=[1,-1,0,0]


def dfs(g,v,x,y):
    v[x][y]=True

    for i in range(4):
        dx=x+idx[i]
        dy=y+idy[i]

        if 0<=dx<16 and 0<=dy<16 and not v[dx][dy] and g[dx][dy]=='0' or g[dx][dy]=='3':
            dfs(g,v,dx,dy)


for test in range(1,11):
    n=int(input())
    array=[list(input()) for _ in range(16)]
    start_x=-1
    start_y=-1

    end_x=-1
    end_y=-1
    for i in range(16):
        for j in range(16):
            if array[i][j]=='2':
                start_x=i
                start_y=j
            if array[i][j]=='3':
                end_x=i
                end_y=j

    visted=[[False for _ in range(16)] for _ in range(16)]

    dfs(array,visted,start_x,start_y)

    if visted[end_x][end_y]:
        print("#{} 1".format(n))
    else:
        print("#{} 0".format(n))