package com.example.mriogalvojnior.tap4personal.gen.dao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.example.mriogalvojnior.tap4personal.gen.DivisaoTreino;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DIVISAO_TREINO".
*/
public class DivisaoTreinoDao extends AbstractDao<DivisaoTreino, Long> {

    public static final String TABLENAME = "DIVISAO_TREINO";

    /**
     * Properties of entity DivisaoTreino.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Diadasemana = new Property(1, String.class, "diadasemana", false, "DIADASEMANA");
        public final static Property AlunoID = new Property(2, long.class, "alunoID", false, "ALUNO_ID");
    };

    private Query<DivisaoTreino> aluno_DivisaoTreinoAlunosQuery;

    public DivisaoTreinoDao(DaoConfig config) {
        super(config);
    }
    
    public DivisaoTreinoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DIVISAO_TREINO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"DIADASEMANA\" TEXT," + // 1: diadasemana
                "\"ALUNO_ID\" INTEGER NOT NULL );"); // 2: alunoID
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DIVISAO_TREINO\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, DivisaoTreino entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String diadasemana = entity.getDiadasemana();
        if (diadasemana != null) {
            stmt.bindString(2, diadasemana);
        }
        stmt.bindLong(3, entity.getAlunoID());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public DivisaoTreino readEntity(Cursor cursor, int offset) {
        DivisaoTreino entity = new DivisaoTreino( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // diadasemana
            cursor.getLong(offset + 2) // alunoID
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, DivisaoTreino entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDiadasemana(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAlunoID(cursor.getLong(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(DivisaoTreino entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(DivisaoTreino entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "divisaoTreinoAlunos" to-many relationship of Aluno. */
    public List<DivisaoTreino> _queryAluno_DivisaoTreinoAlunos(long alunoID) {
        synchronized (this) {
            if (aluno_DivisaoTreinoAlunosQuery == null) {
                QueryBuilder<DivisaoTreino> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.AlunoID.eq(null));
                aluno_DivisaoTreinoAlunosQuery = queryBuilder.build();
            }
        }
        Query<DivisaoTreino> query = aluno_DivisaoTreinoAlunosQuery.forCurrentThread();
        query.setParameter(0, alunoID);
        return query.list();
    }

}