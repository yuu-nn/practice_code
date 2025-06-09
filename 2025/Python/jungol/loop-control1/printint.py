N = int(input())

for i in range(1, N // 2 + 2):
    print('*' * i)

for i in range(N // 2, 0, -1):
    print('*' * i)
