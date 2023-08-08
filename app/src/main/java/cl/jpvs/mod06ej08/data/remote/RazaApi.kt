package cl.jpvs.mod06ej08.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface RazaApi {
    @GET("breeds/list/all")
    suspend fun getData(): Response<Raza>
}