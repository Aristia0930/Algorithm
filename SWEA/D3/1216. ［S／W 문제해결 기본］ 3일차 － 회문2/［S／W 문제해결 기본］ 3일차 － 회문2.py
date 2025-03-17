for test in range(1,11):
    t=int(input())

    array=[list(input()) for _ in range(100)]
    ans=0
    for i in range(100):#세로
        for j in range(100):#가로

            for k in range(100):
                
                #가로
                if j+k<100:
                    word1=array[i][j:j+k+1]
                    word1_1=list(reversed(word1))
                    if word1_1==word1:
                        ans=max(ans,k+1)
                #세로 
                if i+k<100:
                    word2=[]
                    for c in range(k):
                        word2.append(array[i+c][j])
                    word2_1=list(reversed(word2))
                    if word2_1==word2:
                        ans=max(ans,k)
                
 
    print("#{} {}".format(t,ans))