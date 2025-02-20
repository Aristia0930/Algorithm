
for test in range(1,11):
    n,num=input().split()
    array=[]
    temp=-1
    for i in range(int(n)):
        if temp==int(num[i]):
            array.pop()
            if len(array)>0:
                temp=array[-1]
            else:
                temp=-1
        else:
            temp=int(num[i])
            array.append(int(num[i]))
    ans="".join(map(str,array))
    print("#{} {}".format(test,ans))




