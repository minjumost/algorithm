def solution(N, number):
    dp = [set() for _ in range(9)]
    
    if number == N:
        return 1
    
    dp[1].add(N)
    
    for i in range(2, 9):
        dp[i].add(int(str(N) * i))
        
        # 예를들어 N을 3개를 쓴다면, 1개 사용한 결과와 2개 사용한 결과를 더해야함
        # 근데 /연산과 -연산은 순서를 바꾸면 값이 바뀌므로 고려해서
        # 1개 (연산) 2개,  2개 (연산) 1개의 결과를 모두 저장해야함
        for j in range(1, i):
            # dp[j] 하고 dp[i-j]하고 사칙연산한 결과를 넣기
            for m in dp[j]:
                for n in dp[i-j]:
                    dp[i].add(m+n)
                    dp[i].add(m-n)
                    dp[i].add(m*n)
                    if n != 0:
                        dp[i].add(m/n)
                    if number in dp[i]:
                        return i
    return -1