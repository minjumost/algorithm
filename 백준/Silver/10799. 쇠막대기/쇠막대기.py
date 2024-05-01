import sys

input = sys.stdin.readline

bars = list(input().rstrip())
answer = 0
stack= []

for i in range(len(bars)):
    if bars[i] == '(':
        stack.append('(')

    else:
        if bars[i-1] == '(':
            stack.pop()
            answer += len(stack)

        else:
            stack.pop()
            answer += 1

print(answer)
