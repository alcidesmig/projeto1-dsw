
create table Teatro (
    email varchar(256) not null,
    senha varchar(256) not null,
    endereco_url varchar(256) not null, 
    nome varchar(256) not null,
    telefone varchar(256) not null,   
    CONSTRAINT Teatro_PK PRIMARY KEY (email)
);

create table Sala ( 
    cnpj integer not null, 
    email varchar(256) not null,
    senha varchar(256) not null,
    nome varchar(256) not null,
    cidade varchar(256) not null,
    teatro_email varchar(256) references Teatro (email),
    CONSTRAINT Sala_PK PRIMARY KEY (cnpj)
);

create table Usuario (
    nickname varchar(256) not null,
    nome varchar(256) not null,
    grupo integer not null,
    senha varchar(512) not null,
    data_criacao date not null,
    CONSTRAINT Usuario_PK PRIMARY KEY (nickname)
);

create table Promocao (
    id_promocao integer not null generated always as identity (start with 1, increment by 1),
    nome_peca varchar(256) not null,
    preco double not null,
    datetime timestamp not null,
    endereco_url varchar(256) not null,
    cnpj_teatro integer references Sala(cnpj),
    CONSTRAINT Promocao_PK PRIMARY KEY (id_promocao)
);
