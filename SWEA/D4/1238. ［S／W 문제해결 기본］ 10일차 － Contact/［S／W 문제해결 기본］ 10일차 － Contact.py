from collections import deque

for test in range(1,11):
    n,start=map(int,input().split())

    array=list(map(int,input().split()))

    graph=[[] for _ in range(101)]
    for i in range(0,n,2):
        a,b=array[i],array[i+1]
        if b in graph[a]:
            continue
        graph[a].append(b)
    q=deque()
    q.append([start,1])

    visted=[False for _ in range(101)]
    visted[start] = True
    ans=-1
    index=0
    while q:
        now,count =q.popleft()
        if count>index:
            ans=now
            index=count
        else:
            ans=max(ans,now)

        for j in graph[now]:
            if not visted[j]:
                visted[j] = True
                q.append([j,count+1])
    print("#{} {}".format(test,ans))