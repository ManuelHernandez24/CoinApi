package com.aplicada2.apiretrofit.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aplicada2.apiretrofit.model.Coin
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.base.R
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation

@Composable
fun CoinItem(coin: Coin){
    Card(modifier = Modifier.padding(0.dp,4.dp).fillMaxWidth().height(80.dp),shape = RoundedCornerShape(3.dp), elevation = 4.dp){
        Surface(){
            Row(Modifier.padding(2.dp).fillMaxSize()) {Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(2.dp)
                    .fillMaxHeight()
                    .weight(0.8f)
            ) {
Row{
    Image(
        painter = rememberImagePainter(
            data = coin.ImageUrl,

            builder = {
                scale(Scale.FILL)
                placeholder(coil.compose.base.R.drawable.notification_action_background)
                transformations(CircleCropTransformation())

            }
        ),
        contentDescription = coin.Descripcion,
        modifier = Modifier
            .fillMaxHeight()
            .weight(0.4f)
    )


    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(4.dp)
            .fillMaxHeight()
            .weight(0.8f)
    ) {
        Text(
            text = coin.Descripcion,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold
        )
        Text(
            text ="${coin.Valor}USD$",
            style = MaterialTheme.typography.subtitle1
        )
    }
}

            }
            }
        }
    }

}