arr1=list(input())
arr2=list(input())


len_a=len(arr1)
len_b=len(arr2)

lcs=[[0 for _ in range(len_a+1)] for _ in range(len_b+1)]

for i in range(len_b+1):
    for j in range(len_a+1):
        if i==0 or j==0:
            lcs[i][j]==0
        elif arr2[i-1]==arr1[j-1]:
            lcs[i][j]=lcs[i-1][j-1]+1
        else:
            lcs[i][j]=max(lcs[i-1][j],lcs[i][j-1])

ans =0
for i in range(len_b+1):
    for j in range(len_a+1):
        ans=max(ans,lcs[i][j])
print(ans)
