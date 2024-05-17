from collections import deque
m, n, k = map(int, input().split())

maps = [[0 for _ in range(n)] for _ in range(m)]

def bfs(i, j):
    q = deque()
    q.append((i, j))
    dt = [(0, 1), (0, -1), (-1, 0), (1, 0)]
    cnt = 1

    while q:
        y, x = q.popleft()
        for dy, dx in dt:
            ny = y+dy
            nx = x+dx

            if (0 <= ny < m) and (0 <= nx < n) and maps[ny][nx] == 0:
                maps[ny][nx] = 1
                q.append((ny, nx))
                cnt += 1

    return cnt

answer = []

for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(y1, y2):
        for j in range(x1, x2):
            maps[i][j] += 1

for i in range(m):
    for j in range(n):
        if maps[i][j] == 0:
            maps[i][j] = 1
            answer.append(bfs(i, j))

print(len(answer))
print(*sorted(answer))


