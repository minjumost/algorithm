import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

a = list(input().rstrip("\n"))
b = list(input().rstrip("\n"))
dp = [[0 for _ in range(len(b)+1)] for _ in range(len(a)+1)]
path = []

for i in range(1, len(a)+1):
    for j in range(1, len(b)+1):
        if a[i-1] == b[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])


def getLcs(r, c):
    if r == 0 or c == 0:
        return

    if a[r-1] == b[c-1]:
        path.append(a[r-1])
        getLcs(r-1,c-1)

    else:
        if dp[r-1][c] > dp[r][c-1]:
            getLcs(r-1,c)
        else:
            getLcs(r, c-1)


getLcs(len(a), len(b))

print(dp[-1][-1])
for i in range(len(path)-1, -1, -1):
    print(path.pop(i), end = '')
