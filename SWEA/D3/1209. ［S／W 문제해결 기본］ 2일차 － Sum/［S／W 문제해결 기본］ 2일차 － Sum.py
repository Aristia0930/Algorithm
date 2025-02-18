

for test in range(1,11):
    n=int(input())
    arr=[list(map(int,input().split())) for _ in range(100)]
    ans=0
    for i in range(100):
        sum1=0
        sum2=0
        for j in range(100):
            sum1+=arr[i][j]
            sum2+=arr[j][i]
        ans=max(ans,sum1,sum2)

    sum3=0
    sum4=0
    for j in range(100):
        sum3+=arr[0+j][0+j]
        sum4+=arr[99-j][99-j]
    ans=max(sum3,ans,sum4)
    print("#{} {}".format(test,ans))