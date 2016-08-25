package com.example.mriogalvojnior.tap4personal.gen.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.example.mriogalvojnior.tap4personal.gen.Aluno;
import com.example.mriogalvojnior.tap4personal.gen.Atleta;
import com.example.mriogalvojnior.tap4personal.gen.Histotico;
import com.example.mriogalvojnior.tap4personal.gen.Trofeus;
import com.example.mriogalvojnior.tap4personal.gen.Patologia;
import com.example.mriogalvojnior.tap4personal.gen.DivisaoTreino;

import com.example.mriogalvojnior.tap4personal.gen.dao.AlunoDao;
import com.example.mriogalvojnior.tap4personal.gen.dao.AtletaDao;
import com.example.mriogalvojnior.tap4personal.gen.dao.HistoticoDao;
import com.example.mriogalvojnior.tap4personal.gen.dao.TrofeusDao;
import com.example.mriogalvojnior.tap4personal.gen.dao.PatologiaDao;
import com.example.mriogalvojnior.tap4personal.gen.dao.DivisaoTreinoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig alunoDaoConfig;
    private final DaoConfig atletaDaoConfig;
    private final DaoConfig histoticoDaoConfig;
    private final DaoConfig trofeusDaoConfig;
    private final DaoConfig patologiaDaoConfig;
    private final DaoConfig divisaoTreinoDaoConfig;

    private final AlunoDao alunoDao;
    private final AtletaDao atletaDao;
    private final HistoticoDao histoticoDao;
    private final TrofeusDao trofeusDao;
    private final PatologiaDao patologiaDao;
    private final DivisaoTreinoDao divisaoTreinoDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        alunoDaoConfig = daoConfigMap.get(AlunoDao.class).clone();
        alunoDaoConfig.initIdentityScope(type);

        atletaDaoConfig = daoConfigMap.get(AtletaDao.class).clone();
        atletaDaoConfig.initIdentityScope(type);

        histoticoDaoConfig = daoConfigMap.get(HistoticoDao.class).clone();
        histoticoDaoConfig.initIdentityScope(type);

        trofeusDaoConfig = daoConfigMap.get(TrofeusDao.class).clone();
        trofeusDaoConfig.initIdentityScope(type);

        patologiaDaoConfig = daoConfigMap.get(PatologiaDao.class).clone();
        patologiaDaoConfig.initIdentityScope(type);

        divisaoTreinoDaoConfig = daoConfigMap.get(DivisaoTreinoDao.class).clone();
        divisaoTreinoDaoConfig.initIdentityScope(type);

        alunoDao = new AlunoDao(alunoDaoConfig, this);
        atletaDao = new AtletaDao(atletaDaoConfig, this);
        histoticoDao = new HistoticoDao(histoticoDaoConfig, this);
        trofeusDao = new TrofeusDao(trofeusDaoConfig, this);
        patologiaDao = new PatologiaDao(patologiaDaoConfig, this);
        divisaoTreinoDao = new DivisaoTreinoDao(divisaoTreinoDaoConfig, this);

        registerDao(Aluno.class, alunoDao);
        registerDao(Atleta.class, atletaDao);
        registerDao(Histotico.class, histoticoDao);
        registerDao(Trofeus.class, trofeusDao);
        registerDao(Patologia.class, patologiaDao);
        registerDao(DivisaoTreino.class, divisaoTreinoDao);
    }
    
    public void clear() {
        alunoDaoConfig.getIdentityScope().clear();
        atletaDaoConfig.getIdentityScope().clear();
        histoticoDaoConfig.getIdentityScope().clear();
        trofeusDaoConfig.getIdentityScope().clear();
        patologiaDaoConfig.getIdentityScope().clear();
        divisaoTreinoDaoConfig.getIdentityScope().clear();
    }

    public AlunoDao getAlunoDao() {
        return alunoDao;
    }

    public AtletaDao getAtletaDao() {
        return atletaDao;
    }

    public HistoticoDao getHistoticoDao() {
        return histoticoDao;
    }

    public TrofeusDao getTrofeusDao() {
        return trofeusDao;
    }

    public PatologiaDao getPatologiaDao() {
        return patologiaDao;
    }

    public DivisaoTreinoDao getDivisaoTreinoDao() {
        return divisaoTreinoDao;
    }

}