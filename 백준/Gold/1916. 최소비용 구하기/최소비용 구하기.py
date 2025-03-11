import sys
import heapq

input = sys.stdin.readline

n=int(input())

bus=int(input())

array=[[] for _ in range(n+1)]

for i in range(bus):
    a,b,c=map(int,input().split())
    array[a].append((c,b))


start,end=map(int,input().split())


dist=[1e9 for _ in range(n+1)]

q=[]
heapq.heappush(q,(0,start))

dist[start]=0

while q:
    cost,idx=heapq.heappop(q)
    if dist[idx]<cost:
        continue

    for next_cost,next_node in array[idx]:
        new_cost=cost+next_cost
        if dist[next_node]>new_cost:
            dist[next_node]=new_cost
            heapq.heappush(q,(new_cost,next_node))


print(dist[end])
