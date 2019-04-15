/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.model;

/**
 *
 * @author alcides
 */
public class Usuario {
    private String nickname;
    private String nome;
    private String grupo;
}

//create table Usuario (
//    nickname varchar(256) not null,
//    nome varchar(256) not null,
//    grupo integer not null,
//    senha varchar(512) not null,
//    data_criacao date not null,
//    CONSTRAINT Usuario_PK PRIMARY KEY (nickname)
//);