from collections import deque

def shortest_path(N,M,grid):
    #방향 벡터 (상,하 좌,우)
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

    #방문여부 저장배열 
    visited = [[False for _ in range(M)]for _ in range(N)]

    #BFS 큐 초기화 (x, y, 거리)
    queue = deque([(0,0,1)])
    #시작점 방문여부 처리하기 
    visited[0][0] = True

    while(queue):

        #먼저 들어간 좌표부터 꺼내기 
        x,y,dist = queue.popleft()

        #목적지에 도달하였을 때, 
        if x == N-1 and y == M-1:   
            return dist
        
        #4가지 방향 탐색 
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            #좌표가 범위 안에 들어있고, 방문한 적이 없을 때 
            if (0 <= nx < N and 0 <= ny < M and visited[nx][ny] == False):
                #이동할 수 있는 칸일 경우 
                if(grid[nx][ny] == 1):
                    queue.append((nx,ny,dist+1))
                    #방문 여부 기록
                    visited[nx][ny] = True

#N은 행, M은 열
N, M = map(int, input().split())

#map 저장 -> 이차원 배열 저장 
grid = [list(map(int, input().rstrip()))for _ in range(N)]

result = shortest_path(N, M, grid)
print(result)

