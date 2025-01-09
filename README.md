# 계산기
기본적인 사칙연산이 가능한 계산기입니다<br>
## Introduction
LV1 : 기본 사칙연산 계산기<br>
LV2 : 클래스 적용<br>
LV3 : 최종 완성본. 기능 추가 (Enum, 제네릭, 람다 & 스트림 활용)<br>
## Tech Stack

- **Language**:  
  ![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
- **Tools**:  
  ![Git](https://img.shields.io/badge/Git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
## Features
- 사칙 연산 :
  - 덧셈
  - 뺄셈
  - 곱하기
  - 나누기<br><br>
    부적절한 입력값(음수, 연산자 아닌 값, 0으로 나누기 등) 입력 시 예외처리<br><br>
- 계산 기록 확인하기 : 
  계산한 순서대로 결과값을 확인할 수 있습니다
- 계산 기록 삭제하기 : 
  가장 먼저 저장된 결과값을 삭제합니다
## Installation
리포지토리 클론:
   ```bash
   git clone https://github.com/Seungmin-J/Calculator.git
   ```
## Usage
**App 실행**:
   - `App.java`를 실행하세요.
   - 실행 후 아래 기능 중 하나를 선택하세요:

     ### 계산하기:
     - 피연산자 값 2개와 연산자를 입력하세요.
     - **입력 조건**:
       - 피연산자는 양수만 입력 가능합니다.
       - 연산자는 정확히 입력해야 합니다.
       - 0으로 나누는 것은 불가능합니다.

     ### 기록 확인:
     - 전체 기록을 확인하거나 특정 값보다 큰 기록만 필터링할 수 있습니다.

     ### 기록 삭제:
     - 가장 먼저 저장된 기록부터 삭제됩니다.

   - 계속 진행하려면 아무 키나 입력하고, 종료하려면 `exit`를 입력하세요.
## Contact
email: seungmin103@gmail.com
