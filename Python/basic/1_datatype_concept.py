'''
python - 변수와 자료형 개념 정리
'''
from copy import copy

# print("hello world!")

# #변수 
# name = "홍길동"
# age = 34
# print(name + "은 " + str(age) + "살이다")


# # 숫자 자료형 
# a = 9
# b = 5
# print(a%b)
# print(a//b)

# x = 3
# y = 4
# print(x**y)

# #########################################################

# # 문자 자료형
# print('"Python" is useful')
# print('\'Python\' is powerful!')

# s = '''
# Life is too short
# You need Python
# '''
# print(s)

# ## 문자열 연산하기
# a = "python is "
# b = "fun!"
# print(a+b)
# print(b*10)

# ## 문자열 길이, 인덱싱, 슬라이싱
# a = "Life is too short"
# print(len(a))
# print(a[3] + a[-2])
# print(a[:4]) #처음부터 3까지 slicing
# print(a[-5:]) #-5부터 끝까지 slicing
# print(a[:]) #처음부터 끝까지 slicing

# s = "20210701school"
# when = s[:8]
# where = s[8:]
# print("when: "+when)
# print("where: "+where)

# ## 문자열 포매팅
# num = 1.23456789
# print( f'{num:0.3f}')

# ## 기타 문자열 함수
# s = "hobby"
# print(s.count("bb"))
# print(s.find('b'))
# print("..".join("abcde"))
# print("hi".upper())
# print("  hi  ".rstrip().lstrip()+"!")

# s = "hate coding!"
# s = s.replace("hate","fun")

# s = "apple, banana, kiwi"
# s = s.split(",")
# print(s)
# print("h".islower())
# s = "aaaaa"
# print(len(s))

# ## [Quiz]
# url = input()
# password = url.replace("http://","")
# password = password[:password.find(".")]
# password = password[:3]+str(len(password))+str(password.count('e'))+'!'
# print(f'{url}의 비밀번호는 {password}입니다')

#########################################################

# # 리스트 자료형
# a = [1,2,3]
# b = ["python", "c", "java"]
# c = [1, 2, "python", "c"]
# d = [1, 2, ["python", "c"]]

# a = [1,2,3,4,5]
# s = "12345"
# print(a[:2], s[:2])

# # 리스트 연산
# a = [1,2,3]
# b = [4,5,6]
# print(a*3)

# # 수정과 삭제
# a = [1,2,3,4,5]
# a[3] = 40
# del a[4:]
# print(a)

# # 리스트 관련 함수
# a = [4,5,2,3,1]
# a.sort()

# a = [1,2,3,4]
# b = [1,2]
# a.extend(b)
# a.clear()
# print(a)

#########################################################

# #튜플
# t1 = ()
# t2 = (1,)
# t3 = (1, 2, 3)
# t4 = 1, 2, 3
# t5 = ('a', 'b', ('ab', 'cd'))

# (name, age, school) = ("홍길동", 37, "서울대학교")
# print(name)

#########################################################

# #집합
# s1 = set([1,2,3])
# s2 = {1,2,3,4,5}
# s3 = set("abcde")
# print(s1)
# print(s2)
# print(s3)

# s1 = set([1,2,3,4,4,4,])
# l = list(s1)
# t = tuple(s1)
# print(l)
# print(t)

# john = {"java", "python"}
# kathy = {"python", "java", "c"}
# bob = {"python", "c#", "c"}

# print(john & kathy & bob) #교집합
# print(john.intersection(kathy).intersection(bob))

# print(john | kathy | bob) #합집합
# print(john.union(kathy).union(bob))

# print(kathy - bob) #차집합
# print(kathy.difference(bob))

# s1 = set([1,2,3])
# s1.add(4)

# s1.update([4,5,6])

# s1.remove(5)
# print(s1)

#########################################################

#bool 자료형
l = [1,2,3,4]
while(l):
    print(l.pop())

#########################################################
# a = [1,2,3,4]
# b = a[:]
# b[3] = 10
# print(a)

# a = [1,2,3]
# b = copy(a)
# b[2] = 10
# print(a)
# print(b)

[a,b] = ['python', 'life']
a, b = b, a
print(a)

a = [1,2,3,4]
print(type(a))

t = tuple(a)
print(t)

s = set(a)
print(s)