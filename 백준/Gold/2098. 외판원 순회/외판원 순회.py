import sys

input = sys.stdin.readline

n = int(input())
world = [list(map(int, input().split())) for _ in range(n)]
dp = {}

def dfs(now, visited):

    if visited == (1 << n) -1:
        if world[now][0]:
            return world[now][0]
        else:
            return sys.maxsize

    if (now, visited) in dp:
        return dp[(now, visited)]

    min_cost = sys.maxsize
    for i in range(1, n):
        if world[now][i] == 0 or visited & (1 << i):
            continue
        cost = dfs(i, visited | (1 << i)) + world[now][i]
        min_cost = min(cost, min_cost)

    dp[(now, visited)] = min_cost
    return min_cost

print(dfs(0,1))
