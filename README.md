# SPRING ADVANCED


## 필수 Lv 1. 코드 개선
### 1. Early Return
+ 이메일 검증을 제일 상단에 배치하여 불필요한 로직의 실행을 방지하였습니다

### 2. 불필요한 if-else 피하기
+ 서로 다른 조건이므로 불필요하게 else 안에 또 다른 if문을 넣지 않고 밖으로 뺐습니다

### 3. Validation
+ service부분에 있던 코드는 Dto에서 validation으로 처리하고 Controller에서 @Valid 어노테이션 사용으로 미리 예외처리가 가능하므로 그렇게 처리하였습니다

---
## 필수 Lv 2. N+1 문제
+ 기존의 코드는 Lazy 로딩 설정으로 인해 N+1 문제가 발생할 수 있는 부분을 FETCH JOIN을 사용하여 해결하고 있었습니다
+ 그러나 FETCH JOIN의 경우 @OneToMany 연관관계에서는 페이징이 불가능하다는 단점이 있어 @EntityGraph 방식으로 수정하였습니다
---
## 필수 Lv 3. 테스트코드 연습
### 테스트 코드 연습 1
+ 테스트코드의 매개변수 부분이 잘못 설정되어 있어 수정하였습니다

### 테스트 코드 연습 2 - 1번 케이스
+ 던지는 에러가 InvalidRequestException 이므로 적합하게 메서드명과 예외문구를 수정하였습니다

### 테스트 코드 연습 2 - 2번 케이스
+ 던지는 에러가 InvalidRequestException 이므로 적합하게 수정하였습니다

### 테스트 코드 연습 2 - 3번 케이스
+ Todo의 User가 null이기 때문에 NPE가 발생하고 있으므로 그에 대한 조건을 추가해주었습니다

-----
## 도전 Lv 5. 위 제시된 기능 이외 '내'가 정의한 문제와 해결 과정
### Response 부분
+ 너무 많은 매개변수로 인해 문제가 발생 가능합니다
  + 객체를 매개변수로 두어 해결하였습니다
 
ex) TodoResponse와 TodoService의 saveTodo 메서드 부분

### URL 부분
+ @RequestMapping을 활용하여 중복되는 부분을 제거하였습니다