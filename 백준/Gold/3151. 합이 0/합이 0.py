from sys import stdin
# 이분탐색

n = int(stdin.readline())
arr = list(map(int, stdin.readline().split()))
arr.sort()
ans = 0


def solve(s, e, g):
    global ans
    max_idx = n
    while s < e:
        tmp = arr[s] + arr[e]
        if tmp < goal:
            s += 1

        elif tmp == g:
            if arr[s] == arr[e]:
                ans += e - s

            else:
                if max_idx > e:
                    max_idx = e
                    while max_idx >= 0 and arr[max_idx - 1] == arr[e]:
                        max_idx -= 1
                ans += e - max_idx + 1
            s += 1
        else:
            e -= 1


for i in range(n - 2):
    start = i + 1
    end = n - 1
    goal = -arr[i]
    solve(start, end, goal)

print(ans)