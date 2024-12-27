

n = int(input())
k = int(input())
num_list = []
for i in range(n):
    a = int(input())
    num_list.append(a)

answer = []
visited = [0]*n

def dfs(cnt,num):

    #k개를 골랐을 경우 재귀 중단 -> 정답리스트에 추가 
    if cnt == k:
        answer.append(num)
        return
    
    for i in range(n):
        if not visited[i]:
            visited[i] = 1
            dfs(cnt+1, num+str(num_list[i]))
            visited[i] = 0


dfs(0,'')
answer_set = set(answer)
print(len(answer_set))

