def change(n):
    
    # 거스름돈 개수 저장 변수 
    coin2 = 0
    coin5 = 0 

    # 거스름돈 전체가 5로 나눠질 경우 -> 그냥 5로 나눈 몫을 반환
    if n % 5 == 0:
        return n//5 

    #5의 배수가 아닐 경우 
    while (n > 0):
        n = n-2
        coin2 += 1
        print("coin2 = " , coin2)

        if n % 5 == 0:
            coin5 += n//5
            print("coin5 =", coin5)
            return coin2 + coin5
        
    if n < 0:
        return -1


# 거스름 돈 
n = int(input())
result = change(n)
print(result)