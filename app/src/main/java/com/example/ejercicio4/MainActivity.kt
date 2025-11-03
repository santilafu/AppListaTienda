package com.example.ejercicio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ejercicio4.ui.theme.Ejercicio4Theme
import androidx.navigation.compose.*
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Column



// Clase Producto y lista de productos
data class Producto(val nombre: String, val precio: Double, val descripcion: String)

// Lista de productos (24 productos)
val listaProductos = listOf(
    Producto("Laptop", 999.99, "Una laptop potente para todas tus necesidades."),
    Producto("Smartphone", 699.99, "Un smartphone con una cámara increíble."),
    Producto("Auriculares", 199.99, "Auriculares con cancelación de ruido."),
    Producto("Monitor", 299.99, "Monitor 4K para una experiencia visual impresionante."),
    Producto("Teclado", 89.99, "Teclado mecánico para una escritura cómoda."),
    Producto("Impresora", 149.99, "Impresora multifuncional para el hogar y la oficina."),
    Producto("Tablet", 399.99, "Tablet ligera y potente para entretenimiento y trabajo."),
    Producto("Cámara", 549.99, "Cámara digital para capturar tus momentos favoritos."),
    Producto("Altavoz Bluetooth", 129.99, "Altavoz portátil con sonido de alta calidad."),
    Producto("Reloj Inteligente", 249.99, "Reloj inteligente para mantenerte conectado y activo."),
    Producto("Disco Duro Externo", 119.99, "Almacenamiento adicional para tus archivos importantes."),
    Producto("Router WiFi", 79.99, "Conexión rápida y estable para todos tus dispositivos."),
    Producto("Smart TV", 899.99, "Televisor inteligente con acceso a tus aplicaciones favoritas."),
    Producto("Consola de Videojuegos", 499.99, "Disfruta de los últimos juegos con gráficos impresionantes."),
    Producto("Cargador Portátil", 39.99, "Mantén tus dispositivos cargados en cualquier lugar."),
    Producto("Proyector", 599.99, "Proyector para cine en casa y presentaciones."),
    Producto("Teclado para Tablet", 59.99, "Teclado compacto para mayor productividad en tu tablet."),
    Producto("Micrófono USB", 89.99, "Micrófono de alta calidad para grabaciones y transmisiones en vivo."),
    Producto("Lámpara de Escritorio", 49.99, "Lámpara ajustable para un ambiente de trabajo cómodo."),
    Producto("Silla Ergonómica", 199.99, "Silla cómoda para largas horas de trabajo."),
    Producto("Base de Enfriamiento para Laptop", 39.99, "Mantén tu laptop fresca durante el uso intensivo."),
    Producto("Webcam HD", 79.99, "Cámara web para videollamadas y transmisiones en alta definición."),
    Producto("Teclado Gamer RGB", 129.99, "Teclado con retroiluminación RGB para gamers exigentes."),
    Producto("Auriculares Inalámbricos", 159.99, "Auriculares inalámbricos con gran autonomía y calidad de sonido.")
)

@Composable
fun ListaProductos(navController: NavHostController) {
    LazyColumn {
        itemsIndexed(listaProductos) { index, producto ->
            Text(
                text = "${producto.nombre} - ${producto.precio}€",
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { navController.navigate("detalle/$index") }
            )
        }

    }
}

@Composable
fun DetalleProducto(index: Int, navController: NavHostController) {
    val producto = listaProductos[index]
    // Mostrar detalles del producto y el botón para volver atrás
    Column (modifier = Modifier.padding(16.dp)){
        Text(text = "Producto: ${producto.nombre}")
        Text(text = "Precio: ${producto.precio} €")
        Text(text = "Descripción: ${producto.descripcion}")

        //Botón para volver atrás
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(top = 100.dp)
        ) {
            Text("Volver Atrás")
        }

    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio4Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "lista") {
                    composable("lista") { ListaProductos(navController) }
                    composable("detalle/{index}") { backStackEntry ->
                        val i = backStackEntry.arguments?.getString("index")!!.toInt()
                        DetalleProducto(i, navController)
                    }
                }
            }
        }
    }
}
