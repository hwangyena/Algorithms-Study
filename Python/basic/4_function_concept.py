def add(a,b): return a+b
print(add(3,5))

def sub(a,b): return a-b
print(sub(a=10, b=7))
print(sub(b=7, a=10))

#여러개의 입력값 받기
def add_many(*args):
    result = 0
    for i in args: result += i
    return result

print(add_many(1,2,3,4,5))

#여러개의 입력값 받기 2
def add_many2(name, *args, test):
    result = 0
    print("이름 : "+name+", test : "+str(test))
    for i in args: result+=i
    return result

print(add_many2("uca", 1,2,3,4,5, test="hi"))
# print(add_many2("uca", 1,2,test=3,4,5) #중간에 끊어서 받을수는 X

#keyword parameter
def print_kwargs(**keyword):
    print(keyword)

print_kwargs(a=1)
print_kwargs(name="gildong", age=35)

#여러개 반환하기
def calculator(*args):
    sum=0; mul=1
    for i in args:
        sum+=i; mul*=i
    return sum, mul

print(calculator(1,2,3,4,5))

#매개변수 초깃값 설정
def say_hello(count, name="uca"):
    print(name+" hello"*count)

say_hello(3)
say_hello(3, "hong")

#함수안의 변수
a = 10
def test(a):
    a+=10
test(a)
print(a)

#global
a = 10
def test2():
    global a
    a+=10
test2()
print(a)

#lambda
add = lambda a, b: a+b
print(add(3,4))