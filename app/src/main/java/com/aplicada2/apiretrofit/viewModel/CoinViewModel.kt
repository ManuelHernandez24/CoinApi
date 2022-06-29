package com.aplicada2.apiretrofit.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.aplicada2.apiretrofit.model.Coin
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import com.aplicada2.apiretrofit.network.ApiService
import kotlinx.coroutines.launch

class CoinViewModel: ViewModel() {

    var coinListResponse:List<Coin> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getCoinList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val coinList = apiService.getCoins()
                coinListResponse = coinList
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}