package com.aplicada2.apiretrofit.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.aplicada2.apiretrofit.model.Exchange
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import com.aplicada2.apiretrofit.network.ApiService
import kotlinx.coroutines.launch

class ExchangeViewModel: ViewModel() {

    var exchangeListResponse:List<Exchange> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getExchangeList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val exchangeList = apiService.getExchanges()
                exchangeListResponse = exchangeList
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}