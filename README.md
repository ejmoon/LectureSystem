## 강연예약시스템
### JAVA 11, SpringBoot 2.7.1, MySQL 8.0.29   
#### Lombok, Mapstruct, Swagger  
***
**1. 도메인 관점 비즈니스 요구사항**
* 강연
  * Front
    * 신청 가능한 강연 목록 조회
  * BackOffice
    * 전체 강연 목록 조회
    * 신규 강연 등록
* 등록(강연신청)
  * Front
    * 강연 신청
    * 신청 내역 조회
  * BackOffice
    * 강연 신청자 목록 조회
  
**2. 데이터 설계**   
* ERD
![image](https://user-images.githubusercontent.com/41390496/178682368-24b9a5b3-7f47-41d5-9051-92962251ff1f.png)

**3. 패키지 구조**
* 컴포넌트 기반 패키지 구조   
  * 업무 도메인 파악에 유리
  * 캡슐화를 이용 하여 핵심 비즈니스 보호
    * controller 에서 repository(DAO) 직접 호출 불가. 비즈니스 로직은 오직 service 단에서 가능.
  * 업무 로직을 작성할 때 해당 컴포넌트만 이용     
![Class Diagrem](https://user-images.githubusercontent.com/41390496/178686773-0f11a69e-3cc7-4297-bc40-56a6c217b455.jpg)   
  * 현재 프로젝트는 다이어그램과 달리 service interface 는 생략하였음  
![image](https://user-images.githubusercontent.com/41390496/178703752-c67d17c3-ee3d-473e-b800-30de3c59ff65.png)


**4. 비즈니스 로직 구현**
* 강연 예약의 동시성 이슈   
강연 인원이 정해져 있어 동시성 이슈가 발생할 가능이 있음.   
회사 시스템을 감안해 해당 이슈는 적을 것으로 판단됨.   
해당 이슈는 MySQL SELECT FOR UPDATE 를 이용하여 특정 세션이 데이터에 대해 수정을 할 때까지 LOCK이 걸려 다른 세션이 데이터에 접근할 수 없게함.

**5. 스키마 & 데이터**
<pre>
<code>
CREATE DATABASE  IF NOT EXISTS `education` ;
USE `education`;

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employee_id` varchar(5) COLLATE utf8mb4_general_ci NOT NULL COMMENT '사원번호',
  `employee_seq` int unsigned NOT NULL AUTO_INCREMENT COMMENT '사원 SEQ',
  `status` int NOT NULL COMMENT '상태',
  PRIMARY KEY (`employee_seq`),
  UNIQUE KEY `employee_un` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='직원';
LOCK TABLES `employee` WRITE;
INSERT INTO `employee` VALUES ('A0001',1,1),('A0002',2,1),('A0003',3,1);
UNLOCK TABLES;

DROP TABLE IF EXISTS `enrollment`;
CREATE TABLE `enrollment` (
  `enrollment_seq` int unsigned NOT NULL AUTO_INCREMENT COMMENT '강연신청 SEQ',
  `lecture_seq` int unsigned NOT NULL COMMENT '강연 SEQ',
  `status` int NOT NULL COMMENT '신청 상태(1:신청,2:취소)',
  `employee_seq` int unsigned NOT NULL COMMENT '사원 SEQ',
  PRIMARY KEY (`enrollment_seq`),
  KEY `lecture_enrollment_fk` (`lecture_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='강연 신청 정보';

LOCK TABLES `enrollment` WRITE;
INSERT INTO `enrollment` VALUES (1,2,1,1),(2,3,1,1);
UNLOCK TABLES;

DROP TABLE IF EXISTS `lecture`;
CREATE TABLE `lecture` (
  `lecture_seq` int unsigned NOT NULL AUTO_INCREMENT COMMENT '강연 SEQ',
  `talker` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '강연자',
  `place` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '강연장',
  `capacity` int NOT NULL COMMENT '수용 인원',
  `empty_seat` int NOT NULL COMMENT '잔여 인원',
  `summary` varchar(500) COLLATE utf8mb4_general_ci NOT NULL COMMENT '강연내용',
  `schedule` datetime NOT NULL COMMENT '강연 시간',
  `status` int NOT NULL COMMENT '상태',
  PRIMARY KEY (`lecture_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='강연 정보';

LOCK TABLES `lecture` WRITE;
INSERT INTO `lecture` VALUES (1,'홍길동','대회의실1',30,25,'퍼포먼스 마케팅','2022-07-12 14:00:00',0),(2,'김연수','대회의실2',30,29,'B2B 세일즈 전략 및 관리','2022-07-15 17:00:00',0),(3,'송욱','대회의실3',50,27,'스피치 트레이닝','2022-07-18 20:00:00',0);
UNLOCK TABLES;

</pre>
</code>
