

t=int(input())

for test in range(1,t+1):
    price=list(map(int,input().split()))
    array=list(map(int,input().split()))

    dp=[0 for _ in range(13)]
    a=0
    if(array[0]>0):
        a=1
    dp[1]=min(price[0]*array[0],price[1]*a)
    for i in range(2,13):
        dp[i]=price[0]*array[i-1]+dp[i-1]

        if array[i-1]>0 and price[1]+dp[i-1]<dp[i]:
            dp[i]=price[1]+dp[i-1]
        if array[i-1]>0 and i>2:
            if dp[i-3]+price[2]<dp[i]:
                dp[i]=dp[i-3]+price[2]
        if array[i-1]>0 and i>1:
            if dp[i-2]+price[2]<dp[i]:
                dp[i]=dp[i-2]+price[2]
        if array[i-1]>0 and price[2]+dp[i-1]<dp[i]:
                dp[i]=dp[i-1]+price[2]
    dp[12]=min(dp[12],price[3])
    print("#{} {}".format(test,dp[12]))