package com.example.projetao

import androidx.compose.runtime.*

@Composable
fun AppPrincipal() {

    var telaAtual by remember { mutableStateOf("menu") }

    when (telaAtual) {

        "menu" -> TelaMenu { destino ->
            telaAtual = destino
        }

        "formulario" -> TelaFormulario {
            telaAtual = "menu"
        }

        "blocos" -> TelaBlocos {
            telaAtual = "menu"
        }

        "categorias" -> TelaCategorias {
            telaAtual = "menu"
        }

        "livro" -> TelaLivro {
            telaAtual = "menu"
        }

        "boaviagem" -> TelaBoaViagem {
            telaAtual = "menu"
        }

        "chat" -> TelaChat {
            telaAtual = "menu"
        }
    }
}