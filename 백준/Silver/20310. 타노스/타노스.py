now_list=input()
list=list(now_list)
a=list.count("1")
b=list.count("0")

a_count=0
b_count=0

for i in range(len(list)):
    if a_count<a//2:
        if(list[i]=="1"):
            del list[i]
            a_count+=1


for i in range(len(list)-1,-1,-1):
    if b_count<b//2:
        if(list[i]=="0"):
            del list[i]
            b_count+=1
print("".join(list))