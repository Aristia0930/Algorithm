# 1은 n극 위에서 아래로
# 2 s극 아래에서 위로
from collections import deque

for t in range(10):
    n = int(input())
    array = [list(map(int, input().split())) for _ in range(100)]

    q = deque()
    for i in range(100):
        for j in range(100):
            if array[i][j] != 0:
                q.append([i, j])
    while q:
        x, y = q.popleft()
        if array[x][y] == 1:
            if x + 1 < 100 and array[x + 1][y] == 0:
                array[x][y] = 0
                array[x + 1][y] = 1
                q.append([x + 1, y])
            elif x == 99:
                array[x][y] = 0

        if array[x][y] == 2:
            if x > 0 and array[x - 1][y] == 0:
                array[x][y] = 0
                array[x - 1][y] = 2
                q.append([x - 1, y])
            elif x == 0:
                array[x][y] = 0
    # 체크완료
    count = 0
    for i in range(100):
        for j in range(100):
            if array[i][j] == 1:
                if array[i + 1][j] == 2:
                    count += 1
    print("#{} {}".format(t + 1, count))