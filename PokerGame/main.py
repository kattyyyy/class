def role():
    mark_count = 1
    max_count = 1
    pair_count = [[1, 1],[2, 1],[3, 1],[4, 1],[5, 1],[6, 1],[7, 1],[8, 1],[9, 1],[10, 1],[11, 1],[12, 1],[13, 1]]
    count = 0
    role = ""
    done_number = []
    min_number = 100
    flash_flg = False
    straight_flg = True
    royal_flg = False
    fourcard_flg = False
    threecard_flg = False
    twopair_flg = False
    pair_flg = False
    fullhouse_flg = False
    fullhouse_count = 0
    for j in range(5):
                if min_number > int(divide_data[j][1].replace('0*', '')):
                    min_number = int(divide_data[j][1].replace('0*', ''))
    straight_number = min_number

    for i in range(5):
        
        for j in range(i+1, 5):
            if divide_data[i][0] == divide_data[j][0]:
                mark_count += 1
        if max_count < mark_count:
            max_count = mark_count
        if max_count == 5:
            flash_flg = True
        mark_count = 1        
        if int(divide_data[i][1].replace('0*', '')) not in done_number:
            for j in range(i+1, 5):
                if int(divide_data[i][1].replace('0*', '')) == int(divide_data[j][1].replace('0*', '')):
                    pair_count[int(divide_data[i][1].replace('0*', '')) + 1][1] += 1
                    done_number.append(int(divide_data[i][1].replace('0*', '')))

    straight_count = 1
    if straight_flg == True:

        # A(エース)は1と14の役割を持つ
        if straight_number == 1:
            for j in range(5):
                if int(divide_data[j][1].replace('0*', '')) == 10:
                    straight_number = 9
                    royal_flg = True

        for j in range(5):
            for k in range(5):
                if straight_number + 1 == int(divide_data[k][1].replace('0*', '')):
                    straight_number = int(divide_data[k][1].replace('0*', ''))
                    straight_count += 1
        if straight_count >= 5:
            straight_flg = True
        else: 
            straight_flg = False
        
    # 役の判定
    for item in pair_count:
        print(item[1])
        if item[1] == 4:
            fourcard_flg = True
            break
        if item[1] == 3:
            threecard_flg = True
        if item[1] == 2:
            count += 1
        if item[1] > 1:
            fullhouse_count += item[1]
        
    if count == 1:
        pair_flg = True
    elif count == 2:
        twopair_flg = True
    if fullhouse_count == 5:
        fullhouse_flg = True
    
    # 役の判定
    if straight_flg == True & flash_flg == True & royal_flg == True:
        role ="ロイヤルストレートフラッシュ"
    elif straight_flg == True & flash_flg == True:
        role = "ストレートフラッシュ"
    elif fourcard_flg == True:
        role = "フォーカード"
    elif fullhouse_flg == True:
        role ="フルハウス"
    elif flash_flg == True:
        role = "フラッシュ"
    elif straight_flg == True:
        role = "ストレート"
    elif threecard_flg == True:
        role = "スリーカード"
    elif twopair_flg == True:
        role = "ツーペア"
    elif pair_flg == True:
        role = "ワンペア"
    else:
        role = "ブタ"
    
    return role
        

# タプルは値が変更不可の配列
tuple_suit = ('S', 'C', 'D', 'H')
tuple_number = ('A','2','3','4','5','6','7','8','9','10','J','Q','K')
file = open('input_data.txt', 'r', encoding='UTF-8')
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

role = role()
cards = ""
for i in range(5):
    cards += tuple_suit[int(divide_data[i][0].replace('0*', ''))] + tuple_number[int(divide_data[i][1].replace('0*', ''))] + ' '
print(cards)
print(role)