package com.example.projetao

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaBlocos(voltar: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFF5F7FA), Color(0xFFE9EFF5))
                )
            )
    ) {

        Button(
            onClick = { voltar() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Start),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF667EEA)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("← Voltar", color = Color.White)
        }

        Text(
            text = "Blocos Coloridos",
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Color(0xFF2D3748)
        )

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // COLUNA ESQUERDA
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                BlocoCard(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    gradient = Brush.verticalGradient(
                        colors = listOf(Color(0xFF06B6D4), Color(0xFF0891B2))
                    ),
                    label = "Azul"
                )

                BlocoCard(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    gradient = Brush.verticalGradient(
                        colors = listOf(Color(0xFFF59E0B), Color(0xFFD97706))
                    ),
                    label = "Âmbar"
                )
            }

            // COLUNA DIREITA
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                BlocoCard(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    gradient = Brush.verticalGradient(
                        colors = listOf(Color(0xFF8B5CF6), Color(0xFF6D28D9))
                    ),
                    label = "Roxo"
                )

                BlocoCard(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    gradient = Brush.verticalGradient(
                        colors = listOf(Color(0xFF10B981), Color(0xFF059669))
                    ),
                    label = "Verde"
                )

                BlocoCard(
                    modifier = Modifier
                        .weight(0.8f)
                        .fillMaxWidth(),
                    gradient = Brush.verticalGradient(
                        colors = listOf(Color(0xFFEF4444), Color(0xFFDC2626))
                    ),
                    label = "Vermelho"
                )
            }
        }
    }
}

@Composable
fun BlocoCard(
    modifier: Modifier = Modifier,
    gradient: Brush,
    label: String
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = label,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}