CREATE TABLE Cliente (
  Cpf VARCHAR(20) NOT NULL,
  nome VARCHAR(255) NOT NULL,
  telefone VARCHAR(45) NOT NULL,
  PRIMARY KEY(Cpf)
);

CREATE TABLE Funcionario (
  matricula VARCHAR(20) NOT NULL,
  nome VARCHAR(255)) NOT NULL,
  telefone VARCHAR(45) NOT NULL,
  PRIMARY KEY(matricula)
);

CREATE TABLE Voo (
  numero VARCHAR(20) NOT NULL,
  nroVagas INTEGER NULL,
  horaSaida VARCHAR(20) NULL,
  horaChegada VARCHAR(20) NULL,
  dataSaida VARCHAR(20) NULL,
  dataChegada VARCHAR(20) NULL,
  PRIMARY KEY(numero)
);

CREATE TABLE Aeroporto (
  codigo VARCHAR(20) NOT NULL,
  cidade VARCHAR(45) NOT NULL,
  PRIMARY KEY(codigo)
);

CREATE TABLE Reserva (
  codigo VARCHAR(20) NOT NULL,
  Cliente_Cpf VARCHAR(20) NOT NULL,
  PRIMARY KEY(codigo),
  FOREIGN KEY(Cliente_Cpf)
    REFERENCES Cliente(Cpf)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Aeroporto_Saida (
  Voo_numero VARCHAR(20) NOT NULL,
  Aeroporto_codigo VARCHAR(20) NOT NULL,
  PRIMARY KEY(Voo_numero, Aeroporto_codigo),
  FOREIGN KEY(Voo_numero)
    REFERENCES Voo(numero)
      ON DELETE CASCADE
      ON UPDATE NO ACTION,
  FOREIGN KEY(Aeroporto_codigo)
    REFERENCES Aeroporto(codigo)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);

CREATE TABLE Reserva_Voo (
  Reserva_codigo VARCHAR(20) NOT NULL,
  Voo_numero VARCHAR(20) NOT NULL,
  PRIMARY KEY(Reserva_codigo, Voo_numero),
  FOREIGN KEY(Reserva_codigo)
    REFERENCES Reserva(codigo)
      ON DELETE CASCADE
      ON UPDATE NO ACTION,
  FOREIGN KEY(Voo_numero)
    REFERENCES Voo(numero)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);

CREATE TABLE Aeroporto_Chegada (
  Voo_numero VARCHAR(20) NOT NULL,
  Aeroporto_codigo VARCHAR(20) NOT NULL,
  PRIMARY KEY(Voo_numero, Aeroporto_codigo),
  FOREIGN KEY(Voo_numero)
    REFERENCES Voo(numero)
      ON DELETE CASCADE
      ON UPDATE NO ACTION,
  FOREIGN KEY(Aeroporto_codigo)
    REFERENCES Aeroporto(codigo)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);


