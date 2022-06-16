-- tạo bảng người lái
create table driver(
   id number primary key,
   fullName nvarchar2(100) not null,
   address nvarchar2(50) not null,
   phone nvarchar2(20) not null,
   levele nvarchar2(20) not null
);
-- tăng bảng driver
CREATE SEQUENCE driver_id_seq
    START WITH 10000
    MAXVALUE 99990
    MINVALUE 10000
    CYCLE
    NOCACHE
      NOORDER;

CREATE TRIGGER driver_auto_id
    BEFORE INSERT ON driver
    FOR EACH ROW
BEGIN
    SELECT driver_id_seq.nextval
    INTO :new.id
    FROM dual;
END;

-- tạo bảng tuyến 
create table route (
   id number primary key,
   distance number not null, -- khoảng cach
   numberOfStops  number not null -- điểm dừng
);
-- tăng bảng tuyến      
CREATE SEQUENCE route_id_req
    START WITH 100
    MAXVALUE 999
    MINVALUE 100
    CYCLE
    NOCACHE
      NOORDER;

CREATE TRIGGER route_auto_id
    BEFORE INSERT ON route
    FOR EACH ROW
BEGIN
    SELECT route_id_req.nextval
    INTO :new.id
    FROM dual;
END;

-- detail route
create table detailroute (
     id number primary key,
     route_id number not null constraint route_id references route(id),
     route_distance number not null,
     route_numberOfStops number not null,
     numberOfTurns number not null
);
-- tăng id 
CREATE SEQUENCE detail_route_id_req
    START WITH 100
    MAXVALUE 999
    MINVALUE 100
    CYCLE
    NOCACHE
      NOORDER;

CREATE TRIGGER detail_route_auto_id
    BEFORE INSERT ON detailroute
    FOR EACH ROW
BEGIN
    SELECT detail_route_id_req.nextval
    INTO :new.id
    FROM dual;
END;

-- tạo bảng phân công 
create table assignment(
   id number primary key,
   driver_id number not null constraint driver_id references driver(id),
   driver_fullName nvarchar2(50) not null,
   driver_address nvarchar2(50) not null,
   driver_phone nvarchar2(50) not null,
   driver_levele nvarchar2(50) not null,
   detail_route number not null constraint detail_route references detailroute(id),
   route_id number not null ,
   route_distance number not null,
   route_numberOfStops number not null, -- số điểm dừng
   numberOfTurns number not null -- số lượt
);
-- tăng id
CREATE SEQUENCE assignment_id_req
    START WITH 100
    MAXVALUE 999
    MINVALUE 100
    CYCLE
    NOCACHE
      NOORDER;

CREATE TRIGGER assignment_auto_id
    BEFORE INSERT ON assignment
    FOR EACH ROW
BEGIN
    SELECT assignment_id_req.nextval
    INTO :new.id
    FROM dual;
END;
----------------------------------------------------------------------------
-------------- xóa--------------------
--
--    DROP table route;
--    DROP table driver;
--    DROP table assignment;
--    DROP table detailroute;
--      --


----------------------------------------------------------------------------
---------------------------insert -----------------------------------------

insert into route(distance,numberOfStops) values (12, 11);

insert into driver(fullName,address,phone,levele) values ( n'phong', n'hanoi', n'096218371', 'A');

insert into detailroute(route_id,route_distance,route_numberOfStops,numberOfTurns) values (103, 21, 11,2);

insert into assignment(driver_id,driver_fullName,driver_address,driver_phone,driver_levele, detail_route,route_id,route_distance,route_numberOfStops,numberOfTurns)
values (  10001,n'hong', n'hanoi', n'096218371', 'A' ,100, 103, 21, 11,2);

------------------------------------------------------------------------------

select * from route;
select * from driver;
select * from detailroute;
select * from assignment;



