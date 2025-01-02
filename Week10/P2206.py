from collections import deque

# nxm 행렬
n, m = map(int,input().split())

#map 저장 -> 이차원 배열 저장 
grid = [list(map(int, input().rstrip()))for _ in range(n)]

def shortest_path_with_wall(n ,m ,grid):
    #방향 벡터 (상, 하, 좌, 우)
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    #방문여부와 벽을 부쉈는지 여부를 저장하기 위한 3차원 배열
    #0 -> 벽을 부수지 않고 방문!, 1 -> 벽을 부수고 방문!
    visited = [[[False]*2 for _ in range(m)] for _ in range(n)]

    #BFS 큐 초기화 (x, y, 거리, 벽 부순 여부)
    queue = deque([(0,0,1,0)])
    visited[0][0][0] = True

    while queue: 
        
        x, y, dist, wall_broken = queue.popleft()

        #목적지에 도달하면 거리를 반환 
        if x == n-1 and y == m-1:
            return dist

        for i in range(4):
            #4가지 방향으로 이동 
            nx = x + dx[i]
            ny = y + dy[i]

            #맵의 범위에서 벗어나지 않아야 됨
            if 0 <= nx < n and 0 <= ny < m: 
                #벽이 없는 경우에 이동한다. 또한 방문한 적이 없는 좌표일 경우 이동 
                if grid[nx][ny] == 0 and visited[nx][ny][wall_broken]== False: 
                    #방문 여부 기록하기 
                    visited[nx][ny][wall_broken] = True
                    queue.append((nx, ny, dist+1, wall_broken))
                
                #벽이 있고, 아직 벽을 부수지 않은 경우
                if grid[nx][ny] == 1 and wall_broken == 0 and visited[nx][ny][1] == False:
                    #방문 여부 기록하기 
                    visited[nx][ny][1] = True
                    queue.append((nx, ny, dist+1, 1))

    #목적지에 도달할 수 없는 경우 
    #큐가 비어있는 데 목적지에 도달하지 못한 경우              
    return -1


result = shortest_path_with_wall(n,m,grid)
print(result)