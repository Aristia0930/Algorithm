n, c = map(int, input().split())
array = []
for i in range(n):
    x = int(input())
    array.append(x)
array.sort()
start = 1
end = array[-1]
dis = 0
while (start <= end):
    mid = (start + end) // 2
    now = array[0]
    count=1
    for i in range(1, len(array)):
        if (array[i] >= now + mid):
            now=array[i]
            count+=1

    if count>=c:
        dis=max(dis,mid)
        start=mid+1
    else:
        end=mid-1


print(dis)