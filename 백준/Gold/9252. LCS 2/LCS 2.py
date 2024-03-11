import sys

input = sys.stdin.readline

a = [0] + list(input().rstrip("\n"))
b = [0] + list(input().rstrip("\n"))
dp = [['' for _ in range(len(b))] for _ in range(len(a))]

for i in range(1, len(a)):
    for j in range(1, len(b)):
        if a[i] == b[j]:
            dp[i][j] = dp[i-1][j-1] + a[i]
        else:
            if len(dp[i][j-1]) > len(dp[i-1][j]):
                dp[i][j] = dp[i][j-1]
            else:
                dp[i][j] = dp[i-1][j]

answer = len(dp[-1][-1])
print(answer)
if answer != 0:
    print(dp[-1][-1])
