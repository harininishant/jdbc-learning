CREATE TABLE STUDENT(ID int, FIRST_NAME VARCHAR(255),
LAST_NAME VARCHAR(255),CREATE_DATE DATE,UPDATE_DATE DATE,STATUS VARCHAR(200));

INSERT INTO STUDENT VALUES(123,'RUTIKA','GULHANE',SYSDATE(),SYSDATE(),'ACTIVE');
INSERT INTO STUDENT VALUES(345,'KIRAN','KAUR',SYSDATE(),SYSDATE(),'ACTIVE');

CREATE TABLE COURSE(ID INT, NAME VARCHAR(100),DESCRIPTION VARCHAR (700),COURSE_FEES DOUBLE );

INSERT INTO COURSE VALUES(1,'FullStackJava','A salary study from Indeed.ca reports that an average full stack developer in Toronto earns nearly $110,000 annually, compared to a web developer who makes about $75,000.Freelance Java Developers also make a lot more annually than any other freelancers. Which puts Java Developers in high demand, and makes it another lucrative career worth considering.',10000);
INSERT INTO COURSE VALUES(2,'Frontend Developer','A salary study from Indeed.ca reports that an average full stack developer in Toronto earns nearly $110,000 annually, compared to a web developer who makes about $75,000.Freelance Java Developers also make a lot more annually than any other freelancers. Which puts Java Developers in high demand, and makes it another lucrative career worth considering.',10000);
