create table SiteDeVenda (
    email varchar(256) not null,
    senha varchar(256) not null,
    url varchar(256) not null, 
    nome varchar(256) not null,
    telefone varchar(256) not null,
    CONSTRAINT SiteDeVenda_PK PRIMARY KEY (email)
);

 create table SalaDeTeatro ( 
    cnpj varchar(256) not null, 
    email varchar(256) not null,
    senha varchar(256) not null,
    nome varchar(256) not null,
    cidade varchar(256) not null,
    teatro_email varchar(256) references SiteDeVenda (email),
    CONSTRAINT SalaDeTeatro_PK PRIMARY KEY (cnpj)
);


create table Papel (
    id integer not null generated always as identity (start with 1, increment by 1),
    email varchar(50) not null,
    nome varchar(50) not null,
    constraint Papel_PK PRIMARY KEY (id)
);

 create table Usuario (
    email varchar(256) not null,
    nome varchar(256) not null,
    papel_id integer references Papel(id),
    senha varchar(512) not null,
    data_criacao date not null,
    ativo boolean,
    token varchar(512),
    CONSTRAINT Usuario_PK PRIMARY KEY (email)
);

 create table Promocao (
    id_promocao integer not null generated always as identity (start with 1, increment by 1),
    nome_peca varchar(256) not null,
    preco double not null,
    datetime varchar(45) not null,
    endereco_url varchar(256) not null,
    cnpj_teatro varchar(256) references SalaDeTeatro(cnpj),
    CONSTRAINT Promocao_PK PRIMARY KEY (id_promocao)
);

