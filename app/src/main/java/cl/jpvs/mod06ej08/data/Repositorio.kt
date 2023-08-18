package cl.jpvs.mod06ej08.data

import cl.jpvs.mod06ej08.data.local.RazaDao
import cl.jpvs.mod06ej08.data.local.RazaEntity
import cl.jpvs.mod06ej08.data.remote.RazaApi

class Repositorio(private val razaApi: RazaApi, private val  razaDao: RazaDao) {
suspend fun  getRazas() {
    val response = razaApi.getData() //consumiendo info de la Api
    if(response.isSuccessful) {
       val message = response.body()!!.message  //los !! significa que puede ser nulo
        val keys = message.keys
        keys.forEach{
            val razaEntity = RazaEntity(it)
            razaDao.insertRaza(razaEntity)
        }

    }
}
}