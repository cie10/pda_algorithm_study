
# 계단의 개수 
n = int(input())
#계단에 적혀 있는 점수목록 
stair = [0]*n
for i in range(n):
    stair[i] = int(input())


if n == 1:
    print(stair[0])
elif n == 2:
    print(stair[0] + stair[1])
else: 

    #dp 배열 초기화
    dp = [0]*n

    #첫 계단의 최대 값은 당연이 첫 계단에 쓰여있는 점수 값 
    dp[0] = stair[0]
    # 두번째 계단의 최대 값은 바로 직전 값 더하기 
    dp[1] = stair[1] + stair[0]
    #세번째부터 생각해봐바
    dp[2] = max(dp[0] + stair[2], stair[1] + stair[2])

    for i in range (3, n):
        dp[i] = max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i])

    result = dp[-1]

    print(result)
