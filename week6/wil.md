# DTO와 유효성 검사
## 유효성 검사
- 요청으로 들어오는 데이터가 올바른 형식인지 검사함.  
- Spring은 DTO에서 유효성을 검사함.
- 의부 의존성을 추가함
- ``@NotNull``, ``@Size``, ``@Pattern`` 등의 검사 어노테이션을 적용함.
- Controller 메서드에 @Valid 추가  --> 제약 조건에 맞는지 검사함.

# 전역 예외 처리 (Global Exception Handling)
- 에러가 발생했을 때 원인을 알려주는 에러 메시지를 담도록 직접 응답 객체 생성.

## Global Exception Handler
- 공통 예외 처리 핸들러
- 에러 정보 반환용 DTO
- AOP(관점 지향 프로그래밍) --> 부가 기능을 모듈화.

## 커스텀 예외 처리
- RuntimeException을 상속함.
- Global Exception Handler에 등록하면 에러 원인을 명확히 알 수 있음.

## 에러 메시지 클래스
- 중복 사용으로 추가/수정 어려움 --> 상수로 정의

# Swagger(OpenAPI)
- 문서화 도구
- API 테스트가 가능함.
- ``@Tag``: API 그룹화
- ``@Operation``: API의 요약과 설명
- ``@ApiResponse``: 단일 응답 코드 설명 

# [에러 메시지](./400%20error.png)

# [Swagger UI](./swagger.png)