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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


// Clase Producto y lista de productos
data class Producto(val nombre: String, val precio: Double, val descripcion: String,val imagen: Int)

// Lista de productos (24 productos)
val listaProductos = listOf(
    Producto("Laptop", 999.99, "Una laptop potente para todas tus necesidades.", R.drawable.laptop),
    Producto("Smartphone", 699.99, "Un smartphone con una cámara increíble.", R.drawable.smartphone),
    Producto("Auriculares", 199.99, "Auriculares con cancelación de ruido.", R.drawable.auriculares),
    Producto("Monitor", 299.99, "Monitor 4K para una experiencia visual impresionante.", R.drawable.monitor),
    Producto("Teclado", 89.99, "Teclado mecánico para una escritura cómoda.",R.drawable.teclado),
    Producto("Impresora", 149.99, "Impresora multifuncional para el hogar y la oficina.",R.drawable.impresora),
    Producto("Tablet", 399.99, "Tablet ligera y potente para entretenimiento y trabajo.", R.drawable.tablet),
    Producto("Cámara", 549.99, "Cámara digital para capturar tus momentos favoritos.", R.drawable.camara),
    Producto("Altavoz Bluetooth", 129.99, "Altavoz portátil con sonido de alta calidad.", R.drawable.altavozbluetooth),
    Producto("Reloj Inteligente", 249.99, "Reloj inteligente para mantenerte conectado y activo.", R.drawable.relojinteligente),
    Producto("Disco Duro Externo", 119.99, "Almacenamiento adicional para tus archivos importantes.", R.drawable.discoduroexterno),
    Producto("Router WiFi", 79.99, "Conexión rápida y estable para todos tus dispositivos.", R.drawable.routerwifi),
    Producto("Smart TV", 899.99, "Televisor inteligente con acceso a tus aplicaciones favoritas.", R.drawable.smarttv),
    Producto("Consola de Videojuegos", 499.99, "Disfruta de los últimos juegos con gráficos impresionantes.", R.drawable.consoladevideojuegos),
    Producto("Cargador Portátil", 39.99, "Mantén tus dispositivos cargados en cualquier lugar.", R.drawable.cargadorportatil),
    Producto("Proyector", 599.99, "Proyector para cine en casa y presentaciones.", R.drawable.proyector),
    Producto("Teclado para Tablet", 59.99, "Teclado compacto para mayor productividad en tu tablet.", R.drawable.tecladotablet),
    Producto("Micrófono USB", 89.99, "Micrófono de alta calidad para grabaciones y transmisiones en vivo.", R.drawable.microfonousb),
    Producto("Lámpara de Escritorio", 49.99, "Lámpara ajustable para un ambiente de trabajo cómodo.", R.drawable.lamparaescritorio),
    Producto("Silla Ergonómica", 199.99, "Silla cómoda para largas horas de trabajo.", R.drawable.sillaergonomica),
    Producto("Base de Enfriamiento para Laptop", 39.99, "Mantén tu laptop fresca durante el uso intensivo.", R.drawable.baserefrigerante),
    Producto("Webcam HD", 79.99, "Cámara web para videollamadas y transmisiones en alta definición.", R.drawable.webcamhd),
    Producto("Teclado Gamer RGB", 129.99, "Teclado con retroiluminación RGB para gamers exigentes.", R.drawable.tecladogamer),
    Producto("Auriculares Inalámbricos", 159.99, "Auriculares inalámbricos con gran autonomía y calidad de sonido.", R.drawable.auricularesinalambricos)
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
    // Obtener el producto seleccionado
    val producto = listaProductos[index]

    // Mostrar detalles del producto y el botón para volver atrás
    Column (modifier = Modifier
        .fillMaxSize()//Ocupa todo el espacio disponible
        .padding(24.dp), //deja espacio en los bordes
        horizontalAlignment = Alignment.CenterHorizontally //Centrar horizontalmente
    ) {
        //Titulo

        Text(
            text = producto.nombre,
            fontSize = 24.sp, //Tamaño de fuente más grande para el título
            fontWeight = FontWeight.Bold //Texto en negrita
            )
        Spacer(modifier = Modifier.padding(10.dp))

        //Precio
        Text(
            text = "Precio: ${producto.precio} €",
        fontSize = 18.sp//Tamaño de fuente más grande para el precio
        )
        Spacer(modifier = Modifier.padding(10.dp))

        //Descripción
        Text(
            text = "Descripción: ${producto.descripcion}",
            fontSize = 16.sp//Tamaño de fuente más grande para la descripción
            )
        Spacer(modifier = Modifier.weight(1f)) //Espacio flexible para empujar el botón hacia abajo

        //Botón para volver atrás
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()//El botón ocupa todo el ancho disponible
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
