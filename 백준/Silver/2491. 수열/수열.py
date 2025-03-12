n=int(input())

array=list(map(int,input().split()))

ans=0

m_index=1
p_index=1
mlength=1
plength=1
for i in range(1,n):
    if array[i]-array[i-1]>=0:

        mlength+=1
    else:
        ans=max(ans,mlength)
        mlength=1


    if array[i-1]-array[i]>=0:
        plength+=1
    else:
        ans=max(ans,plength)
        plength=1


    # print(mlength,plength)
print(max(ans,mlength,plength))




