import sys

input = sys.stdin.readline

m, n = map(int, input().split())
maps = [list(map(int, input().split())) for _ in range(m)]

direct = [[-1, 0], [1, 0], [0, -1], [0, 1]]
visited = [[-1 for _ in range(n)] for _ in range(m)]


def dfs(row, col):
    global answer

    if row == m - 1 and col == n - 1:
        return 1

    if visited[row][col] != -1:
        return visited[row][col]

    visited[row][col] = 0
    for dy, dx in direct:
        new_row, new_col = row + dy, col + dx

        if (not 0 <= new_row < m
                or not 0 <= new_col < n
                or maps[new_row][new_col] >= maps[row][col]):
            continue
        visited[row][col] += dfs(new_row, new_col)

    return visited[row][col]


print(dfs(0, 0))
