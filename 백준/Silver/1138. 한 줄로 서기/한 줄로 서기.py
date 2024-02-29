import sys

input = sys.stdin.readline

n = int(input())
orders = list(map(int, input().split()))
answer = [0]*n
for index, value in enumerate(orders):

    idx = 0
    for i in range(n):
        if answer[i] == 0:
            idx = i
            break
            
    while value > 0:
        if answer[idx+1] > 0:
            idx += 1
        else:
            idx += 1
            value -= 1
            
    answer[idx] = index+1

answer = list(map(str, answer))
print(' '.join(answer))
