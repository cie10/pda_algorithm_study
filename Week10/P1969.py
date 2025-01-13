
def greedy(N, M, dna_list):
        
    #결과 저장리스트
    result_list = []

    for i in range(M):
        # 빈도수 저장 딕셔너리 -> 각 문자의 빈도수   
        frequency = {}
        for j in range(N):
            if dna_list[j][i] in frequency:
                frequency[dna_list[j][i]] += 1
            else:
                frequency[dna_list[j][i]] = 1

        #가장 빈도수 높은 문자 찾기             
        most_common_char = None
        max_count = 0
        for char, count in frequency.items():
            # 사전순으로 배치 해야 함...!!
            if count > max_count or (count == max_count and (most_common_char is None or char < most_common_char)):
                most_common_char = char
                max_count = count

        result_list.append(most_common_char)

    hamming_distance = 0
    for i in range(M):
        for j in range(N):
            if dna_list[j][i] != result_list[i]:
                 hamming_distance += 1

        

    result_str = "".join(result_list)  # 리스트를 문자열로 변환

    return result_str, hamming_distance


#dna 수, 문자열의 길이 
N, M  = map(int, input().split())

#dna 배열 초기화 
dna_list = []
for i in range(N):
    # 공백이 아닌 문자열 하나하나 구분할 때에는 strip() 사용!!!
    row = list(input().strip())
    dna_list.append(row)
    

result, hamming_distance = greedy(N, M, dna_list)
print(result)
print(hamming_distance)
