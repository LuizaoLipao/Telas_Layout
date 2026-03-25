package com.example.projetao

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaBoaViagem(voltar: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFF5F7FA), Color(0xFFE9EFF5))
                )
            )
            .verticalScroll(rememberScrollState())
    ) {

        // Top Bar personalizado
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF59E0B))
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                "Boa Viagem",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Button(
                onClick = { voltar() },
                modifier = Modifier.align(Alignment.Start),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF667EEA)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("← Voltar", color = Color.White)
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                "Gerencie suas Viagens",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2D3748),
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(8.dp))

            MenuItemCard(
                icon = Icons.Default.Add,
                label = "Novo Gasto",
                description = "Registre gastos de viagem",
                gradient = Brush.verticalGradient(
                    colors = listOf(Color(0xFF667EEA), Color(0xFF764BA2))
                )
            )

            MenuItemCard(
                icon = Icons.Default.Home,
                label = "Nova Viagem",
                description = "Crie um novo planejamento",
                gradient = Brush.verticalGradient(
                    colors = listOf(Color(0xFF10B981), Color(0xFF059669))
                )
            )

            MenuItemCard(
                icon = Icons.Default.ShoppingCart,
                label = "Minhas Viagens",
                description = "Visualize todas suas viagens",
                gradient = Brush.verticalGradient(
                    colors = listOf(Color(0xFFF59E0B), Color(0xFFD97706))
                )
            )

            MenuItemCard(
                icon = Icons.Default.Settings,
                label = "Configurações",
                description = "Ajuste as preferências",
                gradient = Brush.verticalGradient(
                    colors = listOf(Color(0xFF06B6D4), Color(0xFF0891B2))
                )
            )
        }
    }
}

@Composable
fun MenuItemCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    description: String,
    gradient: Brush
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    modifier = Modifier.size(44.dp),
                    tint = Color.White
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        label,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        description,
                        fontSize = 12.sp,
                        color = Color.White.copy(alpha = 0.85f)
                    )
                }

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Go",
                    modifier = Modifier.size(24.dp),
                    tint = Color.White
                )
            }
        }
    }
}
