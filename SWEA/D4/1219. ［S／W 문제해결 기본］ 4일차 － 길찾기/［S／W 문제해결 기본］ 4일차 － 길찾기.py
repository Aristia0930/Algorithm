def dfs(g,v,s):
    if s==99:
        return 1

    v[s]=True
    for i in g[s]:
        if not v[i]:
            result=dfs(g,v,i)
            if(result==1):
                return 1

    return 0




for test in range(1,11):
    num,edag=map(int,input().split())
    array=list(map(int,input().split()))
    data=[[] for _ in range(100)]
    for i in range(0,len(array),2):
        data[array[i]].append(array[i+1])
    visted=[False]*100

    if dfs(data,visted,0)==1:
        print("#{} 1".format(num))
    else:
        print("#{} 0".format(num))

