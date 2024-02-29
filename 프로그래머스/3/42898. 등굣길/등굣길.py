from collections import deque

def solution(m, n, puddles):
    maps = [[0 for _ in range(m)] for _ in range(n)]
    for x, y in puddles:
        maps[y-1][x-1] = -1
    
    sour = (0,0)
    dest = (n-1, m-1)
    
    def bfs():    
        q = deque()
        q.append((0, 0))
        maps[0][0] = 1
        
        while q:
            cur_row, cur_col = q.popleft()
            
            for dy, dx in [(1, 0), (0, 1)]:
                new_row = cur_row + dy
                new_col = cur_col + dx
                
                if (
                    new_row >= n
                    or new_col >= m
                    or maps[new_row][new_col] == -1
                ):
                    continue
                if (new_row, new_col) not in q:
                    q.append((new_row, new_col))
                maps[new_row][new_col] += maps[cur_row][cur_col]
                
    bfs()
    return maps[n-1][m-1]%1000000007