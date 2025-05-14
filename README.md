# ToyLogin
AboutSessionLogin

세션 로그인 <br>
1. @SessionAttribute, HttpSession 차이

2. Spring 인터셉터 기반 인증 흐름 설계  
   - 인터셉터 적용 완료  
    기존 controller 로그인 체크가 중복되어 지저분했던 점을   
   인터셉터 도입을 통해 코드를 옮겨서 컨트롤러 코드를  
   깔끔하게 정리하게 됨 
    
4. 필터 vs 인터셉터 vs AOP 구조 비교

5. 세션 저장소 외부화 (Redis 세션 클러스터링)

6. OAuth, JWT와의 차이 비교

7. 실무에서 세션을 다루는 패턴

8. 로그인 실패 / 세션 만료 시 UX 처리 방식

9. JSESSIONID 쿠키의 설정 전략 (SameSite, Secure, HttpOnly)

10. 테스트 코드에서 세션 처리 방법 (MockMvc 등)

11. 트러블슈팅 사례 모음: 세션 유실, 세션 중복, 세션 충돌
