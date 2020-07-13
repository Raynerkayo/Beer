package br.com.beer.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.beer.model.Cerveja;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CervejasDAO {

    @Query("SELECT * FROM Cerveja")
    public List<Cerveja> getAll();

    @Query("SELECT * FROM Cerveja WHERE name = :name")
    public List<Cerveja> getByName(String name);

    @Insert(onConflict = REPLACE)
    public void insertAll(List<Cerveja> cervejas);

    @Insert(onConflict = REPLACE)
    public void insert(Cerveja cerveja);

    @Update
    public void update(Cerveja cerveja);

    @Delete
    public void delete(Cerveja cerveja);

}
