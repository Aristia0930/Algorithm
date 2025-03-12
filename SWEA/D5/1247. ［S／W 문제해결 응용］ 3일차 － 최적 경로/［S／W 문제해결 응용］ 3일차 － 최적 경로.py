
def dist(node,v,rs,count):
    global ans
    x = node[0]
    y = node[1]

    if count ==n :
        end_x=end[0]
        end_y=end[1]

        dist_x = abs(x - end_x)
        dist_y = abs(y - end_y)
        ans=min(ans,rs+dist_y+dist_x)
        return


    for i in range(2,len(arr)):
        if  not  v[i]:
            v[i]=True

            next_x=arr[i][0]
            next_y=arr[i][1]

            dist_x=abs(x-next_x)
            dist_y=abs(y-next_y)
            dist(arr[i],v,rs+dist_y+dist_x,count+1)

            v[i]=False




test=int(input())

for t in range(1,test+1):
    n=int(input())

    array=list(map(int,input().split()))

    arr=[]
    ans=1e9
    v=[False for _ in range(n+2)]
    for i in range(0,len(array),2):
        x=array[i]
        y=array[i+1]
        arr.append((x,y))

    start=arr[0]
    end=arr[1]

    dist(start,v,0,0)

    print("#{} {}".format(t,ans))