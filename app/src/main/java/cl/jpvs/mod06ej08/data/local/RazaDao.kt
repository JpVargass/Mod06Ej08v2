package cl.jpvs.mod06ej08.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RazaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRaza(razaEntity: RazaEntity)

    @Query("Select * from tabla_razas order by raza desc")
    fun getRazas() : LiveData<List<RazaEntity>>
}