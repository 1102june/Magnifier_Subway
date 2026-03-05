## 🚈 Magnifier Subway (돋보기 지하철)
"복잡한 세상을 지하철만큼은 크게" -> 고령층 사용자를 위한 단순하고 직관적인 지하철 정보 제공 서비

## 📌 프로젝트 소개
Magnifier Subway는 디지털 기기 사용에 어려움을 겪는 50대 이상 시니어 세대를 위한 안드로이드 애플리케이션입니다. 기존 앱들의 정보 과잉(Information Overload) 문제를 해결하고, **'큰 글씨'**와 **'최소한의 조작'**만으로 실시간 지하철 정보를 확인할 수 있도록 설계되었습니다.


## 🎯 기획 배경
- 경험: 시작은 저와 할아버지가 같이 서울 지하철을 탈일이 있었는데, 할아버지가 지하철앱은 글씨가 작고 복잡해서 외우고 다닌다는 말로부터 아이디어가 시작되었습니다.
- Android Modern Development https://velog.io/@peter4045123/series/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B0%9C%EB%B0%9C%EC%9E%90-%EB%BF%8C%EB%A6%AC 에서 배운 지식을 직접 활용.
- UX의 재해석: 정보의 양보다는 가독성에 집중하여 시니어 친화적 UI 구성
- 진입 장벽 최소화: 복잡한 가입 절차 대신 구글 및 익명 로그인 제공
- 성능 최적화: SQLD 지식을 활용한 로컬 DB 설계로 빠른 역 검색 지원

## 🧱 아키텍처
본 프로젝트는 확장성과 유지보수성을 위해 Clean Architecture와 MVVM Pattern을 철저히 준수합니다. 

## 1. Presentation Layer (UI)
- Jetpack Compose: 선언형 UI를 통해 코드 복잡도를 낮추고 유연한 레이아웃 구현
- MVVM Pattern: StateFlow를 활용하여 UI 상태와 비즈니스 로직을 엄격히 분리
- Navigation Compose: 중앙 집중식 경로 관리를 통한 명확한 화면 흐름(Splash → Auth → Main)

## 2. Domain Layer (Business Logic)
- UseCases: 각 기능(검색, 즐겨찾기, 경로 찾기)을 독립적인 비즈니스 단위로 분리
- Domain Models: 프레임워크에 의존하지 않는 순수한 Kotlin 객체 정의
- Repositories Interface: 데이터 소스에 상관없이 일관된 데이터 접근 방식 보장
 
## 3. Data Layer (Data Source)
- Room DB: 전체 역 마스터 정보를 로컬에 저장. stationName 컬럼에 Index를 설정하여 검색 성능 최적화
- Retrofit2: 공공데이터 API(서울시 실시간 도착 정보 등) 연동
- Firebase Auth: Google OAuth 2.0 및 익명 인증 처리
- Mappers: Data Entity와 Domain Model 간의 데이터 변환 담당

## 🔐 인증 설계
- Firebase Authentication
- Google Login
- Anonymous Login (초기 진입 장벽 최소화를 위한 선택적 적용)

## 🚧 현재 구현 상태
- Splash 화면 및 앱 로고 적용
- 앱 초기 네비게이션 구조 구성
- Login 화면 UI 뼈대 구현
- Firebase Auth(Google) 설정 완료

## 🛠 기술 스택
-Language: Kotlin
- UI: Jetpack Compose
- Architecture: MVVM, Clean Architecture
- DI: Hilt (Dependency Injection)
- Local DB: Room
- Network: Retrofit2, OkHttp3
- Auth: Firebase Authentication

## 🚧 현재 진행상황 
[x] 프로젝트 초기 환경 설정 및 Hilt 주입 구조 설계
[x] Splash 및 Google/Anonymous 로그인 Flow 구현
[x] Room DB 엔티티 및 DAO 설계 완료
[ ] 공공데이터 API(실시간 도착 정보) 연동
[ ] 경로 탐색 알고리즘(Dijkstra) 적용 및 시각화

## ▶️ 실행 방법
```bash
git clone https://github.com/1102june/Magnifier_Subway.git
