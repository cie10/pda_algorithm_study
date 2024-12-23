#조합으로 풀기 

from itertools import combinations

maps =[]

#꽃이 겹치는 지 확인
def check(map_list):
    global answer
    visited = []
    total = 0
    #좌표 하나하나 넣기 
    for x, y in map_list:
        visited.append((x,y))
        #비용 저장 
        total += maps[x][y]
        for i in range(4):
            ax = x + dx[i]
            ay = y + dy[i]

            if (ax, ay) not in visited:
                total += maps[ax][ay]
                visited.append((ax,ay))
            else:
                return 
        
    answer = min(answer, total)
    

n = int(input())
dx = [1,-1,0,0]
dy = [0,0,1,-1]

for _ in range(n):
    maps.append(list(map(int, input().split())))

result = []
#가장자리 제외 
for i in range(1, n-1):
    for j in range(1, n-1):
        result.append((i,j))

answer = int(1e9)

for i  in combinations(result, 3):
    check(i)

print(answer)

#dfs로 풀기 
