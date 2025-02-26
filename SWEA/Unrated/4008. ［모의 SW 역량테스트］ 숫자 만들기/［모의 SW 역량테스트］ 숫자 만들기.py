from itertools import permutations

def per(k,val,operator):
    global min_ans,max_ans
    if k==n:
        min_ans=min(min_ans,val)
        max_ans=max(max_ans,val)
    else:
        for i in range(4):
            if operator[i]!=0:
                if i==0:
                    operator[i]-=1
                    per(k+1,val+nums[k],operator)
                    operator[i]+=1
                elif i==1:
                    operator[i]-=1
                    per(k+1,val-nums[k],operator)
                    operator[i]+=1
                elif i==2:
                    operator[i]-=1
                    per(k+1,val*nums[k],operator)
                    operator[i]+=1
                elif i==3:
                    operator[i]-=1
                    per(k+1,int(val/nums[k]),operator)
                    operator[i]+=1








t=int(input())

for test in range(1,t+1):
    n=int(input())
    operators=list(map(int,input().split()))
    # print(len(arr))
    nums=list(map(int,input().split()))
    min_ans=9999999999999999999999
    max_ans=-9999999999999999999999
    per(1,nums[0],operators)
    print("#{} {}".format(test,max_ans-min_ans))