package com.example.ejercicio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejercicio4.ui.theme.Ejercicio4Theme

// Clase Producto
data class Producto(
    val nombre: String,
    val precio: Double,
    val descripcion: String,
    val imagen: Int
)

// Lista de productos
val listaProductos = listOf(
    Producto("Laptop", 999.99, "Una laptop potente para todas tus necesidades.", R.drawable.laptop),
    Producto("Smartphone", 699.99, "Un smartphone con una cámara increíble.", R.drawable.smartphone),
    Producto("Auriculares", 199.99, "Auriculares con cancelación de ruido.", R.drawable.auriculares),
    Producto("Monitor", 299.99, "Monitor 4K para una experiencia visual impresionante.", R.drawable.monitor),
    Producto("Teclado", 89.99, "Teclado mecánico para una escritura cómoda.", R.drawable.teclado),
    Producto("Impresora", 149.99, "Impresora multifuncional para el hogar y la oficina.", R.drawable.impresora),
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
            Row(
                modifier = Modifier
                    .clickable { navController.navigate("detalle/$index") }
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = producto.imagen),
                    contentDescription = producto.nombre,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Column {
                    Text(text = producto.nombre, fontSize = 18.sp)
                    Text(text = "${producto.precio}€", fontSize = 14.sp)
                }
            }
        }
    }
}

@Composable
fun DetalleProducto(index: Int, navController: NavHostController) {
    val producto = listaProductos[index]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = producto.nombre, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.padding(10.dp))
        Image(
            painter = painterResource(id = producto.imagen),
            contentDescription = producto.nombre,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Precio: ${producto.precio} €", fontSize = 18.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = producto.descripcion, fontSize = 16.sp)
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { navController.popBackStack() }, modifier = Modifier.fillMaxWidth()) {
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
                @OptIn(ExperimentalMaterial3Api::class)
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painter = painterResource(id = R.drawable.logotiendapc),
                                        contentDescription = "Logo de la tienda",
                                        modifier = Modifier
                                            .size(150.dp)
                                            .padding(end = 8.dp)
                                    )
                                    Text("PCEQUIPOS", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(
                                0xFFEE7B3B
                            ),
                                titleContentColor = Color.White )
                        )
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "lista",
                        modifier = Modifier.padding(innerPadding)
                    ) {
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
}
