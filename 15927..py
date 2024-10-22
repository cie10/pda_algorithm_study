def find_longest_non_palindrome(S):
    l = len(S)
    
    # 1. 모든 문자가 동일한 경우
    if S == S[0] * l:
        return -1

    # 2. 전체 문자열이 팰린드롬인 경우
    if S == S[::-1]:
        return l - 1

    # 3. 전체 문자열이 팰린드롬이 아닌 경우
    return l

# 입력 받기
S = input().strip()

# 결과 출력
print(find_longest_non_palindrome(S))
