def food_comb(k,s,v):
    if k==n//2:
        new_temp=[]

        for i in food_temp:
            new_temp.append(i)
        food_comb2(0,0,v,new_temp)
        return
    else:
        for i in range(s,n+(k-n//2)+1):
            food_temp[k]=i
            v[i]=True
            food_comb(k+1,i+1,v)
            v[i]=False

def food_comb2(k,s,v,temp):
    global food
    if k == n // 2:
        new_temp=[]

        for i in food_temp2:
            new_temp.append(i)
        if tuple(sorted(new_temp)) not in food:
            food.append((tuple(sorted(temp)),tuple(sorted(new_temp))))
        return
    else:
        for i in range(s, n):
            if not v[i]:
                food_temp2[k] = i
                v[i] = True
                food_comb2(k + 1, i + 1, v,temp)
                v[i] = False

def calculate_pair_sum(arr, arr2,array):
    total1 = 0
    total2 = 0
    for i in range(len(arr)-1):
        for j in range(i + 1, len(arr)):
            total1 += array[arr[i]][arr[j]] + array[arr[j]][arr[i]]  # Add both directions
            total2 += array[arr2[i]][arr2[j]] + array[arr2[j]][arr2[i]]
    return abs(total1-total2)


test=int(input())

for t in range(1,test+1):
    n=int(input())

    array=[list(map(int,input().split())) for _ in range(n)]

    food=[]
    food_temp=[ -1 for _ in range(n//2)]
    food_temp2=[ -1 for _ in range(n//2)]
    visted = [False for _ in range(n)]
    food_comb(0,0,visted)
    # print(food)
    ans = 1e9
    # print(food)
    for x, y in food:

        sum = calculate_pair_sum(x,y, array)

        ans = min(ans,sum)
    print("#{} {}".format(t,ans))