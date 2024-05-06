import sys
from collections import defaultdict

input= sys.stdin.readline

n, p, q = map(int, input().rstrip().split())
dp = {0:1}

def solution(n):
    if n in dp:
        return dp[n]

    else:
        dp[n] = solution(n//p) + solution(n//q)
        return dp[n]
    
print(solution(n))
