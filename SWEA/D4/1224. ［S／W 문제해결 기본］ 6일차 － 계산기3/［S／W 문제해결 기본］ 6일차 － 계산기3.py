from collections import deque

isp={'(':0,'+':1,'-':1,'*':2,'/':2,')':3} # 값이 들어갈때 우선순위

icp={'(':3,'+':2,'-':2,'*':1,'/':1,')':4} #값이 들어가고 난후 우선순위

a=set(['(',')','+','-','*','/'])
for test in range(1,11):
    n=int(input())
    array=list(input())
    postfix=[]
    ans=[]
    q=deque(array)
    while q:
        x=q.popleft()

        if x in a:
            if x==')':
                while postfix[-1]!='(':
                    y=postfix.pop()
                    ans.append(y)
                postfix.pop()
            else:
                if len(postfix)==0:
                    postfix.append(x)
                elif isp[postfix[-1]]<isp[x]:
                    postfix.append(x)
                elif x=='(':
                    postfix.append(x)
                else:
                        y=postfix.pop()
                        postfix.append(x)
                        ans.append(y)
        else:
            ans.append(x)
    ans2=[]

    for i in ans:
        if i not in a:
            ans2.append(i)
        else:
            x=ans2.pop()
            y=ans2.pop()
            calculate=0
            if i=='-':
                calculate=int(y)-int(x)
            elif i=='+':
                calculate=int(y)+int(x)
            elif i=='*':
                calculate=int(y)*int(x)
            else:
                calculate=int(y)//int(x)
            ans2.append(calculate)

    print("#{} {}".format(test,*ans2))