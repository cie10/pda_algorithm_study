#DFS와 BFS
from collections import deque

def dfs(graph, v, visited_dfs):
    #시작점 방문 여부 기록하기 
    visited_dfs[v] = True
    #시작점 출력
    print(v, end=' ')
    #작은 번호 우선 방문 
    for neighbor in sorted(graph[v]):
        #방문한 정점이 아닐경우 
        if (visited_dfs[neighbor] == False):
            dfs(graph,neighbor,visited_dfs)

def bfs(graph, start, visited_bfs):
    #시작점 queue에 넣기 
    queue = deque([start])
    visited_bfs[start]=True

    while queue:
        # 시작 노드
        v = queue.popleft()
        visited_bfs[v] = True
        print(v,end=' ')

        for neighbor in sorted(graph[v]):
            if(visited_bfs[neighbor] == False):
                queue.append(neighbor)
                visited_bfs[neighbor] = True

# n은 정점의 개수, m은 간선의 개수, v는 탐색을 시작할 정점의 번호  
n,m,v = map(int, input().split())

#그래프 저장
graph = [[] for _ in range(n+1)] #인접리스트 초기화 
#방문여부 저장 리스트 초기화 
visited_dfs = [False]*(n+1)
visited_bfs = [False]*(n+1)
 
#양방향 연결 저장
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


dfs(graph,v,visited_dfs)
print()
bfs(graph,v,visited_bfs)



