

def zsol(n,r,c):
    if n==0:
        return 0;
    else :
        return 2*(r%2)+(c%2)+4*zsol(n-1,int(r/2),int(c/2))


n,r,c,=map(int,input().split())

print(zsol(n,r,c))