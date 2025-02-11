from collections import deque

for test in range(1,11):
    v,e=map(int,input().split())
    edges =list(map(int,input().split()))

    array=[[] for _ in range(v+1)]
    for i in range(0,len(edges),2):
        u,v=edges[i],edges[i+1]
        array[v].append(u)


    q=deque()

    #0차수인거
    for i in range(1,len(array)):
        if(len(array[i])==0):
            q.append(i)
    rs=[]
    while q:
        x=q.popleft();
        rs.append(x)

        for i in range(1,len(array)):
            if x in array[i]:
                array[i].remove(x)
                if len(array[i])==0:
                    q.append(i)
    print("#{} ".format(test)+" ".join(map(str,rs)))