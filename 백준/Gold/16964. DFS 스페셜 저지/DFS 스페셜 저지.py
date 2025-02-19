import sys

input = sys.stdin.readline

def dfs(g, v, node):
    v[node] = True
    array.append(node)

    for i in g[node]:
        if not v[i]:
            dfs(g, v, i)


n = int(input())
vited = [False] * (n + 1)
array = []

graph = [[] for _ in range(n + 1)]
for i in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
number = list(map(int, input().split()))  # 주어진 순서

for i in range(n+1):
    graph[i].sort(key=lambda x:number.index(x))



if number[0]==1:

    dfs(graph, vited, 1)
    if number == array:
        print(1)
    else:
        print(0)
else:
    print(0)