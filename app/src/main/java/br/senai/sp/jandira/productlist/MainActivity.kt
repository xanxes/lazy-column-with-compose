package br.senai.sp.jandira.productlist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.productlist.components.ProductCard
import br.senai.sp.jandira.productlist.dao.repository.ProductRepository
import br.senai.sp.jandira.productlist.model.Product
import br.senai.sp.jandira.productlist.ui.theme.ProductListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var nameState by remember {
        mutableStateOf("")
    }

    var priceState by remember {
        mutableStateOf("")
    }

    var productState by remember {
        mutableStateOf(listOf<Product>())
    }

    val context = LocalContext.current

    var productRepository = ProductRepository(context)

    productState

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Lista com Jetpack Compose")

        OutlinedTextField(
            value = nameState,
            onValueChange = {
                nameState = it
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = priceState,
            onValueChange = {
                priceState = it
            },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            val p = Product(
                productName = nameState,
                productPrice = priceState.toDouble()
            )
            val newId = productRepository.save(p)
            Toast.makeText(context, "Created Product. ID: $newId", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Salvar")
        }

        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(productRepository.getProductList()) {
              ProductCard(product = it)
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ProductListTheme {
        Greeting("Android")
    }
}