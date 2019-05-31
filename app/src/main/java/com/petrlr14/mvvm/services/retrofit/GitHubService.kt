package com.petrl14.mvvm.services.retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.petrl14.mvvm.database.entities.GitHubRepo
import com.petrlr14.mvvm.database.entities.GitHubRepo
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

const val GITHUB_BASE_URL = "https://api.github.com/"

interface GithubService {
    @GET("/users/{user}/repos")
    fun getAllReposPerUSer(@Path("user")user: String):Deferred<Response<List<GitHubRepo>>>

    /*@POST("")
    @FormUrlEncoded
    fun funcion(@)*/

    companion object{
        fun getGithubServices(): GithubService = Retrofit.Builder()
            .baseUrl(GITHUB_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build().create(GithubService::class.java)
    }
}