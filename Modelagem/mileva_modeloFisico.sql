CREATE DATABASE Mileva;

USE Mileva;

CREATE TABLE Usuario 
( 
 Id_usuario INT PRIMARY KEY IDENTITY(1, 1),  
 Nome VARCHAR(50) NOT NULL,  
 Idade INT NOT NULL,  
 Email VARCHAR(50) NOT NULL,  
 Telefone VARCHAR(50) NOT NULL,  
); 

CREATE TABLE Viagem 
( 
 Id_viagem INT PRIMARY KEY IDENTITY(1, 1),  
 AeroportoPartida VARCHAR(50) NOT NULL,  
 AeroportoChegada VARCHAR(50) NOT NULL,  
 DataIda VARCHAR(50) NOT NULL,  
 DataVolta VARCHAR(50) NOT NULL,  
 Valor FLOAT NOT NULL,  
 UsuarioId_usuario INT,  
 DestinoId_destino INT,  
); 

CREATE TABLE Destino 
( 
 Id_destino INT PRIMARY KEY IDENTITY(1, 1),  
 CidadeDestino VARCHAR(50) NOT NULL,  
); 

ALTER TABLE Viagem ADD FOREIGN KEY(UsuarioId_usuario) REFERENCES Usuario (Id_usuario)
ALTER TABLE Viagem ADD FOREIGN KEY(DestinoId_destino) REFERENCES Destino (Id_destino)
