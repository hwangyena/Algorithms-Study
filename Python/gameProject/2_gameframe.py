#####################################################################
## 게임 기본 설정 - 화면크기, 타이틀, FPS

import pygame
pygame.init() 

screen_width = 480
screen_height = 640
screen = pygame.display.set_mode((screen_width, screen_height))

pygame.display.set_caption("Game Project") 

clock = pygame.time.Clock()

#######################################################################
## 사용자 게임 초기화 - 배경화면, 게임 이미지, 좌표, 속도, 폰트 등


#######################################################################

# event loop
running = True 
while running:
    frame = clock.tick(30) 

    ## 이벤트 처리 - 키보드, 마우스
    for event in pygame.event.get():  
        if event.type == pygame.QUIT: 
            running = False           

    ## 위치 처리

    ## 충돌 처리
    
    ##화면에 그리기


    pygame.display.update() 

#종료
pygame.quit()