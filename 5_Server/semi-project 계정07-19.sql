ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER semiProject_mgm IDENTIFIED BY semiProject1234;

ALTER USER semiProject_mgm DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;

GRANT CONNECT, RESOURCE,CREATE VIEW TO semiProject_mgm;
