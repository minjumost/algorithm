import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
m = list(map(int, input().split()))

balloons = deque([(i, m[i-1]) for i in range(1, n+1)])
answer = []

while balloons:
    boom = balloons.popleft()
    answer.append(boom[0])

    if boom[1] > 0:
        balloons.rotate(-(boom[1]-1))
    else:
        balloons.rotate(-boom[1])

        
print(' '.join(map(str, answer)))
