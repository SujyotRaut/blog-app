package com.example.blogapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.blogapp.ui.spacing
import com.example.blogapp.R

@Composable
fun AuthScreen(
    authViewModel: AuthViewModel = viewModel(),
    onNavigateToHomeScreen: () -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.spacing.medium),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small, Alignment.Top)
        ) {

            Box(modifier = Modifier.fillMaxWidth().padding(vertical = MaterialTheme.spacing.large)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "App logo",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.align(Alignment.Center).width(300.dp)
                )
            }

            OutlinedTextField(
                value = authViewModel.username,
                onValueChange = { authViewModel.onChangeUsername(it) },
                singleLine = true,
                placeholder = { Text(text = "Username") },
                leadingIcon = { Icon(Icons.Default.AccountCircle, contentDescription = "username")},
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = authViewModel.password,
                onValueChange = { authViewModel.onChangePassword(it)  },
                singleLine = true,
                placeholder = { Text(text = "Password") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "password")},
                trailingIcon = { IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Edit, contentDescription = "password")
                }},
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = onNavigateToHomeScreen,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.spacing.small)
            ) {
                Text(text = "Login".uppercase())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    AuthScreen()
}
