package ipca.edjd.idomtest.models;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ZoneDao {

    @Query("SELECT * FROM zone")
    LiveData<List<Zone>> getAll();

    @Query("SELECT * FROM zone WHERE id IN (:zoneIds)")
    LiveData<List<Zone>> loadAllByIds(String[] zoneIds);

    @Query("SELECT * FROM zone WHERE id = :id")
    Zone get(String id);

    @Query("DELETE FROM zone")
    void deleteAll();

    @Insert
    void insertAll(Zone... zones);

    @Insert
    void insert(Zone zone);

    @Update
    void update(Zone zone);

    @Delete
    void delete(Zone zone);



}
