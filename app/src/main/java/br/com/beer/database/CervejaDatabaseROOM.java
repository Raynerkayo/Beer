package br.com.beer.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.com.beer.dao.CervejasDAO;
import br.com.beer.model.Cerveja;

@Database(entities = {Cerveja.class}, version = 1)
public abstract class CervejaDatabaseROOM extends RoomDatabase {

    private static CervejaDatabaseROOM cervejaDatabaseROOM;

    public abstract CervejasDAO createCervejaDAO();

    //context classe abstrata que herda a roomdatabase, no caso, essa classe(CervejaDatabaseROOM), é a context.
    //fallbackToDestructiveMigration(), caso mude a versão do banco de dados, ele vai apagar todos os dados
    //anteriores. Para essa versão, vai ficar assim, para acelerar o dev. E tbm, não haverá incremento de colunas na tabela.
    //allowMainThreadQueries, para executar threads simultaneas. Para evitar erro, de ao buscar no banco
    //o app não mostrar dados e fechar.
    public static CervejaDatabaseROOM getInstance(Context context) {
        if(cervejaDatabaseROOM == null) {
            cervejaDatabaseROOM = Room.databaseBuilder(context.getApplicationContext(), CervejaDatabaseROOM.class, "cerveja.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }

        return cervejaDatabaseROOM;
    }

}
