n = int(input())

num = 0
base = ord('A')
ch = 25

for i in range(n):
    for j in range(n-i):
        print(chr(base+ch), end=' ')
        ch -= 1
    for j in range(i):
        print(num, end=' ')
        num +=1
    print()
