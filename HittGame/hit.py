file = open('hit_input_data.txt', 'r', encoding='UTF-8')
input_data = []
list = file.readlines()
for line in list:
    line = line.replace('\n', '')
    input_data.append(line)
file.close()


divide_data = []
index = 0
for data in input_data:
    split_data = data.split()
    divide_data.append(split_data)

divide_data = [[int(item) for item in row] for row in divide_data]

my_x = divide_data[0][0]
my_y = divide_data[0][1]
my_width = divide_data[0][2]
my_height = divide_data[0][3]
i = 2


while i < int(divide_data[1][0]) + 2:
    flg_w = False
    flg_h = False
    if my_x <= divide_data[i][0] and my_x + my_width >= divide_data[i][0]:
        flg_w = True
    
    elif my_x <= divide_data[i][0] and my_x + my_width >= divide_data[i][0]:
        flg_w = True

    elif my_x >= divide_data[i][0] and my_x + my_width <= divide_data[i][0] + divide_data[i][2]:
        flg_w = True
    
    elif my_x >= divide_data[i][0] and my_x <= divide_data[i][0] + divide_data[i][2]:
        flg_w = True

    if flg_w:
        if my_y <= divide_data[i][1] and my_y + my_height >= divide_data[i][1]:
            flg_h = True

        elif my_y >= divide_data[i][1] and my_y + my_height <= divide_data[i][1] + divide_data[i][3]:
            flg_h = True
        
        elif my_y >= divide_data[i][0] and my_y <= divide_data[i][0] + divide_data[i][3]:
            flg_h = True
    
    
    if flg_w and flg_h:
        print("敵機" + str(i - 1) + "が当たり")
    i += 1