com=int(input())
node=int(input())
visited=[False]*(com+1)
grap=[[] for i in range(com+1)]

for i in range(node):
    a,b=map(int,input().split())
    grap[a].append(b)
    grap[b].append(a)


count=0

def dfs(v,g,r):

    v[r]=True

    for i in g[r]:
        if not v[i]:
        
            dfs(v,g,i)

dfs(visited,grap,1)

for i in visited[1:]:
    if i==True:
        count+=1
print(count-1)