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
    time, direction = input().split()
    array.append((int(time), direction))

q=deque()
q.append((0,0))
time, v = array.popleft() if array else (float('inf'), None)
now=0
case=0
dx=[0,1,0,-1]
dy=[1,0,-1,0]
while(q):
    x,y=q.popleft()

    nx=x+dx[case]
    ny=y+dy[case]
        #y축 이동
    if(0<=nx<n and 0<=ny<n and (nx,ny) not in q):
        if [nx,ny] in apples:
            q.appendleft((x,y))
            q.appendleft((nx,ny))
            re=apples.index([nx,ny])
            del apples[re]
            now+=1
        else:
            if(len(q)>0):
                q.appendleft((x, y))
                q.pop()

            q.appendleft((nx,ny))
            now += 1
    else:
        now+=1
        break


    if now==time:

        if(case==0):
            if v=="L":
                case=3
            else:
                case=1
        elif case==1:
            if v=="L":
                case=0
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
                case=0
        if array:
            time, v = array.popleft()
        else:
            time = float('inf')

print(now)