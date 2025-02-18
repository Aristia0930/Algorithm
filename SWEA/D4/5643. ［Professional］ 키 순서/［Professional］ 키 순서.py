def dfs(start,v,g):
    global count
    count+=1
    v[start]=True
    for i in g[start]:
        if v[i]==False:
            dfs(i,v,g)
t=int(input())
for test in range(1,t+1):
    n=int(input())
    
    m=int(input())
    
    arr=[[] for _ in range(n+1)]
    arr2=[[] for _ in range(n+1)]
    
    for i in range(m):
        a,b=map(int,input().split())
        arr2[a].append(b)
        arr[b].append(a)
    
    ans=0
    for i in range(1,n+1):
        count=0
        v=[False for _ in range(n+1)]
        dfs(i,v,arr)
        dfs(i,v,arr2)
    
        if(count==n+1):
            ans+=1
    print("#{} {}".format(test,ans))