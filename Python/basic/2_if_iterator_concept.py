########################## if ###########################
# weather = "비"

# if weather == "비":
#     print("우산 챙기기")
#     print("집에 있기")
# elif weather == "미세먼지":
#     print("마스크 챙기기")
# else:
#     print("준비물 없음")
#     print("밖에 나가기")

##

# s=[1,2,3]
# s = "123"
# if "3" in s:
#     print("3: s 안에 있음!")
# if "4" not in s:
#     print("4: s 안에 없음!")

##
# pocket = ['money', 'phone']
# if 'money' in pocket:
#     pass
# else:
#     print("걸어가기")

##
# a = 10
# result = "true" if a>=10 else "false"

# if(result): print("hi")

########################## while ###########################

# prompt = """
# 1. Add
# 2. Delete
# 3. Show
# 4. Quit

# Enter num: """
# num = 0
# while num!=4:
#     num = int(input(prompt))
#     print("Enter : "+str(num))

##

# while True:
#     a = input("금액을 입력해주세요: ")
#     if(int(a)<1000): print("금액이 부족합니다!")
#     else: break

##

# a = 0
# while a<10:
#     a+=1
#     if a%2==0:
#         continue
#     print("a : "+str(a), end="")
    

########################## while ###########################

# wait = [1,2,3,4,5,6]

# for i in wait:
#     print(f'대기번호 : {i}')

##

# t = [(1,"a"), (2,"b"), (3,"c")]
# for (num, char) in t:
#     print("num: "+str(num)+", char: "+char)

##

# grade = 'a', 'b', 'a', 'f', 'c'
# i = 0
# for g in grade:
#     i+=1
#     if(g == 'f'):
#         print("낙제!")
#         break
#     if(i == len(grade)):
#         print("통과!")

##

# grade = ['a', 'b', 'f', 'a', 'c']
# i=0
# for g in grade:
#     i+=1
#     if g=='f' or g=='c' or g=='d':
#         continue
#     print(f'{i}번째 학생은 통과')
        
##

# a = range(10)
# print(a)

# sum = 0
# for b in range(3, 5):
#     print("더하는 값 : "+str(b))
#     sum += b
# print(sum)

# score = [60, 80, 90, 40]
# for s in range(len(score)):
#     print(f'{s+1}: {score[s]}')

##

#리스트 내포
a = [1,2,3,4,5]
res = []

res = [num*10 for num in a]
print(res)