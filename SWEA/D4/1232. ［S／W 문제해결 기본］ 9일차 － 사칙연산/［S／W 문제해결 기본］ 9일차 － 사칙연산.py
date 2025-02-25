from collections import deque
ary=['+','-','*','/']

def post_order(now,tree):
    global ans
    if now<=n and not v[now] and len(tree[now])>0:

        if len(tree[now])>=4:
            left=int(tree[now][2])
            right=int(tree[now][3])
            post_order(int(left),tree)
            post_order(int(right),tree)


            if tree[now][1]=='+':
                    tree[now][1]=int(tree[left][1])+int(tree[right][1])
            elif tree[now][1]=='-':
                    tree[now][1] = int(tree[left][1]) - int(tree[right][1])
            elif tree[now][1]=='*':
                    tree[now][1] = int(tree[left][1]) * int(tree[right][1])
            else:
                tree[now][1] = int(tree[left][1]) // int(tree[right][1])

        v[now]=True







for test in range(1,11):
    n=int(input())
    array=[[] for _ in range(n+1)]
    for i in range(n):
        rs=list(input().split())
        array[int(rs[0])] = rs
    v=[False for _ in range(n+1)]
    post_order(1,array)

    print("#{} {}".format(test,array[1][1]))