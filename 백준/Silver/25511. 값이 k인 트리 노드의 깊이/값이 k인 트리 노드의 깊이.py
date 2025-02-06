n,k=map(int,input().split())

array=[[] for x in range(n)]

for i in range(n-1):
    a,b=map(int,input().split())
    array[b].append(a)

arr=list(map(int,input().split()))


index=arr.index(k)
count=0

while array[index]:
    index=array[index][0]
    count+=1
print(count)