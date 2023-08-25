package cl.jpvs.mod06ej08.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.jpvs.mod06ej08.data.Repositorio
import cl.jpvs.mod06ej08.data.local.RazaDatabase
import cl.jpvs.mod06ej08.data.remote.RazaRetrofit
import kotlinx.coroutines.launch

class RazaViewModel (application: Application): AndroidViewModel(application) {
    private val repositorio: Repositorio
 fun razaLiveData()= repositorio.obtenerRazaList()
    init {
        val api = RazaRetrofit.getRetrofitRaza()
        val razaDatabase = RazaDatabase.getDatabase(application).getRazaDao()
        repositorio = Repositorio(api,razaDatabase)
    }
    fun getAllRazas() = viewModelScope.launch {
        repositorio.getRazas()
    }
}