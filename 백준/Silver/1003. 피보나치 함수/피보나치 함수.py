dpa=[0]*41
dpb=[0]*41

dpa[0]=1
dpb[0]=0
dpa[1]=0
dpb[1]=1

for i in range(2,41):
    dpa[i]=dpa[i-1]+dpa[i-2]
    dpb[i]=dpb[i-1]+dpb[i-2]


test=int(input())
for i in range(test):
    n=int(input())
    print(dpa[n], end=' ')
    print(dpb[n])