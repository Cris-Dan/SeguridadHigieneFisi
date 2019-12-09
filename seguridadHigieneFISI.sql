create database seguridadhigienefisi;
use seguridadhigienefisi;
create table user(
	id int primary key auto_increment,
    firstname varchar(50),
    lastname varchar(50),
    password varchar(50),
    email varchar(100) unique
);

create table administrator(
	id int primary key auto_increment,
    idUser int unique,
    foreign key(idUser) references user(id)
);
/*quitar nicknames*/
create table employee(
	id int primary key auto_increment,
    age int,
    genre varchar(50),
    healthCondition varchar(200),
    idUser int unique,
    foreign key(idUser) references user(id)
);

CREATE TABLE task (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titleTask VARCHAR(50),
    descriptionTask VARCHAR(200),
    idEmployee INT UNIQUE,
    FOREIGN KEY (idEmployee)
        REFERENCES employee (id)
);

create table incident(
	id int primary key auto_increment,
    descriptionIncident varchar(200),	
    incidentType varchar(50),
    idTask int unique,
    foreign key(idTask) references task(id)
);

#CRUD ADMINISTRATOR#

delimiter //
create procedure getAdministrator(in inId int)
begin
select administrator.id,firstname,lastname,password,email 
		from administrator,user 
        where idUser = user.id and administrator.id = inId;
end
// delimiter ;
##call getAdministrator(2);

delimiter //
create procedure getAllAdministrators()
begin
select administrator.id,firstname,lastname,password,email 
		from administrator,user 
        where idUser = user.id;
end
// delimiter ;
##call getAllAdministrators();


delimiter //
create procedure saveAdministrator(
		in inFirstname varchar(50),
        in  inLastname varchar(50),
		in  inPassword varchar(50),
        in  inEmail varchar(100))
begin

DECLARE idUserTemp INT DEFAULT 0;

insert into user(firstname,lastname,password,email) values(inFirstname,inLastname,inPassword,inEmail);

select id from user where user.email=inEmail into idUserTemp;

insert into administrator(idUser) values (idUserTemp);

end
// delimiter ;
##call saveAdministrator('uwu','owo','ewe','awa');

delimiter //
create procedure updateAdministrator(
		in inId int,
		in inFirstname varchar(50),
        in  inLastname varchar(50),
		in  inPassword varchar(50),
        in  inEmail varchar(100)
)
begin

DECLARE idUserTemp INT DEFAULT 0;

select idUser from administrator where id=inId into idUserTemp;

update user 
		set firstname = inFirstname, lastname = inLastname, password = inPassword, email = inEmail 
        where id = idUserTemp;
end
// delimiter ;
##call updateAdministrator(1,'iwi','owo','ewea','awaa');

delimiter //
create procedure deleteAdministrator(in inId int)
begin

DECLARE idUserTemp INT DEFAULT 0;

select idUser from administrator where id=inId into idUserTemp;

delete from administrator where id = inId;
delete from user where id = idUserTemp;
end
// delimiter ;
##call deleteAdministrator(1);










#CRUD EMPLOYEE#

delimiter //
create procedure getEmployee(in inId int)
begin
select employee.id,firstname,lastname,password,email,age,genre,healthCondition 
		from employee,user 
        where idUser = user.id and employee.id = inId;
end
// delimiter ;
##call getEmployee(1);

delimiter //
create procedure getAllEmployees()
begin
select employee.id,firstname,lastname,password,email,age,genre,healthCondition 
		from employee,user 
        where idUser = user.id;
end
// delimiter ;
##call getAllEmployees();


delimiter //
create procedure saveEmployee(
		in inFirstname varchar(50),
        in  inLastname varchar(50),
		in  inPassword varchar(50),
        in  inEmail varchar(100),
        in inAge int,
		in inGenre varchar(50),
		in inHealthCondition varchar(200)
        )
begin

DECLARE idUserTemp INT DEFAULT 0;

insert into user(firstname,lastname,password,email) values(inFirstname,inLastname,inPassword,inEmail);

