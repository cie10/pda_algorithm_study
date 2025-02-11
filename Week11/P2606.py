
#시작점은 항상 1
start = 1
count = 0

def worm_dfs(graph, visited_dfs, start):

    visited_dfs[start] = True #시작점 방문 기록하기 
    global count
    for v in graph[start]:
        #방문한 적이 없는 경우 
        if (visited_dfs[v] == False):
            count += 1
            worm_dfs(graph, visited_dfs, v)
    

# n은 컴퓨터 수, m은 네트워크 수 
n = int(input())
m = int(input())

#방문 여부 기록
visited_dfs = [False]*(n+1)

#그래프 저장 
graph = [[] for _ in range(n+1)]

#양방향 연결 
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


worm_dfs(graph, visited_dfs, start)
print(count)