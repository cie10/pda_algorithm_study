from collections import deque

dx = [1,-1,0,0]
dy = [0,0,1,-1]

R, C, N = map(int, input().split())
grid = []
boomlist = deque() 

for i in range(R):
    row = list(input())
    for j in range(C):
        if row[j] == '0': #처음 폭탄 좌표들 저장 
            boomlist.append([i,j])
    grid.append(row)

#초기시간 1로 잡아두기 
t = 1

while t < N:
    
    #처음 폭탄 채워넣기 
    for i in range(R):
        for j in range(C):
            if grid[i][j] == '.':
                grid[i][j] = '0'
    
    #시간 증가 
    t += 1

    if t == N:
        break

    #폭탄이 있는 자리를 기억한 후 폭탄 터트리기 
    while boomlist:
        x,y = boomlist.popleft()
        grid[x][y] = '.'
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < R and 0 <= ny <C:
                grid[nx][ny] = '.' 
    
    for i in range(R):
        for j in range(C):
            if grid[i][j] == '0':
                boomlist.append([i,j])
    
    t += 1

for g in grid:
    prinv=(''.join)


        
            