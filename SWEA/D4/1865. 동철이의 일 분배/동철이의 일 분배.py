t=int(input())



def probability(count,rs,v):

    global ans
    if rs<ans:
        return

    if count==n:

        ans=max(ans,rs)
        return
    else:
        for i in range(n):
            if not v[i] and array[count][i]!=0:

                        v[i]=True
                        probability(count+1,rs*(array[count][i]/100),v)
                        v[i]=False




for test in range(1,t+1):
    n=int(input())
    ans=0
    array=[list(map(int,input().split())) for _ in range(n)]
    v=[False for _ in range(n)]
    probability(0,1.00,v)

    result = ans * 100
    print(f"#{test} {result:.6f}")  

