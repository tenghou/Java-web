CREATE TABLE dep(
  did INT(5) PRIMARY KEY,
  dname VARCHAR(20),
  dno VARCHAR(2),
  daddr VARCHAR(30)
);

CREATE TABLE emp(
  eid INT(5) PRIMARY KEY,
  ename VARCHAR(20),
  eno VARCHAR(10),
  etel VARCHAR(11),
  einTime VARCHAR(20),
  etype INT(2),
  eupdateTime VARCHAR(20),
  edno VARCHAR(2)
);