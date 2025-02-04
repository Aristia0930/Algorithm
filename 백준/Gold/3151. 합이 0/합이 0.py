import sys

input = sys.stdin.readline


def count_zero_sum_triplets(n, array):
    array.sort()
    count = 0

    def two_pointer(start):
        nonlocal count
        left, right = start + 1, n - 1
        target = -array[start]
        max_idx = n

        while left < right:
            sum_val = array[left] + array[right]

            if sum_val < target:
                left += 1
            elif sum_val > target:
                right -= 1
            else:  # sum_val == target
                if array[left] == array[right]:  # 같은 값일 경우
                    count += right - left
                else:
                    if max_idx > right:
                        max_idx = right
                        while max_idx > 0 and array[max_idx - 1] == array[right]:
                            max_idx -= 1

                    count += right - max_idx + 1

                left += 1

    for i in range(n - 2):
        two_pointer(i)

    return count


# 입력 처리
n = int(input())
array = list(map(int, input().split()))

# 결과 출력
print(count_zero_sum_triplets(n, array))