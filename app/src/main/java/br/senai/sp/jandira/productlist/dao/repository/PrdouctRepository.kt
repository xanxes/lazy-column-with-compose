package br.senai.sp.jandira.productlist.dao.repository

import android.content.Context
import br.senai.sp.jandira.productlist.dao.ProductDao
import br.senai.sp.jandira.productlist.dao.ProductDb
import br.senai.sp.jandira.productlist.model.Product

class ProductRepository(context: Context) {

    private val db = ProductDb.getDatabase(context).productDao()

    fun getProductList(): List<Product> {
        return db.getAll()
    }

    fun save(product: Product): Long {
        return db.save(product)
    }
}
