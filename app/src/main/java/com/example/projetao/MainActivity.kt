package com.example.projetao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.projetao.ui.theme.PROJETAOTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PROJETAOTheme {
                AppPrincipal()
            }
        }
    }
}
