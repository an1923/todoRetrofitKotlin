package com.anu.todoretrofit.network

import com.anu.todoretrofit.model.Todo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TodoApi {

    @GET(value = "/todos")
    suspend fun getTodos(): List<Todo>

    @POST("posts")
    suspend fun createTodo(@Body todo: Todo)
}