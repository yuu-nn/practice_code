x=int(input()) #국어 점수 입력.
y=int(input()) #영어 점수 입력.
z=int(input()) #수학 점수 입력.
r=int(input()) #정보 점수 입력.

tot= x + y + z + r
avg= tot//4 #평균은 정수 부분만 출력.

print(f"tot: {tot}")
print(f"avg: {avg}")
