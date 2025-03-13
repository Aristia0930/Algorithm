def find(parent,x):
    if parent[x]!=x:
        parent[x]=find(parent,parent[x])
    return parent[x]

def union(parent,x,y):
    a=find(parent,x)
    b=find(parent,y)

    if a<b:
        parent[b]=a
    else:
        parent[a]=b


t=int(input())

for test in range(1,t+1):
    n,m=map(int,input().split())

    parent=[x for x in range(n+1)]
    for i in range(m):
        a,b=map(int,input().split())
        union(parent,a,b)
    ans=set()
    for i in range(1,n+1):
        ans.add(find(parent,i))
  
    print("#{} {}".format(test,len(ans)))