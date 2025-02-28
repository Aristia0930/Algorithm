from itertools import combinations
def comb(index,k,x):
    global temp1,temp2,ans

    if k==1:

        for i in range(index,n):
            for j in range(n):
                if j+m<=n:
                    for k in range(m):
                        temp2[k] = array[i][j+k]
                ans=max(ans, calculate(temp1,temp2))


    else:
        for i in range(x,n-m+1):
            if i+m<=n:
                for j in range(m):
                    temp1[j]=array[index][i+j]
                if index+1<n:
                    comb(index+1,k+1,i+1)
            else:
                if index+1<n:
                    comb(index+1,k,0)
def calculate (arr1,arr2):

    sum_arr1=0
    sum_arr2=0
    for r in range(1,len(arr1) + 1):
        for comb in combinations(arr1, r):
            sum1 = 0
            if sum(comb)<=c:
                for i in comb:
                    sum1+=i*i
                sum_arr1=max(sum_arr1,sum1)
        for comb in combinations(arr2, r):
            sum1 = 0
            if sum(comb)<=c:
                for i in comb:
                    sum1+=i*i
                sum_arr2 = max(sum_arr2, sum1)
    return sum_arr1+sum_arr2





t=int(input())

for test in range(1,t+1):
    n,m,c=map(int,input().split())

    array=[list(map(int,input().split())) for _ in range(n)]
    ans=-1e9
    temp1=[-1 for _ in range(m)]
    temp2=[-1 for _ in range(m)]

    for i in range(n-1):
        comb(i,0,0)
    print("#{} {}".format(test,ans))

