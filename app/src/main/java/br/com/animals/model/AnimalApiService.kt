package br.com.animals.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AnimalApiService {

    private val BASE_URL = "asdsad"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(AnimalApi::class.java)

    fun getApiKey(): Single<Apikey> {
        return api.getApiKey()
    }

    fun getAnimal(key: String): Single<List<Animal>> {
        return api.getAnimals(key)
    }


}