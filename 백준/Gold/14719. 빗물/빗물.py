import sys
from collections import deque

input = sys.stdin.readline

h, w = map(int, input().split())
blocks = list(map(int, input().split()))
maps = []
answer = 0

for i in range(h, 0, -1):
    res = []
    for index, block in enumerate(blocks):
        if block == i:
            res.append(1)
            blocks[index] -= 1
        else:
            res.append(0)
    maps.append(res)
        

for map in maps:
    block_location = []
    for i, m in enumerate(map):
        if m == 1:
            block_location.append(i)
    if len(block_location) > 1:
        for j in range(len(block_location)-1):
            answer += block_location[j+1] - block_location[j] - 1
            
            
print(answer)
