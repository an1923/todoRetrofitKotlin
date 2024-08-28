package com.anu.todoretrofit

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.anu.todoretrofit.ui.ScreenHome
import com.anu.todoretrofit.ui.TodoViewModel

@Composable
fun TodoApp(innerPadding: PaddingValues) {
    Log.i("todoapp", "hi")
    ScreenHome(innerPadding = innerPadding, viewModel = TodoViewModel())
}