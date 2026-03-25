package com.example.projetao

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.automirrored.filled.ArrowForward
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

@Composable
fun TelaMenu(onNavigate: (String) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF667EEA), Color(0xFF764BA2))
                )
            )
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(12.dp))
        
        Text(
            text = "Bem-vindo",
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            color = Color.White
        )
        
        Text(
            text = "Escolha uma opção abaixo",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            color = Color.White.copy(alpha = 0.8f)
        )

        Spacer(modifier = Modifier.height(12.dp))

        MenuCard(
            icon = Icons.Default.Edit,
            title = "Formulário",
            description = "Crie e gerencie atividades",
            gradient = Brush.verticalGradient(
                colors = listOf(Color(0xFFF97316), Color(0xFFEA580C))
            ),
            onClick = { onNavigate("formulario") }
        )

        MenuCard(
            icon = Icons.Default.Info,
            title = "Blocos",
            description = "Visualize blocos coloridos",
            gradient = Brush.verticalGradient(
                colors = listOf(Color(0xFF10B981), Color(0xFF059669))
            ),
            onClick = { onNavigate("blocos") }
        )

        MenuCard(
            icon = Icons.Default.Settings,
            title = "Categorias",
            description = "Explore diferentes opções",
            gradient = Brush.verticalGradient(
                colors = listOf(Color(0xFF3B82F6), Color(0xFF1D4ED8))
            ),
            onClick = { onNavigate("categorias") }
        )

        MenuCard(
            icon = Icons.Default.Search,
            title = "Livro",
            description = "Informações sobre livros",
            gradient = Brush.verticalGradient(
                colors = listOf(Color(0xFF8B5CF6), Color(0xFF6D28D9))
            ),
            onClick = { onNavigate("livro") }
        )

        MenuCard(
            icon = Icons.Default.Place,
            title = "Boa Viagem",
            description = "Gerencie suas viagens",
            gradient = Brush.verticalGradient(
                colors = listOf(Color(0xFFF59E0B), Color(0xFFD97706))
            ),
            onClick = { onNavigate("boaviagem") }
        )

        MenuCard(
            icon = Icons.Default.Phone,
            title = "Chat & Login",
            description = "Autenticação e mensagens",
            gradient = Brush.verticalGradient(
                colors = listOf(Color(0xFF06B6D4), Color(0xFF0891B2))
            ),
            onClick = { onNavigate("chat") }
        )

        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun MenuCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    description: String,
    gradient: Brush,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
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
                    contentDescription = title,
                    tint = Color.White,
                    modifier = Modifier.size(48.dp)
                )
                
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = description,
                        fontSize = 12.sp,
                        color = Color.White.copy(alpha = 0.85f)
                    )
                }
                
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Go",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

