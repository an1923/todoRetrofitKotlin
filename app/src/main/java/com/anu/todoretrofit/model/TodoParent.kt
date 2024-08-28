package com.anu.todoretrofit.model

data class TodoParent(
    val code: Int = 200,
    val success: Boolean = true,
    val timestamp: Long = 1724826077098,
    val message: String = "Paginated Response",
    val items : List<Todo>
)