n,s=map(int,input().split())

data=list(map(int,input().split()))

count=0
sum=0
end=0
slen=[]
now=0

for start in range(n):

    while sum<s and end<n:
        sum+=data[end]
        now+=1
        end+=1

    if sum>=s:
        count+=1
        slen.append(now)
        
        

    sum-=data[start] 
    now-=1   

slen.sort() 
if count>0:
    print(slen[0])

    
else:
    print(0)