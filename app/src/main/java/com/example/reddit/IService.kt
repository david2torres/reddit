package com.example.reddit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface IService {
    @GET
    suspend fun getINformationReddit(@Url url:String): Response<response>
}