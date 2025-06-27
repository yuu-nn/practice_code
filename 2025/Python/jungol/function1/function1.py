inputs = input().split()
N = int(inputs[0])
M = int(inputs[1])

def sequences(seq):
    for num in seq:
        print(num, end=' ')
    print()

def dice(n, sum, sequence):
    if n == N:
        if sum == M:
            sequences(sequence)
        return

    for i in range(1, 7):
        dice(n + 1, sum + i, sequence + [i])

dice(0, 0, [])
