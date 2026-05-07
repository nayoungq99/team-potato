# DB 설계
## 1. 엔티티
Member, Product, Order

## 2. 속성
id, name, adress ...

## 3. 기본 키 (PK)
member_id, product_id ...
-> 고유하게 식별되는 것

## 4. 외래 키 (FK)
다른 테이블의 PK를 참조하는 속성

## 5. 관계
* 다대일
* 일대다
* 일대일
* 다대다 : 한 명의 학생은 여러 개의 강의 수강 가능, 하나의 강의는 여러 명의 학생이 수강 가능
---> **테이블로 관계를 구현해 서로 연결**, 외래 키로 해결할 수 없음.

# ERD = 데이터 청사진
개체-관계 중심의 모델링 기법 : **ER Model**
ER Model을 시각적으로 표현한 그림 -> **ERD**

## 식별 관계 VS 비식별 관계
* 식별: 관계 대상의 PK를 자신의 PK로도 사용
* 비식별: 관계 대상의 PK를 자신의 FK로만 사용
--> 보통 비식별 선택...

# JPA
SQL 작성 시간을 단축시켜 줌.

* JPA와 DB 의존성 추가
* DB 연결 정보 추가

## 엔티티 구현
### 1. 엔티티 클래스 
@Entity, @Id 필요  
@GeneratedValue: 고유 식별자 값 자동 생성
### 2. 외래키(FK)
@JoinColumn:FK 칼럼 정보 명시  
@ManyToOne(LAZY) 필요 
### 3. 엔티티 생성자
id 필드 제외하고 생성, access 속성 통해 접근 제한자를 protected로 설정.  
-> JPA만 사용 가능하도록.


# 이미지 첨부
[db_erd](./DB%20ERD%20스크린샷.png)  
[h2_table_members](./H2%20TABLE%20MEMBERS.png)  
[h2_table_orders](./H2%20TABLE%20ORDERS.png)  
[api_succeed](./api_succeed.png)  
[api_failure](./api_failure.png)
