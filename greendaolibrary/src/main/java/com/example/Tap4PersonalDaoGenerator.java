package com.example;


import com.sun.corba.se.impl.oa.toa.TOA;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

public class Tap4PersonalDaoGenerator {

    public static void main(String args[]) throws Exception {

        Schema schema = new Schema(12, "com.example.mriogalvojnior.tap4personal.gen");
        schema.setDefaultJavaPackageTest("com.example.mriogalvojnior.tap4personal.gen.test");
        schema.setDefaultJavaPackageDao("com.example.mriogalvojnior.tap4personal.gen.dao");
        schema.enableKeepSectionsByDefault();

        Entity itemAluno = schema.addEntity("Aluno");
        itemAluno.addIdProperty().autoincrement();
        itemAluno.addStringProperty("nome");
        itemAluno.addStringProperty("idade");
        itemAluno.addStringProperty("sexo");
        itemAluno.addStringProperty("email");
        itemAluno.addStringProperty("telefone");
        itemAluno.addStringProperty("objetivo");
        itemAluno.addStringProperty("preco");
        itemAluno.addStringProperty("data");
        itemAluno.addStringProperty("daysforweek");
        itemAluno.addStringProperty("hour");

        Entity itemAtleta = schema.addEntity("Atleta");
        itemAtleta.addIdProperty().autoincrement();
        itemAtleta.addStringProperty("nome");
        itemAtleta.addStringProperty("categoria");
        itemAtleta.addStringProperty("treinador");

        Entity itemHistorico = schema.addEntity("Histotico");
        Property.PropertyBuilder itemHistoticoId = itemHistorico.addIdProperty().autoincrement();
        itemHistorico.addStringProperty("data");
        itemHistorico.addStringProperty("peso");
        itemHistorico.addStringProperty("altura");
        itemHistorico.addStringProperty("bf");
        itemHistorico.addStringProperty("bracodireito");
        itemHistorico.addStringProperty("bracoesquerdo");
        itemHistorico.addStringProperty("coxadireita");
        itemHistorico.addStringProperty("coxaesquerda");
        itemHistorico.addStringProperty("pantdireita");
        itemHistorico.addStringProperty("pantesquerda");
        itemHistorico.addStringProperty("torax");
        itemHistorico.addStringProperty("abdomen");
        itemHistorico.addStringProperty("cintura");
        itemHistorico.addStringProperty("quadril");
        itemHistorico.addStringProperty("antebracodireito");
        itemHistorico.addStringProperty("antebracoesquerdo");
        itemHistorico.addStringProperty("subescapular");
        itemHistorico.addStringProperty("tricipital");
        itemHistorico.addStringProperty("peitoral");
        itemHistorico.addStringProperty("axilarmedio");
        itemHistorico.addStringProperty("suprailiaca");
        itemHistorico.addStringProperty("abdominal");
        itemHistorico.addStringProperty("coxa");

        Entity itemTrofeus = schema.addEntity("Trofeus");
        itemTrofeus.addIdProperty().autoincrement();
        itemTrofeus.addStringProperty("colocacao");
        itemTrofeus.addStringProperty("campeonato");
        itemTrofeus.addStringProperty("ano");

        Entity itemPatologia = schema.addEntity("Patologia");
        itemPatologia.addIdProperty().autoincrement();
        itemPatologia.addStringProperty("nome");

        Entity itemDivisaTreino = schema.addEntity("DivisaoTreino");
        itemDivisaTreino.addIdProperty().autoincrement();
        itemDivisaTreino.addStringProperty("diadasemana");


        Property alunoDivisaoID = itemDivisaTreino.addLongProperty("alunoID").notNull().getProperty();
        ToMany itemDivisaoAluno = itemAluno.addToMany(itemDivisaTreino, alunoDivisaoID);
        itemDivisaoAluno.setName("divisaoTreinoAlunos");

        Property atletaId = itemTrofeus.addLongProperty("atletaID").notNull().getProperty();
        ToMany itemTrofeusAtletas = itemAtleta.addToMany(itemTrofeus, atletaId);
        itemTrofeusAtletas.setName("trofeusAtleta");

        Property userID =itemHistorico.addLongProperty("alunoID").notNull().getProperty();
        ToMany itemHistoricos = itemAluno.addToMany(itemHistorico, userID);
        itemHistoricos.setName("historicoAlunos");

        Property alunoID = itemPatologia.addLongProperty("alunoID").notNull().getProperty();
        ToMany itemPatologias = itemAluno.addToMany(itemPatologia, alunoID);
        itemPatologias.setName("patologiasAlunos");

        new DaoGenerator().generateAll(schema, "app/src/main/java");

    }
}

