package cl.jpvs.mod06ej08.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_razas")
class RazaEntity (val raza:String) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

}