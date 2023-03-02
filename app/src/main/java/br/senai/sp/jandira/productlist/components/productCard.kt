package br.senai.sp.jandira.productlist.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.productlist.model.Product

@Composable
fun ProductCard(product: Product){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        backgroundColor = Color.Black
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = "${product.id}, ${product.productName}", fontSize = 16.sp,
                fontWeight = FontWeight.Bold, color = Color.White
            )
            Text(text = "${product.productDescription}", color = Color.White)


            Text(
                text = "${product.productPrice}",
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                color = Color.Magenta

            )
        }
    }
}