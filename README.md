# Magnifier Subway (돋보기 지하철)

## 📌 프로젝트 소개
Magnifier Subway는 고령층(50대 이상)을 주요 타겟으로,
복잡한 지하철 정보를 큰 글씨와 단순한 흐름으로 제공하는 안드로이드 앱입니다.

기존 지하철 앱의 정보 과잉 문제를 개선하고,
최소한의 입력만으로 필요한 경로와 역 정보를 확인할 수 있는 UX를 목표로 합니다.

## 🎯 기획 배경
- 기존 지하철 앱은 기능과 정보가 많아 고령층에게 사용 난이도가 높음
- 실제 사용자 관점에서 “보여줄 정보”를 줄이는 방향의 설계를 시도
- Splash → Login → Main으로 이어지는 단순한 진입 흐름 설계

## 🧱 아키텍처
- MVVM + Clean Architecture
- UI / Domain / Data 계층 분리
- Navigation 로직은 ui/navigation에서 중앙 관리

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
- Kotlin
- Jetpack Compose
- Firebase Authentication
- Navigation Compose
- (예정) Hilt, Room, Retrofit

## ▶️ 실행 방법
```bash
git clone https://github.com/1102june/Magnifier_Subway.git
