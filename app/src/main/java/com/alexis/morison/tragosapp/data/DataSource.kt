package com.alexis.morison.tragosapp.data

import com.alexis.morison.tragosapp.data.model.Drink
import com.alexis.morison.tragosapp.vo.Resource

class DataSource {

    fun generateDrinkList(): Resource<List<Drink>> {

        val list = listOf(
            Drink(
                "https://cocina-casera.com/wp-content/uploads/2017/11/C%C3%B3ctel-Margarita.jpg",
                "Margarita",
                "Azucar, Vodka y limon"
            ),

            Drink(
                "https://franchoxbar.files.wordpress.com/2018/07/img_20180630_181858_826.jpg",
                "Fernet",
                "Fernet Branca, CocaCola y 2 Hielos"
            ),

            Drink(
                "https://pbs.twimg.com/media/CERSHJwXIAATqjl.jpg",
                "Toro",
                "Vino Toro con Pritty"
            ),

            Drink(
                "https://http2.mlstatic.com/D_NQ_NP_699758-MLA40244846188_122019-O.jpg",
                "Gancia",
                "Gancia con Sprite y 3 hielos"
            ),

            Drink(
                "https://cocina-casera.com/wp-content/uploads/2017/11/C%C3%B3ctel-Margarita.jpg",
                "Margarita",
                "Azucar, Vodka y limon"
            ),

            Drink(
                "https://franchoxbar.files.wordpress.com/2018/07/img_20180630_181858_826.jpg",
                "Fernet",
                "Fernet Branca, CocaCola y 2 Hielos"
            ),

            Drink(
                "https://pbs.twimg.com/media/CERSHJwXIAATqjl.jpg",
                "Toro",
                "Vino Toro con Pritty"
            ),

            Drink(
                "https://http2.mlstatic.com/D_NQ_NP_699758-MLA40244846188_122019-O.jpg",
                "Gancia",
                "Gancia con Sprite y 3 hielos"
            ),

            Drink(
                "https://cocina-casera.com/wp-content/uploads/2017/11/C%C3%B3ctel-Margarita.jpg",
                "Margarita",
                "Azucar, Vodka y limon"),

            Drink(
                "https://franchoxbar.files.wordpress.com/2018/07/img_20180630_181858_826.jpg",
                "Fernet",
                "Fernet Branca, CocaCola y 2 Hielos"),

            Drink(
                "https://pbs.twimg.com/media/CERSHJwXIAATqjl.jpg",
                "Toro",
                "Vino Toro con Pritty"),

            Drink(
                "https://http2.mlstatic.com/D_NQ_NP_699758-MLA40244846188_122019-O.jpg",
                "Gancia",
                "Gancia con Sprite y 3 hielos"),
        )

        return Resource.Success(list)
    }
}