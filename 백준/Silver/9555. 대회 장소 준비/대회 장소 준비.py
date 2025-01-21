test=int(input())

idx=[0,0,1,-1,1,1,-1,-1]
idy=[1,-1,0,0,-1,1,1,-1]

for t in range(test):
    n,m=map(int,input().split())
    array=[list(map(int,input().split())) for _ in range(n)]

    ans=[]
    for i in range(n):
        for j in range(m):
            if array[i][j]!=-1 and array[i][j] not in ans:

                for k in range(8):
                    ix=i+idx[k]
                    iy=j+idy[k]
                    if 0<=ix<n and 0<=iy<m and array[i][j]==array[ix][iy]:
                        ans.append(array[i][j])
                        break
    print(len(ans))