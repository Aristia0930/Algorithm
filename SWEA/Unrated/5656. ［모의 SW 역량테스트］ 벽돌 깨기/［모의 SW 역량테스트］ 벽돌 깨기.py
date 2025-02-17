from collections import deque
import copy
def bfs(g,x,y,m):
    q=deque([(x,y,m)])
    g[x][y]=0

    while q:
        x,y,max=q.popleft()
        for i in range(1,max):
            if 0<=x-i<h and g[x-i][y]!=0:
                q.append((x-i,y,g[x-i][y]))
                g[x-i][y]=0
            if  0<=x+i<h and g[x+i][y]!=0:
                q.append((x+i,y,g[x+i][y]))
                g[x+i][y]=0
            if 0<=y-i<w and g[x][y-i]!=0:
                q.append((x,y-i,g[x][y-i]))
                g[x][y-i]=0
            if  0<=y+i<w and g[x][y+i]!=0:
                q.append((x,y+i,g[x][y+i]))
                g[x][y+i]=0
    for i in range(w):  # 각 열에 대해 처리
            stack = []
            for j in range(h):
                if g[j][i] != 0:  # 0이 아닌 블록들을 스택에 저장
                    stack.append(g[j][i])

            # 모든 블록을 아래쪽부터 채우기
            for j in range(h - len(stack)):  # 위쪽은 0으로 채움
                g[j][i] = 0
            for j in range(h - len(stack), h):  # 스택의 값들을 아래에 채움
                g[j][i] = stack[j - (h - len(stack))]


    return g

def brf(g,n):
    global ans
    if(n==0):
        sum=0
        for i in range(h):
            sum+=g[i].count(0)
        ans=min(ans,w*h-sum)

        return
    for i in range(w):
        for j in range(h):
            if g[j][i]!=0:
                graph=copy.deepcopy(g)
                brf( bfs(graph,j,i,graph[j][i]),n-1)
                break
    sum = 0
    for i in range(h):
        sum += g[i].count(0)
    ans = min(ans, w * h - sum)
    return



t=int(input())

for test in range(1,t+1):
    n,w,h=map(int,input().split())
    array=[list(map(int,input().split())) for _ in range(h)]
    ans=99999999999

    brf(array,n)

    print("#{} {}".format(test,ans))


