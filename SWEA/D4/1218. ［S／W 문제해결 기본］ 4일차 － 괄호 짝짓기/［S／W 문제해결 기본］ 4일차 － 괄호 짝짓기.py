


for test in range(1,11):
    n=int(input())
    #( )
    value_1=-1

    #{ }
    value_2 =-1

    #[ ]
    value_3=-1
    array=list(input())

    #<
    value_4=-1


    for i in array:
        if i=='(':
            value_1+=1
        elif i== ')':
            value_1-=1
        elif i=='{':
            value_2+=1
        elif i=='}':
            value_2-=1
        elif i=='[':
            value_3+=1
        elif i==']':
            value_3-=1
        elif i=='<':
            value_4+=1
        elif i=='>':
            value_4-=1

        if value_1<-1 or value_2<-1 or value_3<-1 or value_4<-1:
            break

    if value_1==-1 and value_2==-1 and value_3==-1 and value_4==-1:

        print("#{} 1".format(test))
    else:
        print("#{} 0".format(test))

