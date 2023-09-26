create database proj6;

create table Client(
owner text,fname text,sk text,mac text,dt text);

create table CloudServer(
owner text,fname text,sk text,mac text,dt text);

create table Attacker(fname text,maldata text,attacker text,dt text);

create table Blocked(fname text,ip text,dt text);

create table MetaData(
owner text,fname text,sk text,mac text,dt text);

create table keyexchange(dt text);
