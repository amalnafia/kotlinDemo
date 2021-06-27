package com.example.kotlinStructure.data.repository


import androidx.lifecycle.MutableLiveData
import com.example.kotlinStructure.data.api.ApiInterface
import com.example.kotlinStructure.data.model.CovidData
import com.example.kotlinStructure.enums.ApiStatus
import com.example.kotlinStructure.util.Resource
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainRepository @Inject constructor(private val apiInterface: ApiInterface) {

    private val nationalDataMediatorLiveData: MutableLiveData<Resource<List<CovidData>>> =
        MutableLiveData<Resource<List<CovidData>>>()

    fun getNationalDataObserver(): MutableLiveData<Resource<List<CovidData>>> {
        return nationalDataMediatorLiveData
    }

    fun getNationalData() {
        apiInterface.getNationalData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getCovidDataListObserverRx())
    }

    private fun getCovidDataListObserverRx(): Observer<List<CovidData>> {
        return object : Observer<List<CovidData>> {
            override fun onComplete() {
            }

            override fun onError(e: Throwable) {
                nationalDataMediatorLiveData.value =
                    Resource(ApiStatus.ERROR, null, e.message)

            }

            override fun onNext(t: List<CovidData>) {
                nationalDataMediatorLiveData.value =     Resource(ApiStatus.SUCCESS, t, null)
            }

            override fun onSubscribe(d: Disposable) {
            }
        }
    }
}
