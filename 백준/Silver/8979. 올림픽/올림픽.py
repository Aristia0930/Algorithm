n,k=map(int,input().split())

data=[]

#국가들의 정보 입력
for i in range(n):
    a=list(map(int,input().split()))

    data.append(a)

data.sort(key=lambda x:(-x[1],-x[2],-x[3],x[0]))
find=0
for i in range(n):
    if data[i][0]==k:
        find=i
        break
g=data[find][1]
s=data[find][2]
b=data[find][3]
count=0
for j in range(find):
    check=True

    if data[j][1]>g:
        check=False
    if data[j][2]>s:
        check=False
    if data[j][3]>b:
        check=False
    if check==False:
        count+=1

print(count+1)

