

create table student(
no number primary key not null,
id nvarchar2(100) unique not null,
name nvarchar2(100) not null,
major nvarchar2(100) not null,
grade nvarchar2(100) not null,
gender nvarchar2(100) not null,
phone nvarchar2(100) not null,
email nvarchar2(100) not null,
address nvarchar2(100) not null,
regDate TIMESTAMP default current_timestamp
);


create sequence seq_student;

select * from student;


create table Examination(
no number primary key not null,
name nvarchar2(100) not null,
type nvarchar2(100) not null,
regDate timestamp default current_timestamp
);

create sequence seq_examination;

create table score(
no number primary key not null,
studentId nvarchar2(100) not null,
examNo number not null,
score number not null,
regDate timestamp default current_timestamp
);

create sequence seq_score;

alter table score add CONSTRAINT fk_studentID
   FOREIGN KEY (studentId)
   REFERENCES student(id);

alter table score add CONSTRAINT fk_examNo
   FOREIGN KEY (examNo)
   REFERENCES Examination(no);

alter table score add constraint uk_studentId_examNo unique(studentId,examNo);


select * from score;

create or replace view scoreView
as
select sc.studentId, sc.examno, sc.score, 
st.name studentName, ex.type examType, ex.name examName
from score sc, student st, examination ex
where sc.studentid=st.id and ex.no=sc.examno;

select * from scoreView;



