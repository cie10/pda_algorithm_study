
#수열의 크기 
N = int(input())

# 배열 저장 
A = list(map(int, input().split()))

#배열 복사  
dp = A[:]

#점화식 개념 사용
#배열의 첫번째 숫자부터 끝 지점으로 설정  
for i in range(1, N):
    for j in range(i):
        # 끝부분은 앞부분의 모든 수보다 가장 커야함 
        if A[j] < A[i]:
            #점화식처럼 수가 더해짐 
            dp[i] = max(dp[i], dp[j]+A[i])

print(max(dp))