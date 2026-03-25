package com.example.projetao

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Categoria(
    val nome: String,
    val icone: androidx.compose.ui.graphics.vector.ImageVector,
    val gradient: Brush
)

@Composable
fun TelaCategorias(voltar: () -> Unit) {

    val categorias = listOf(
        Categoria("Moda", Icons.Default.ShoppingCart, Brush.verticalGradient(listOf(Color(0xFFF472B6), Color(0xFFEC4899)))),
        Categoria("Formal", Icons.Default.Settings, Brush.verticalGradient(listOf(Color(0xFF3B82F6), Color(0xFF1D4ED8)))),
        Categoria("Tech", Icons.Default.Favorite, Brush.verticalGradient(listOf(Color(0xFF8B5CF6), Color(0xFF6D28D9)))),
        Categoria("Viagem", Icons.Default.Edit, Brush.verticalGradient(listOf(Color(0xFF10B981), Color(0xFF059669)))),
        Categoria("Comida", Icons.Default.Check, Brush.verticalGradient(listOf(Color(0xFFF59E0B), Color(0xFFD97706)))),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFF5F7FA), Color(0xFFE9EFF5))
                )
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { voltar() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF667EEA)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.height(40.dp)
            ) {
                Text("← Voltar", color = Color.White)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Explore Categorias",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2D3748),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(56.dp))
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
                .padding(bottom = 12.dp),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(categorias) { categoria ->

                CategoriaCard(
                    categoria = categoria,
                    modifier = Modifier.height(160.dp)
                )
            }
        }
    }
}

@Composable
fun CategoriaCard(
    categoria: Categoria,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(categoria.gradient),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {

                Icon(
                    imageVector = categoria.icone,
                    contentDescription = categoria.nome,
                    tint = Color.White,
                    modifier = Modifier.size(44.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = categoria.nome,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
