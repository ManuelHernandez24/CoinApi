package com.aplicada2.apiretrofit.view

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
import com.aplicada2.apiretrofit.model.Exchange
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun ExchangeItem(exchange: Exchange){
    Card(modifier = Modifier.padding(8.dp,4.dp).fillMaxWidth().height(110.dp),shape = RoundedCornerShape(8.dp), elevation = 4.dp){
        Surface(){
            Row(Modifier.padding(4.dp).fillMaxSize()) {Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxHeight()
                    .weight(0.8f)
            ) {
                Text(
                    text = exchange.name,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = exchange.last_updated,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .background(
                            Color.LightGray
                        )
                        .padding(4.dp)
                )
                Text(
                    text = exchange.description,
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                val estado: String
                if(exchange.active){
                    estado = "Activo"
                }else{
                    estado = "Inactivo"
                }
                Text(
                    text = estado,
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis
                )

            }
            }
        }
    }

}