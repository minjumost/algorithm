import sys

input = sys.stdin.readline

n = int(input())
inputs = [list(map(str, input().rstrip())) for _ in range(n)]

for key in inputs:
    left = []
    right = []
    
    for k in key:
        if k == '-':
            if left:
                left.pop()

        elif k == '<':
            if left:
                right.append(left.pop())

        elif k == '>':
            if right:
                left.append(right.pop())

        else:
            left.append(k)

    left.extend(reversed(right))

    print(''.join(left))
            
            
                
        
