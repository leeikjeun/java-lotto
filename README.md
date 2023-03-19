# 문자열
## 기능 요구사항
 - 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (e.g. "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6)
 - 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 
     - 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 - 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.
 - 문자열 또는 null을 입력할 경우 0을 반환해야 한다.
 - 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.

## 구현 기능
 - [x] 계산할 문자열을 가질 수 있다.
 - [x] 커스텀 구분자를 가질 수 있다.
 - [x] 구분자로 나눌수 있다
 - [x] 구분된 값을 덧셈이 가능하다.
 - [x] 정의되지않은 구분자가 들어오면 에러가 발생한다.
 - [x] 숫자 외 또는 음수가 들어오면 에러가 발생한다.
 - [x] 덧셈이 가능하다.
 -  

# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.


### 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다
- 배열 대신 컬렉션을 사용한다.
- Java Enum을 적용한다.
- 모든 원시 값과 문자열을 포장한다
- 줄여 쓰지 않는다(축약 금지).
- 급 컬렉션을 쓴다.

#### 로또 기계
- [x] 금액을 저장할 수 있다.
- [X] 로또를 자동으로 구매할 수 있다.
- [X] 로또를 수동으로 구매할 수 있다.
- [X] 로또티켓들을 저장 할 수 있다.
- [X] 당첨번호를 저장 할 수 있다.
- [X] 당첨 통계를 만들 수 있다.
   - [X] 총 수익률
   - [X] 당첨된 금액별 집계
- [X] 구입한 로또 갯수를 알 수 있다. 
- [x] 로또티켓의 등수별 당첨갯수를 알 수 있다.
- [x] 수동 구매 갯수에 대한 정합성 체크를 할 수 있다.

#### 로또 티켓
- [x] 번호가 정확히 6자리어야 한다.
- [x] 랜덤으로 겹치지않은 1~45의 숫자리스트를 만들어준다.
- [x] 당첨번호를 입력하면 등수를 리턴해준다.
- [x] 당첨된 등수를 알 수 있다.
- 
#### 당첨 로또 번호
- [X] 당첨 등수를 알려준다.
- [X] 당첨번호와 보너스번호를 저장할 수 있다.
- [X] 당첨번호와 보너스번호 정합성을 검증한다.

#### 로또 번호
- [x] 로또번호는 1~45까지만 가질 수 있다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)