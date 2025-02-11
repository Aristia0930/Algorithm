def back(g,now,rs):
    if now==1:
        return rs
    for i in range(1,len(g)):
        if now in g[i]:
            rs.append(i)
            back(g,i,rs)
    return rs

def back2 (g,now,rs,afind):
    if now in afind:
        rs=now
        return rs
    for i in range(1,len(g)):
        if now in g[i]:
            return back2(g,i,rs,afind)
    return rs


def find(g,now,count):
    for i in range(len(g[now])):
        count+=1
        count=find(g,g[now][i],count)
    return count


t=int(input())

for test in range(1,t+1):
    v,e,a,b=map(int,input().split())
    array=list(map(int,input().split()))

    graph=[[] for _ in range(v+1)]

    for i in range(0,len(array),2):
        v,u=array[i],array[i+1]
        graph[v].append(u)

    findrs=back2(graph,b,-1,back(graph,a,[]))
    ans=find(graph,findrs,1)
    print("#{} {} {}".format(test,findrs,ans))