import sys
sys.setrecursionlimit(10**9)
def dfs(x,y):
    global result
    if x==0 or y==0:
        return

    if lcs[x-1][y]==lcs[x][y]:
        dfs(x-1,y)
    elif lcs[x][y-1]==lcs[x][y]:
        dfs(x,y-1)
    else:
        result.append(arr2[x-1])
        dfs(x-1,y-1)



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

ans =lcs[len_b][len_a]
result=[]

print(ans)
dfs(len_b,len_a)
for i in range(ans):
    print(result.pop(),end="")