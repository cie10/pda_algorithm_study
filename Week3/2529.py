
def check(a, b, op):
    if op == '<':
        if a > b :
            return False
    if op == '>':
        if a < b :
            return False
    
    return True

def dfs(cnt, num):
    if cnt == k+1:
        answer.append(num)
        return
    #0~9까지 들어갈 수 있음
    for i in range(10):
        #방문했으면 넘어감 
        if visited[i]:
            continue
        if cnt == 0 or check(num[cnt-1],str(i),sign_list[cnt-1]):
            #방문한 것 표시 
            visited[i] = 1 
            dfs(cnt+1,num+str(i))
            #다시 초기화 
            visited[i] = 0

        

k = int(input())
sign_list = list(input().split())
#정답리스트
answer = []
#방문했는지 확인
visited = [0]*10
dfs(0,'')
