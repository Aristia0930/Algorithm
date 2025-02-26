import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
def dfs(v,now,g):


    for i in g[now]:
        if not v[i]:
            v[i]=now
            dfs(v,i,g)


n= int(input())


graph=[[] for _ in range(n+1)]
for i in range(n-1):
    a,b=map(int,input().split())

    graph[a].append(b)
    graph[b].append(a)



# print(graph)

v=[False for _ in range(n+1)]
dfs(v,1,graph)

for i in range(2,n+1):
    print(v[i])