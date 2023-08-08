package cl.jpvs.mod06ej08.data.remote

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RazaRetrofit {
    companion object{
        private const val URL_BASE = "https://dog.ceo/api/"

        fun getRetrofitRaza() : RazaApi {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory((GsonConverterFactory.create()))
                .build()
            return mRetrofit.create(RazaApi::class.java)
        }
    }
}