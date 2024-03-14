import sys

input= sys.stdin.readline

n, k = map(int, input().split())
stuff = []
dp = [0 for _ in range(k+1)]

for _ in range(n):
    w, v = map(int, input().split())
    stuff.append([w,v])


for w, v in stuff:
    for i in range(k, w-1, -1):
        dp[i] = max(dp[i], dp[i-w]+v)

print(dp[-1])
