import sys
from collections import deque

input = sys.stdin.readline

n=int(input())
k=int(input())

apples=[]
for i in range(k):
    a,b=map(int,input().split())
    apples.append([a-1,b-1])
array=deque()
l =int(input())
for i in range(l):
    array.append(input().split())

q=deque()
q.append((0,0))
time=int(array[0][0])
v="D"
change=0
now=0
case=1
while(q):
    x,y=q.popleft()
        #y축 이동
    if(case==3 and 0<=y-1 and (x,y-1) not in q):
        if [x,y-1] in apples:
            q.appendleft((x,y))
            q.appendleft((x,y-1))
            re=apples.index([x,y-1])
            del apples[re]
            now+=1
        else:
            if(len(q)>0):
                q.appendleft((x, y))
                q.pop()

            q.appendleft((x,y-1))
            now += 1
    elif(case==1 and y+1<n and (x,y+1) not in q):
            if [x,y+1] in apples:
                q.appendleft((x, y))
                q.appendleft((x,y+1))
                re=apples.index([x,y+1])
                del apples[re]
                now += 1
            else:
                if(len(q)>0):
                    q.appendleft((x, y))
                    q.pop()
                q.appendleft((x,y+1))
                now += 1
    elif(case==4 and 0<=x-1 and (x-1,y) not in q):
        if [x-1,y] in apples:
            q.appendleft((x, y))
            q.appendleft((x-1,y))
            re=apples.index([x-1,y])
            del apples[re]
            now += 1
        else:
            if(len(q)>0):
                q.appendleft((x, y))
                q.pop()
            q.appendleft((x-1,y))
            now += 1

    elif(case==2 and x+1<n and (x+1,y) not in q ):
        if [x+1,y] in apples:
            q.appendleft((x, y))
            q.appendleft((x+1,y))
            re=apples.index([x+1,y])
            del apples[re]
            now += 1
        else:
            if(len(q)>0):
                q.appendleft((x, y))
                q.pop()
            q.appendleft((x+1,y))
            now += 1
    else:
        now+=1
        break


    if now==int(time):
        time,v=array.popleft()
        if(len(array)>0):
            time=array[0][0]
        else:
            time=5000000

        if(case==1):
            if v=="L":
                case=4
            else:
                case=2
        elif case==2:
            if v=="L":
                case=1
            else:
                case=3
        elif case==3:
            if v=="L":
                case=2
            else:
                case=4
        elif case==4:
            if v=="L":
                case=3
            else:
                case=1

print(now)