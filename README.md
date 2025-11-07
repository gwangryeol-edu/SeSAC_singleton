# SeSAC Singleton Pattern - 쇼핑몰 관리 시스템

SeSAC 교육 과정에서 싱글톤 디자인 패턴을 학습하기 위한 쇼핑몰 관리 시스템 프로젝트입니다.

## 프로젝트 개요

이 프로젝트는 싱글톤 패턴을 활용하여 상품 및 주문 ID를 관리하는 간단한 쇼핑몰 시스템을 구현합니다.

## 주요 기능

- **상품 관리**
  - 상품 등록 및 조회
  - 이름/카테고리별 상품 검색
  - 재고 관리 (증가/감소/확인)

- **주문 관리**
  - 주문 생성 및 처리
  - 주문 내역 조회
  - 자동 재고 차감

- **ID 자동 생성**
  - 싱글톤 패턴을 활용한 유일한 ID 생성기
  - 상품 ID: P1, P2, P3...
  - 주문 ID: O1, O2, O3...

## 프로젝트 구조

```
src/main/java/
├── com/shop/
│   ├── ShopApp.java                 # 메인 애플리케이션
│   ├── manager/
│   │   └── ShopManager.java         # 쇼핑몰 관리 클래스
│   ├── model/
│   │   ├── Product.java             # 상품 모델
│   │   └── Order.java               # 주문 모델
│   └── utils/
│       └── IdGenerator.java         # 싱글톤 ID 생성기
```

## 싱글톤 패턴 구현

`IdGenerator` 클래스에서 싱글톤 패턴이 구현되어 있습니다:

```java
public class IdGenerator {
    private static IdGenerator instance;

    private IdGenerator() {
        // private 생성자
    }

    public static IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }
}
```

## 실행 방법

### 사전 요구사항

- Java 11 이상
- Gradle

### 빌드 및 실행

```bash
# Gradle로 빌드
./gradlew build

# 애플리케이션 실행
./gradlew run
```

또는 IDE(IntelliJ IDEA)에서 `ShopApp.java`의 `main` 메서드를 직접 실행할 수 있습니다.

## 실행 시나리오

프로그램 실행 시 다음 4가지 시나리오가 자동으로 실행됩니다:

1. **초기 데이터 설정**: 상품 4개 등록
2. **상품 조회**: 전체 상품 조회 및 카테고리별 검색
3. **주문 생성 및 처리**: 주문 생성, 상품 추가, 주문 처리
4. **전체 조회**: 전체 주문 내역 및 재고 현황 확인

## 핵심 클래스 설명

### IdGenerator (싱글톤)

- 애플리케이션 전체에서 단 하나의 인스턴스만 존재
- 상품 ID와 주문 ID를 순차적으로 생성
- 위치: `src/main/java/com/shop/utils/IdGenerator.java:16`

### ShopManager

- 상품 및 주문 관리의 핵심 클래스
- 배열 기반으로 최대 50개의 상품/주문 관리
- 위치: `src/main/java/com/shop/manager/ShopManager.java`

### Product

- 상품 정보를 담는 모델 클래스
- ID, 이름, 가격, 재고, 카테고리 속성 포함
- 재고 관리 메서드 제공

### Order

- 주문 정보를 담는 모델 클래스
- 최대 10개 상품 담기 가능
- 주문 상태 관리 (결제대기, 결제완료, 취소)

## 기술 스택

- **언어**: Java
- **빌드 도구**: Gradle
- **테스트**: JUnit 5

## 학습 포인트

1. **싱글톤 패턴**: IdGenerator를 통해 싱글톤 패턴의 구현과 활용 방법 학습
2. **객체 지향 설계**: 모델, 매니저, 유틸리티 클래스 분리를 통한 관심사 분리
3. **유효성 검증**: setter 메서드를 활용한 데이터 유효성 검증
4. **배열 기반 자료 구조**: 동적 배열 관리 및 검색 구현