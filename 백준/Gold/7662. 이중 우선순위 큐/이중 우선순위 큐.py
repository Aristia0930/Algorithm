import heapq
import sys

input = sys.stdin.readline
t=int(input())

for test in range(t):
    q=int(input())

    min_heap = []
    max_heap = []
    dic={}
    for i in range(q):
        a,b = input().split()

        if (a=="I"):
            heapq.heappush(min_heap, int(b))

            heapq.heappush(max_heap, -int(b))
            dic[int(b)]=dic.get(int(b),0)+1


        elif dic:


            if int(b)==1:
                while max_heap:

                    value = -heapq.heappop(max_heap)
                    if dic.get(value,0)>0:
                        dic[value]-=1
                        if dic[value]==0:
                            del dic[value]
                        break
            else:
                while min_heap:
                    value = heapq.heappop(min_heap)
                    if dic.get(value,0)>0:
                        dic[value]-=1
                        if dic[value]==0:
                            del dic[value]
                        break

    while max_heap and dic.get(-max_heap[0], 0) == 0:
        heapq.heappop(max_heap)

    while min_heap and dic.get(min_heap[0], 0) == 0:
        heapq.heappop(min_heap)



    if len(max_heap)==0:
        print("EMPTY")
    else:


        print("{} {}".format(-max_heap[0],min_heap[0]))

