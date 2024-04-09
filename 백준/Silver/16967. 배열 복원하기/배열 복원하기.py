import sys

input = sys.stdin.readline

h,w,x,y = map(int, input().rstrip().split(" "))
maps = [list(map(int, input().rstrip().split(" "))) for _ in range(h+x)]


ans = [[0] * w for _ in range(h)]

for i in range(h):
    for j in range(w):
        if i>=x and j>= y:
            ans[i][j] = maps[i][j] - ans[i-x][j-y]
        else:
            ans[i][j] = maps[i][j]

for i in ans:
    print(' '.join(map(str, i)))
