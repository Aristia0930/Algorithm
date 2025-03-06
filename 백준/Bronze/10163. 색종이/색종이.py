dp=[[111 for _ in range(1001)] for _ in range(1001)]


n=int(input())
for i in range(n):
    array=list(map(int,input().split()))
    x=array[0]
    y=array[1]
    a=array[2]
    b=array[3]

    for j in range(x,x+a):
        for k in range(y,y+b):
            dp[j][k]=i

for i in range(n):
    ans=0
    for j in range(1001):
        a=dp[j].count(i)
        ans+=a
    print(ans)