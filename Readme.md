# 프로젝트 리팩토링

[기존 프로젝트](https://github.com/thwang26/bitcampProject)의 Jsp, Spring, Mybatis 구조에서 Spring Boot를 활용한 
Rest Api, Jpa로 리팩토링 한 프로젝트

[![Build Status](https://app.travis-ci.com/thwang26/Bitcafe.svg?branch=main)](https://app.travis-ci.com/thwang26/Bitcafe)
---

Commit Message Convention

* feat : 새로운 기능 추가
* fix : 버그 수정
* docs : 문서 수정
* refactor : 코드 리팩토링
* test : 테스트코드

메세지 구조
1. Subject
* 개조식 구문으로 요점만 작성

2. Body
* 어떻게 변경하거나 추가하였는지 작성

예시

Feat: 회원 가입 기능 구현

SMS, 이메일 중복확인 API 개발

---

Git Branch Strategy

main 브랜치에서 배포를 하고, 기능개발 시 feature/... 의 브랜치 명을 사용하여 개발이 완료되면 main과 merge
