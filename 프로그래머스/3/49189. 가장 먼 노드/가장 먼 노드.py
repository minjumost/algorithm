from collections import deque

def solution(n, edge):
    graph = [[] for _ in range(n+1)]
    visited = [False for _ in range(n+1)]
    distance = [0 for _ in range(n+1)]
    
    for start, end in edge:
        graph[start].append(end)
        graph[end].append(start)
        
    
    def bfs():
        q = deque()
        q.append(1)
        visited[1] = True
        
        while q:
            cur_v = q.popleft()
            
            for adj_v in graph[cur_v]:
                if not visited[adj_v]:
                    visited[adj_v] = True
                    distance[adj_v] = distance[cur_v] + 1
                    q.append(adj_v)
        
    bfs()
    return distance.count(max(distance))