import sys
input = sys.stdin.readline

n = int(input())
matrix = []
dp = [[0 for _ in range(n)] for _ in range(n)]
for _ in range(n):
    r, c = map(int, input().split())
    matrix.append([r,c])

for j in range(1, n):
    for i in range(j-1, -1, -1):
        m = sys.maxsize
        for k in range(j-i):
            m = min(m, dp[i][i+k] + dp[i+k+1][j] + matrix[i][0] * matrix[i+k][1] * matrix[j][1])
        dp[i][j] = m

print(dp[0][n-1])
            
