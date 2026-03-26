단어는 많이 들어봤으나 그런 단어가 무엇을 의미하는지, 어떤 기능을 하는지 정확히 알게되었다. 예를 들어, URL에 리소스 경로와, 도메인주소 등이 포함되어 있었다는 점을 알았다. HTTP의 주요 상태 코드에서 404만 알고 있었으나 다른 코드도 알게되어 좋았으며 앞으로 백엔드 분야에 대해 더 자세히 알게 될 수 있을 것 같아 기대가 된다.


![Whitelable Error Page 스크린샷](<화면 캡처 2026-03-26 181438.png>)


1. 상품 정보 등록
HTTP Method: POST
URI: /products
2. 상품 목록 조회
HTTP Method: GET
URI: /products
3. 개별 상품 정보 상세 조회
HTTP Method: GET
URI: /products/{productid}
4. 상품 정보 수정
HTTP Method: PATCH
URI: /products/{productid}
5. 상품 삭제
HTTP Method: DELETE
URI: /products/{productid}



1. 주문 정보 생성
HTTP Method: POST
URI: /orders
2. 주문 목록 조회
HTTP Method: GET
URI: /orders
3. 개별 주문 정보 상세 조회
HTTP Method: GET
URI: /orders/{orderid}
4. 주문 취소
HTTP Method: DELETE
URI:/orders/{orderid}
