
dict = {'3211': 0, "2221": 1, "2122": 2, "1411": 3, "1132": 4, "1231": 5, "1114": 6, "1312": 7, "1213": 8, "3112": 9}

t = int(input())

for test in range(1, t + 1):

    n, m = map(int, input().split())


    array = [list(input()) for _ in range(n)]

    ans = ""

    for i in range(n):
        count = 0
        check_value = 0
        check = False
        main_count = 0

        for j in range(m - 1, -1, -1):
            if main_count <= 56:
                if array[i][j] == "1" and not check:
                    main_count += 1
                    check = True
                    check_value = "1"

                if check:
                    if check_value == array[i][j]:
                        main_count += 1
                        count += 1
                    else:

                        ans = str(count) + ans
                        count = 1
                        main_count += 1
                        check_value = array[i][j]

        if check:
            ans = str(count) + ans
            break


    if ans:
        rs_a = 0
        rs_b = 0


        for i in range(8):
            chunk = ans[i * 4:(i + 1) * 4]


            if (i + 1) % 2 == 0:
                    rs_b += dict[chunk]
            else:
                    rs_a += dict[chunk]



        if (rs_a*3+rs_b)%10==0:
            print("#{} {}".format(test,rs_a + rs_b))
        else:
            print("#{} {}".format(test,0))