import sys

input = sys.stdin.readline

n = int(input())
stairs = [0] + [int(input()) for _ in range(n)]
dp = [0 for _ in range(n+1)]

def solution(n: int):
    if n == 1:
        print(sum(stairs))
        return

    elif n == 2:
        print(sum(stairs))
        return

    dp[1], dp[2] = stairs[1], stairs[1] + stairs[2]

    for i in range(3, n+1):
        # 한칸 건너뛰어서 도착할 경우
        skip = stairs[i] + dp[i-2]
        # 한칸 전에서 도착할 경우
        countinious = stairs[i] + stairs[i-1] + dp[i-3]

        dp[i] = max(skip, countinious)

    print(dp[n])
    
solution(n)
