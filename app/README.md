# 🛒 Catálogo PCEQUIPOS

Aplicación desarrollada en **Android Studio** con **Kotlin** y **Jetpack Compose**, como práctica del módulo de *Programación Multimedia y Dispositivos Móviles* (2º DAM).  
La app simula el catálogo de productos de una tienda de tecnología llamada **PCEQUIPOS**.

---

## 📱 Descripción del proyecto

La aplicación muestra una lista de productos tecnológicos con su **imagen, nombre y precio**.  
Cada producto puede seleccionarse para ver sus **detalles completos**, incluyendo descripción y un botón para volver atrás.

También incluye una **barra superior personalizada** con el nombre y logo de la tienda.

---

## 🧩 Funcionalidades principales

- 📋 **Listado estático** de 24 productos cargados desde un `array` en Kotlin.
- 🖼️ Cada producto incluye **imagen local**, **nombre**, **precio** y **descripción**.
- 🧭 **Navegación entre pantallas** usando `NavHost` y `NavController`.
- 🎨 **Diseño visual moderno** con Material Design 3 (`Scaffold`, `TopAppBar`, `Button`, etc.).
- 🧡 **Barra superior personalizada** con color naranja suave (`0xFFFFA726`) y logo.
- 🔙 **Pantalla de detalle** con botón “Volver atrás”.
- 📦 Todo el contenido es local, sin conexión a Internet.

---

## 🛠️ Tecnologías utilizadas

| Tecnología | Uso principal |
|-------------|----------------|
| **Kotlin** | Lenguaje de programación principal |
| **Jetpack Compose** | Creación de interfaces modernas y reactivas |
| **Android Studio** | Entorno de desarrollo (IDE) |
| **Material 3** | Componentes visuales (TopAppBar, Scaffold, Buttons...) |
| **Navigation Compose** | Control de pantallas y navegación entre vistas |

---

## 🧰 Estructura del proyecto

```
app/
├── src/main/
│ ├── java/com/example/ejercicio4/MainActivity.kt
│ └── res/
│ ├── drawable/ ← Imágenes de productos y logo
│ └── values/ ← Temas y colores
```

---


---

## 🎨 Interfaz visual

La pantalla principal muestra los productos con su foto y precio, mientras que la vista de detalle amplía la información con un diseño limpio y centrado.

Ejemplo del aspecto visual de la aplicación:

- 🖼️ Pantalla principal → lista de productos con imágenes pequeñas.
- 📖 Pantalla de detalle → imagen grande, nombre, precio y descripción.
- 🟧 Barra superior → color naranja suave y logo de la tienda.

---

## 📚 Autor

**Santiago Lafuente Hernández**  
📍 Burjassot (Valencia)  
💼 Proyecto educativo – 2º DAM  


---

## 🧠 Notas

- He ido mas alla de lo pedido en el enunciado, añadiendo más productos y mejorando el diseño, por que me apetecia practicar más con Compose.
- Las imágenes se almacenan en `res/drawable`.
- Todo el contenido se carga de forma local (no hay conexión a Internet).
- Este proyecto sirve como ejemplo base para aprender **Compose, navegación y gestión de recursos locales**.
- La redaccion del README.md ha sido generada parcialmente con la ayuda de ChatGPT-5.

