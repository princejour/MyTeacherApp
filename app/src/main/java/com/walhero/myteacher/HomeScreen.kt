package com.walhero.myteacher

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    isPrivacyOptionsRequired: Boolean,
    onTeacher: () -> Unit,
    onParent: () -> Unit,
    onPrivacyOptionsClick: () -> Unit,
    onPrivacyPolicyClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("My Teacher", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        Text("Premium school communication", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onTeacher, modifier = Modifier.fillMaxWidth()) { Text("Teacher") }
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedButton(onClick = onParent, modifier = Modifier.fillMaxWidth()) { Text("Family") }

        Spacer(modifier = Modifier.height(32.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(20.dp))
        Text("Privacy & advertising", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        if (isPrivacyOptionsRequired) {
            OutlinedButton(
                onClick = onPrivacyOptionsClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Privacy choices")
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        TextButton(onClick = onPrivacyPolicyClick) {
            Text("Privacy Policy")
        }
    }
}
