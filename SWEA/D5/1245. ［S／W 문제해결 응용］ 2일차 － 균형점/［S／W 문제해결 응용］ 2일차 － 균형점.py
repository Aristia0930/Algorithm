

test=int(input())

for t in range(1,test+1):
    n=int(input())

    line = list(map(int, input().split()))

    x = line[:n]
    m = line[n:]
    ans =[]

    for i in range(1,n):
        start=x[i-1]
        end=x[i]

        while (end-start)> (1/10**12):
            mid=(start+end)/2
            left=right=0
            for j in range(n):
                f=m[j]/((mid-x[j])**2)
                if x[j]>mid:
                    right+=f
                else:
                    left+=f



            if left<right: #오른쪽
                end=mid
            else:
                start=mid

        ans.append(mid)

    print("#{} {}".format(t,' '.join('%.10f' %f for f in ans)))

