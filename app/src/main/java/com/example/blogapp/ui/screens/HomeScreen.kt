package com.example.blogapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.blogapp.ui.spacing

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel(),
    onNavigateToBlogScreen: () -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Box(
            modifier = Modifier
            .fillMaxSize()
        ) {

            Column(modifier = Modifier.fillMaxWidth().padding(MaterialTheme.spacing.small)) {
                OutlinedTextField(
                    value = homeViewModel.searchText,
                    onValueChange = { homeViewModel.onChangeSearchText(it) },
                    placeholder = { Text(text = "Search")},
                    trailingIcon = { IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search Blog")
                    } },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

            Text(text = "Home Screen", modifier = Modifier.align(Alignment.Center))

            FloatingActionButton(
                onClick = onNavigateToBlogScreen,
                contentColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(MaterialTheme.spacing.medium)
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add Blog",
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(onNavigateToBlogScreen = {})
}
