d=int(input())
n,m,k=map(int,input().split())
cnt=n//d+m//d+k//d
cnt = n // d + m // d + k // d
ans = k


n1 =d-n%d
if n % d != 0 and k - n1 >= 0:
    new_cnt = n // d + 1 + m // d + (k - n1) // d
    if cnt == new_cnt:
        ans = max(ans, k - n1)
    elif cnt < new_cnt:
        cnt = new_cnt
        ans = k - n1


m1 =  d-m%d
if m % d != 0 and k - m1 >= 0:
    new_cnt = n // d + (m // d + 1) + (k - m1) // d
    if cnt == new_cnt:
        ans = max(ans, k - m1)
    elif cnt < new_cnt:
        cnt = new_cnt
        ans = k - m1


k1 = n1 + m1
if n % d != 0 and m % d != 0 and k - k1 >= 0:
    new_cnt = n // d + 1 + m // d + 1 + (k - k1) // d
    if cnt == new_cnt:
        ans = max(ans, k - k1)
    elif cnt < new_cnt:
        cnt = new_cnt
        ans = k - k1


print(ans)