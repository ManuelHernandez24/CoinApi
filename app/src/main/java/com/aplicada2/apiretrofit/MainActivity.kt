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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aplicada2.apiretrofit.model.Coin
import com.aplicada2.apiretrofit.ui.theme.ApiRetrofitTheme
import com.aplicada2.apiretrofit.view.CoinItem
import com.aplicada2.apiretrofit.viewModel.CoinViewModel

class MainActivity : ComponentActivity() {

    val coinViewModel by viewModels<CoinViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApiRetrofitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CoinList(coinList = coinViewModel.coinListResponse)
                    coinViewModel.getCoinList()

                }
            }
        }
    }
}

@Composable
fun CoinList(coinList: List<Coin>){
    LazyColumn{
        itemsIndexed(items = coinList){index, item ->
            CoinItem(coin = item)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ApiRetrofitTheme {
        val coin = Coin(1,"Bitcoin", 2000.00, "https://bitcoin.org/img/icons/opengraph.png?1656252469")
        CoinItem(coin = coin)
    }
}