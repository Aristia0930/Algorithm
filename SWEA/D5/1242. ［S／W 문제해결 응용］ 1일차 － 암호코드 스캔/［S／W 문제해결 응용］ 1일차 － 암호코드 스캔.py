
dict = {'211': 0, "221": 1, "122": 2, "411": 3, "132": 4, "231": 5, "114": 6, "312": 7, "213": 8, "112": 9}

t = int(input())

for test in range(1, t + 1):

    n, m = map(int, input().split())
    rs=0
    code = list(set([input() for _ in range(n)]))
    ans = ""
    temp=[]
    for i in code:
        result = format(int(i, 16), 'b').lstrip('0')
        result = "0000"+result

        n2=0
        n3=0
        n4=0
        count=0
        check_value=""

        for j in range(len(result)-1,-1,-1):
            if result[j]=='1' and n3==0:
                n4+=1
                check_value+=result[j]
            elif result[j]=='0' and n2==0 and n4!=0:

                n3+=1
                check_value += result[j]
            elif result[j]=='1' and n3!=0:

                n2+=1
                check_value += result[j]
            elif result[j]=='0' and n2!=0:


                        r = min( n2, n3,n4)

                        ans = str(n2//r)+str(n3//r)+str(n4//r)+ans
                        count+=1
                        if count==8:
                            if check_value not in temp :
                                rs_a = 0
                                rs_b = 0
                                temp.append(check_value)

                                for k in range(8):
                                    chunk = ans[k * 3:(k + 1) * 3]


                                    if (k + 1) % 2 == 0:
                                        rs_b += dict[chunk]
                                    else:
                                        rs_a += dict[chunk]

                                if (rs_a * 3 + rs_b) % 10 == 0:
                                    rs+=rs_a+rs_b
                            check_value=""

                            count=0
                        n2=n3=n4=0





    print("#{} {}".format(test,rs))




