package com.example.projetao

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.ui.draw.alpha
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar
import java.util.Locale

@Composable
fun TelaFormulario(voltar: () -> Unit) {

    var title by remember { mutableStateOf("") }
    var statusSelecionado by remember { mutableStateOf(false) }
    var prioritySelecionada by remember { mutableStateOf("High") }
    var dataSelecionada by remember { mutableStateOf("Escolha uma data") }
    var horaSelecionada by remember { mutableStateOf("Escolha um horário") }
    var mensagem by remember { mutableStateOf("") }

    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFC))
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { voltar() },
            modifier = Modifier.height(36.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF06B6D4))
        ) {
            Text("← Voltar", color = Color.White, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "✓ Criar Atividade",
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF0F172A)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Organize suas tarefas com facilidade",
            fontSize = 14.sp,
            color = Color(0xFF64748B)
        )

        Spacer(modifier = Modifier.height(28.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Text("Título da Atividade", fontWeight = FontWeight.SemiBold, color = Color(0xFF1E293B), fontSize = 14.sp)

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Ex: Estudar Kotlin", fontSize = 13.sp) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    singleLine = true,
                    textStyle = androidx.compose.material3.LocalTextStyle.current.copy(fontSize = 14.sp)
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Text("Status da Atividade", fontWeight = FontWeight.SemiBold, color = Color(0xFF1E293B), fontSize = 14.sp)

                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 14.dp)) {

                    RadioButton(
                        selected = !statusSelecionado,
                        onClick = { statusSelecionado = false },
                        colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF06B6D4), unselectedColor = Color(0xFFCBD5E1))
                    )
                    Text("✓ Concluído", modifier = Modifier.padding(start = 8.dp), color = Color(0xFF475569), fontSize = 14.sp)

                    Spacer(modifier = Modifier.width(32.dp))

                    RadioButton(
                        selected = statusSelecionado,
                        onClick = { statusSelecionado = true },
                        colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF06B6D4), unselectedColor = Color(0xFFCBD5E1))
                    )
                    Text("⏳ Em Progresso", modifier = Modifier.padding(start = 8.dp), color = Color(0xFF475569), fontSize = 14.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Text("Nível de Prioridade", fontWeight = FontWeight.SemiBold, color = Color(0xFF1E293B), fontSize = 14.sp)

                Column(verticalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.padding(top = 14.dp)) {

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = prioritySelecionada == "Low",
                            onClick = { prioritySelecionada = "Low" },
                            colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF10B981), unselectedColor = Color(0xFFCBD5E1))
                        )
                        Text("🟢 Baixa", modifier = Modifier.padding(start = 8.dp), color = Color(0xFF10B981), fontSize = 14.sp, fontWeight = FontWeight.Medium)
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = prioritySelecionada == "Medium",
                            onClick = { prioritySelecionada = "Medium" },
                            colors = RadioButtonDefaults.colors(selectedColor = Color(0xFFF59E0B), unselectedColor = Color(0xFFCBD5E1))
                        )
                        Text("🟡 Média", modifier = Modifier.padding(start = 8.dp), color = Color(0xFFF59E0B), fontSize = 14.sp, fontWeight = FontWeight.Medium)
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = prioritySelecionada == "High",
                            onClick = { prioritySelecionada = "High" },
                            colors = RadioButtonDefaults.colors(selectedColor = Color(0xFFEF4444), unselectedColor = Color(0xFFCBD5E1))
                        )
                        Text("🔴 Alta", modifier = Modifier.padding(start = 8.dp), color = Color(0xFFEF4444), fontSize = 14.sp, fontWeight = FontWeight.Medium)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Button(
            onClick = {
                DatePickerDialog(
                    context,
                    { _, year, month, day ->
                        dataSelecionada = "$day/${month + 1}/$year"
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981))
        ) {
            Text("📅 $dataSelecionada", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                TimePickerDialog(
                    context,
                    { _, hour, minute ->
                        horaSelecionada = String.format(Locale.US, "%02d:%02d", hour, minute)
                    },
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    true
                ).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8B5CF6))
        ) {
            Text("🕐 $horaSelecionada", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B))
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Text(
                    "📋 Resumo",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color(0xFF0EA5E9)
                )
                Spacer(modifier = Modifier.height(14.dp))

                SummaryRow("Título", if (title.isEmpty()) "Não informado" else title)
                SummaryRow("Status", if (!statusSelecionado) "✓ Concluído" else "⏳ Em Progresso")
                SummaryRow(
                    "Prioridade",
                    when (prioritySelecionada) {
                        "Low" -> "🟢 Baixa"
                        "Medium" -> "🟡 Média"
                        "High" -> "🔴 Alta"
                        else -> prioritySelecionada
                    }
                )
                SummaryRow("Data", dataSelecionada)
                SummaryRow("Horário", horaSelecionada)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {

            Button(
                onClick = {
                    title = ""
                    statusSelecionado = false
                    prioritySelecionada = "High"
                    dataSelecionada = "Escolha uma data"
                    horaSelecionada = "Escolha um horário"
                    mensagem = ""
                },
                modifier = Modifier
                    .weight(1f)
                    .height(44.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF64748B))
            ) {
                Text("🗑️ Limpar", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
            }

            Button(
                onClick = {
                    mensagem =
                        if (title.isEmpty())
                            "Digite um título"
                        else if (dataSelecionada == "Escolha uma data")
                            "Escolha uma data"
                        else if (horaSelecionada == "Escolha um horário")
                            "Escolha um horário"
                        else
                            "Atividade salva com sucesso!"
                },
                modifier = Modifier
                    .weight(1f)
                    .height(44.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0EA5E9))
            ) {
                Text("💾 Salvar", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
            }
        }

        if (mensagem.isNotEmpty()) {

            Spacer(modifier = Modifier.height(18.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (mensagem.contains("sucesso", ignoreCase = true)) 
                        Color(0xFF10B981)
                    else 
                        Color(0xFFEF4444)
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Text(
                    mensagem,
                    modifier = Modifier.padding(16.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun SummaryRow(label: String, value: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(label + ":", fontWeight = FontWeight.SemiBold, color = Color(0xFFCBD5E1), fontSize = 12.sp)
            Text(value, color = Color.White.copy(0.95f), fontSize = 13.sp, fontWeight = FontWeight.Medium, modifier = Modifier.weight(1f), textAlign = androidx.compose.ui.text.style.TextAlign.End)
        }
        HorizontalDivider(color = Color(0xFF334155), thickness = 1.dp, modifier = Modifier.alpha(0.5f))
    }
}