select id from user where user.email=inEmail into idUserTemp;

insert into employee(idUser,age,genre,healthCondition) values (idUserTemp,inAge,inGenre,inHealthCondition);

end
// delimiter ;
##call saveEmployee('uwu','owo','ewe','agua',12,'masculino','depresivo');

delimiter //
create procedure updateEmployee(
		in inId int,
		in inFirstname varchar(50),
        in  inLastname varchar(50),
		in  inPassword varchar(50),
        in  inEmail varchar(100),
        in inAge int,
		in inGenre varchar(50),
		in inHealthCondition varchar(200)
)
begin

DECLARE idUserTemp INT DEFAULT 0;

select idUser from employee where id=inId into idUserTemp;

update user 
		set firstname = inFirstname, lastname = inLastname, password = inPassword, email = inEmail 
        where id = idUserTemp;
        
update employee
		set age =inAge, genre = inGenre, healthCondition=inHealthCondition
        where id = inId;
end
// delimiter ;
##call updateEmployee(1,'uwu','owo','ewe','agua',12,'mujer','depresivo');


delimiter //
create procedure deleteEmployee(in inId int)
begin

DECLARE idUserTemp INT DEFAULT 0;

select idUser from employee where id=inId into idUserTemp;

delete from employee where id = inId;
delete from user where id = idUserTemp;
end
// delimiter ;
##call deleteEmployee(1);










#CRUD TASK#

delimiter //
create procedure getTask(in inId int)
begin
select id,titleTask,descriptionTask,idEmployee 
		from Task 
        where id = inId;
end
// delimiter ;
##call getTask(1);

delimiter //
create procedure getAllTasks()
begin
select id,titleTask,descriptionTask,idEmployee 
		from Task;
end
// delimiter ;
##call getAllAdministrators();


delimiter //
create procedure saveTask(
		in inTitleTask varchar(50),
        in  inDescriptionTask varchar(200),
		in  inIdEmployee int)
begin

insert into task(titleTask,descriptionTask,idEmployee) values(inTitleTask,inDescriptionTask,inIdEmployee);

end
// delimiter ;
##call saveTask('webeo','Cabrera es mejor',1);

delimiter //
create procedure updateTask(
		in inId int,
		in inTitleTask varchar(50),
        in  inDescriptionTask varchar(200),
		in  inIdEmployee int
)
begin

update task 
		set titleTask = inTitleTask, descriptionTask = inDescriptionTask, idEmployee = inIdEmployee
        where id = inId;
end
// delimiter ;
##call updateTask(1,'puta','vida',3);


delimiter //
create procedure deleteTask(in inId int)
begin

delete from task where id = inId;

end
// delimiter ;
##call deleteTask(1);








#CRUD INCIDENT#

delimiter //
create procedure getIncident(in inId int)
begin
select id,descriptionIncident,incidentType,idTask
		from incident 
        where id = inId;
end
// delimiter ;
##call getIncident(1);

delimiter //
create procedure getAllIncidents()
begin
select id,descriptionIncident,incidentType,idTask
		from incident;
end
// delimiter ;
##call getAllIncidents();


delimiter //
create procedure saveIncident(
		in  inDescriptionIncident varchar(200),
        in  inIncidentType varchar(50),
		in  inIdTask int)
begin

insert into incident(descriptionIncident,incidentType,idTask) values(inDescriptionIncident,inIncidentType,inIdTask);

end
// delimiter ;
##call saveIncident('mas webeo','salud',1);

delimiter //
create procedure updateIncident(
		in inId int,
		in  inDescriptionIncident varchar(200),
        in  inIncidentType varchar(50),
		in  inIdTask int)
begin

update incident 
		set descriptionIncident = inDescriptionIncident, incidentType = inIncidentType, idTask = inIdTask
        where id = inId;
end
// delimiter ;
##call updateTask(1,'puta','vida',3);


delimiter //
create procedure deleteIncident(in inId int)
begin

delete from incident where id = inId;

end
// delimiter ;
##call deleteTask(1);






