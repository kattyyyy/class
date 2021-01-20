import pygame
# 各種設定
framerate = 60 # 1 秒間に描画する回数
x = 100 # 円の描画位置 x 座標
y = 200 # 円の描画位置 y 座標
pygame.init() # pygame を初期化
screen = pygame.display.set_mode((800,480)) # 800x480 サイズのウインドウを生成
clock = pygame.time.Clock() # クロックを取得
# ループ終了のフラグを設定
endflg = False
print("ループを開始します")
# ループ
while endflg == False:
    # ループ終了の判定
    for event in pygame.event.get():
        if event.type == pygame.QUIT: # ウインドウが閉じられたら、
            endflg = True # ループを終了させる
    # イベント処理 ： マウス操作などのイベントに対応させる
    # このプログラムではイベント対応なし
    # 描画処理 ： 1 フレームごとで描画する処理を記述する
    pygame.draw.circle(screen, (255,255,255), (x,y), 100) # 円を描画
    x += 1 # x 座標値を 1 増やす
    # フレームレートを設定して時間更新
    clock.tick(framerate)
    # 描画処理を画面に反映させる
    pygame.display.flip()
    # ループを抜けたら全処理終了
pygame.quit()
