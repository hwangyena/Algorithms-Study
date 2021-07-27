#####################################################################
## 게임 기본 설정 - 화면크기, 타이틀, FPS

import pygame
from random import *
pygame.init() 

screen_width = 480
screen_height = 640
screen = pygame.display.set_mode((screen_width, screen_height))

pygame.display.set_caption("똥 피하기 게임💩") 

clock = pygame.time.Clock()

#######################################################################
## 사용자 게임 초기화 - 배경화면, 게임 이미지, 좌표, 속도, 폰트 등

# 캐릭터 불러오기
character = pygame.image.load("D:/Algorithms/Algorithms-Study/Python/gameProject/character.png") #70*70
character_size = character.get_rect().size #이미지의 크기 알아내기
character_width = character_size[0]; character_height = character_size[1] #가로, 세로 크기
character_x = (screen_width/2)-character_width/2 #캐릭터 가로 위치
character_y = screen_height-character_height  #캐릭터 세로 위치

poop = pygame.image.load("D:/Algorithms/Algorithms-Study/Python/gameProject/poop_smile.png") #70*70
poop_size = poop.get_rect().size #이미지의 크기 알아내기
poop_width = poop_size[0]; poop_height = poop_size[1] #가로, 세로 크기
poop_x = randrange(0, screen_width-poop_width)
poop_y = 0-poop_height #0에서 시작!


#이동 좌표
to_x = 0 
character_speed = 0.6

to_poop_y = 0
poop_speed = 0.5

#폰트
game_score = pygame.font.Font(None, 40)
total_score = 0

gameOver = pygame.font.Font(None, 40)
isOver = False

#######################################################################
# event loop
running = True 
while running:
    frame = clock.tick(40) 

    ## 이벤트 처리 - 키보드, 마우스
    for event in pygame.event.get():  
        if event.type == pygame.QUIT: 
            running = False          
        if event.type == pygame.KEYDOWN: #키가 눌렸는지 확인
            if event.key == pygame.K_LEFT: #왼쪽
                to_x -= character_speed
            if event.key == pygame.K_RIGHT: #오른쪽
                to_x += character_speed
        if event.type == pygame.KEYUP: #방향키를 떼면
            if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT: 
                to_x = 0
    
    ## 위치 처리
    character_x += to_x*frame; 

    #가로 경계 처리
    if character_x < 0:
        character_x = 0
    elif character_x > screen_width-character_width: #캐릭터는 왼쪽 상단이 위치값이므로!!
        character_x = screen_width-character_width

    #poop 아래로 떨어짐
    poop_y += poop_speed*frame

    # print(poop_y)
    if poop_y > screen_height : #끝까지 떨어지면 다시 
        print("떨어짐!")
        poop_x = randrange(0, screen_width-poop_width)
        poop_y = 0
        total_score += 1
    

    ## 충돌 처리
    character_rect = character.get_rect()
    character_rect.left = character_x
    character_rect.top = character_y
    
    poop_rect = poop.get_rect()
    poop_rect.left = poop_x
    poop_rect.top = poop_y

    if character_rect.colliderect(poop_rect):
        print("충돌!")
        running = False
        isOver = True

    ##화면에 그리기
    screen.fill((255, 255, 255))
    screen.blit(character, (character_x, character_y))
    screen.blit(poop, (poop_x, poop_y))

    if(isOver):
        font_over = gameOver.render("Game Over!", True, (240,0,0))
        screen.blit(font_over, (screen_width/2 - 70, screen_height/2 - font_over.get_rect().size[1]))
    else:
        font_score = game_score.render("score: "+str(total_score), True, (0,0,0))
        screen.blit(font_score, (10,10))

    pygame.display.update() 


#대기
pygame.time.delay(2000) #2초 대기(ms)

#종료
pygame.quit()