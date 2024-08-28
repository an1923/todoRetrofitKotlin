package com.anu.todoretrofit.network

import com.anu.todoretrofit.model.Todo
import com.anu.todoretrofit.model.TodoParent
import com.anu.todoretrofit.model.TodoPost
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TodoApi {

    @GET(value = "/v1/todos")
    suspend fun getTodos(): TodoParent

    @POST("/v1/todos")
    suspend fun createTodo(@Body todo: TodoPost)

    @DELETE("/v1/todos/{id}")
    suspend fun deleteTodo(@Path("id") id: String)

    @PUT("v1/todos/{id}")
    suspend fun updateTodo(@Path("id") id: String, @Body todo: TodoPost)
}