def solution(triangle):
    for height in range(1, len(triangle)):
        for i, v in enumerate(triangle[height]):
            if i == 0:
                triangle[height][i] += triangle[height-1][0]
            elif i == len(triangle[height]) -1:
                triangle[height][i] += triangle[height-1][-1]
            else:
                triangle[height][i] += max(triangle[height-1][i-1], triangle[height-1][i])
            
    
    return max(triangle[-1])