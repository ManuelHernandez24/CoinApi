package com.aplicada2.apiretrofit


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aplicada2.apiretrofit.model.Exchange
import com.aplicada2.apiretrofit.ui.theme.ApiRetrofitTheme
import com.aplicada2.apiretrofit.view.ExchangeItem
import com.aplicada2.apiretrofit.viewModel.ExchangeViewModel

class MainActivity : ComponentActivity() {

    val exchangeViewModel by viewModels<ExchangeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApiRetrofitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ExchangeList(exchangeList = exchangeViewModel.exchangeListResponse)
                    exchangeViewModel.getExchangeList()

                }
            }
        }
    }
}

@Composable
fun ExchangeList(exchangeList: List<Exchange>){
    LazyColumn{
        itemsIndexed(items = exchangeList){index, item ->
            ExchangeItem(exchange = item)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ApiRetrofitTheme {
        val exchange = Exchange("Victor Manuel","Ejemplo de descripcion.", true, "24/07/2002")
        ExchangeItem(exchange = exchange)
    }
}