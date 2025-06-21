from random import *

#일반 유닛
class Unit:
    def __init__(self, name, hp, speed):
        self.name=name
        self.hp=hp
        self.speed=speed
        print(f"{name} 유닛을 생성했습니다.")

    def move(self, location):
        print(f"{self.name}: {location} 방향으로 이동합니다. [속도 {self.speed}]") 

    def damaged(self, damage):
        print(f"{self.name}: {damage}만큼 피해를 입었습니다.")
        self.hp-=damage
        print(f"{self.name}: 현재 체력은 {self.hp}입니다.")
        if self.hp<=0:
            print(f"{self.name}: 파괴되었습니다.")

#공격 유닛
class AttackUnit(Unit): #unit 상속
    def __init__(self, name, hp, damage, speed): #오버라이딩! “부모 클래스의 메서드를 같은 이름으로 다시 정의하는 것”
        Unit.__init__(self, name, hp, speed) #unit의 생성자 __ini__를 직접 호출!
        self.damage = damage # AttackUnit만의 고유한 속성. 위의 damage랑은 다름
    
    def attack(self, location):
        print(f"{self.name} : {location} 방향 적군을 공격합니다. [공격력 {self.damage}]")

#보병 유닛
class Soldier(AttackUnit):
    def __init__(self):
        AttackUnit.__init__(self, "보병", 40, 5, 1)

    def booster(self):
        if self.hp > 10:
            self.hp -=10
            print(f"{self.name}: 강화제를 사용합니다. (HP 10 감소)")
        else:
            print(f"{self.name}:체력이 부족해 기술을 사용할 수 없습니다.")

#탱크 유닛
class Tank(AttackUnit):
    siege_developed = False

    def __init__(self):
        AttackUnit.__init__(self, "탱크", 150, 35, 1)
        self.siege_mode = False

    def set_siege_mode(self):
        if Tank.siege_developed == False:
            return
        if self.siege_mode == False:
            print(f"{self.name}: 시지 모드로 전환합니다.") #제자리에서 포격을 하는 공격을 시지모드라고 함
            self.damage *=2
            self.siege_mode = True
        else :
            print(f"{self.name}: 시지 모드를 해제합니다.")
            self.damege //=2
            self.siege_mode = False

# 비행 기능
class Flyable:
    def __init__(self, flying_speed):
        self.flying_speed = flying_speed

    def fly(self, name, location):
        print(f"{name}: {location} 방향으로 날아갑니다. [속도 {self.flying_speed}]")

# 공중 공격 유닛
class FlyableAttackUnit(AttackUnit, Flyable): #다중 상속 가능.
    def __init__(self, name, hp, damage, flying_speed): #오버라이딩(부모 클래스인 AttackUnit과 Flyable의 생성자와 다르게 작성됐음)
        AttackUnit.__init__(self, name, hp, damage, 0)
        Flyable.__init__(self, flying_speed)

    def move(self, location):
        self. fly(self.name, location)

# 전투기 유닛
class Stealth(FlyableAttackUnit):
    def __init__(self):
        FlyableAttackUnit.__init__(self, "전투기", 80, 20, 5)
        self.cloaked = False #cloack : 은폐하다

    def cloaking(self):
        if self.cloaked == True:
            print(f"{self.name}: 은폐 모드를 해제합니다.")
            self.cloaked = False

        else:
            print(f"{self.name}: 은폐 모드를 설정합니다.")
            self.cloaked = True

# 게임 시작
def game_start():
    print("[알림] 새로운 게임을 시작합니다.")

# 게임 졸료
def game_over():
    print("Player : Good Game")
    print("[Player] 님이 게임에서 퇴장했습니다.")

# 실제 게임 진행
game_start()

#보명 3기 생성
so1 = Soldier()
so2 = Soldier()
so3 = Soldier()

#탱크 2기 생성
ta1 = Tank()
ta2 = Tank()

# 전투기 1기 생성
st1 = Stealth()

# 유닛 일괄 관리
attack_units = []
attack_units.append(so1) 
#AttackUnit.__init__(self, "보병", 40, 5, 1) 호출 > Unit.__init__("보병", 40, 1) 도 호출 (부모클래스)
attack_units.append(so2)
attack_units.append(so3)
attack_units.append(ta1) 
#AttackUnit.__init__(self, "탱크", 150, 35, 1) 호출 > Unit.__init__("탱크", 150, 1)
attack_units.append(ta2)
attack_units.append(st1)
'''
Stealth → FlyableAttackUnit → AttackUnit → Unit 순으로 초기화
Unit.__init__("전투기", 80, 0)
Flyable.__init__(5)
'''

# 전군 이동
for unit in attack_units:
    unit.move("1시")
'''
보병/탱크는 Unit.move() 호출
전투기(st1)는 오버라이딩된 move 사용 → fly() 호출
'''

# 탱크 시지 모드 개발
Tank.siege_developed = True
print("[알림] 탱크의 시지 모드 개발이 완료되었습니다.")

# 공격 모드 준비
for unit in attack_units:
    if isinstance(unit, Soldier): #3명의 보병 부스터 사용
        unit.booster()
    elif isinstance (unit, Tank): 
        unit.set_siege_mode()
    #siege_developed=True, siege_mode=False → 시지 모드 전환, 공격력 ×2 (35 → 70)
    elif isinstance (unit, Stealth):
        unit.cloaking()
    # cloaked=False → 은폐 모드 설정

# 전군 공격
for unit in attack_units:
    unit.attack("1시") # AttackUnit의 attack() 호출됨

# 전군 피해
for unit in attack_units:
    unit.damaged(randint(5, 20)) #모든 유닛이 5~20 사이 랜덤 피해 입음 → damaged() 실행됨

#게임 종료
game_over()
