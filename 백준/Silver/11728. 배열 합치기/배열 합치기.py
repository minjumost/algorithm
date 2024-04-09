import sys

input = sys.stdin.readline

input()
a = list(map(int, input().rstrip("\n").split()))
b = list(map(int, input().rstrip("\n").split()))
answer = a + b
answer.sort()
print(' '.join(map(str, answer)))
