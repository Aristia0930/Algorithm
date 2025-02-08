now_list=input()
list=list(now_list)
a=list.count("1")
b=list.count("0")

a_count=0
b_count=0

for i in range(a//2):
    list.pop(list.index("1"))

list=list[::-1]
for i in range(b//2):
    list.pop(list.index("0"))


print("".join(list[::-1]))
