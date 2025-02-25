def in_order(now,tree):
    if now<=n and not v[now] and len(tree[now])>0:
        in_order(2*now,tree)
        v[now]=True
        print(*tree[now],end="")
        in_order(2*now+1,tree)


for test in range(1,11):
    n=int(input())

    array=[[] for _ in range(n+1)]
    for i in range(n):
        rs=list(input().split())
        array[int(rs[0])].append(rs[1])
    v=[False for _ in range(n+1)]
    print("#{} ".format(test),end="")
    in_order(1,array)
    print()