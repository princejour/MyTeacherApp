package com.walhero.myteacher

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParentAccessScreen(students: List<Student>, onOpenInbox: (Student) -> Unit, onBack: () -> Unit) {
    var code by rememberSaveable { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }

    Scaffold(topBar = { TopAppBar(title = { Text("Family Access") }, navigationIcon = { TextButton(onClick = onBack) { Text("Back") } }) }) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(24.dp), verticalArrangement = Arrangement.Center) {
            Text("Enter your private family code", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(code, { code = it }, label = { Text("Family code") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
            if (error != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(error.orEmpty(), color = MaterialTheme.colorScheme.error)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                val student = students.firstOrNull { it.parentCode.equals(code.trim(), ignoreCase = true) }
                if (student == null) error = "Invalid code" else onOpenInbox(student)
            }, modifier = Modifier.fillMaxWidth()) { Text("Open Inbox") }
            Spacer(modifier = Modifier.height(12.dp))
            Text("Demo codes: MT-1001, MT-1002, MT-1003", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParentInboxScreen(
    student: Student?,
    messages: List<TeacherMessage>,
    freeOpened: Map<String, Set<String>>,
    adUnlocked: Set<String>,
    canRequestAds: Boolean,
    isRewardedAdReady: Boolean,
    onOpenFree: (String, String) -> Unit,
    onRewardedUnlock: (String, (String) -> Unit) -> Unit,
    onBack: () -> Unit
) {
    val currentStudent = student
    val studentMessages = messages.filter { it.studentId == currentStudent?.id }
    val openedIds = freeOpened[currentStudent?.id.orEmpty()].orEmpty()
    var adNotice by remember { mutableStateOf<String?>(null) }

    Scaffold(topBar = { TopAppBar(title = { Text("Message Inbox") }, navigationIcon = { TextButton(onClick = onBack) { Text("Back") } }) }) { padding ->
        if (currentStudent == null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { Text("No account selected") }
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize().padding(padding), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                item {
                    Text("Messages for ${currentStudent.name}", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Text("Free monthly openings: ${openedIds.size}/5")
                    adNotice?.let {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
                    }
                }
                items(studentMessages) { message ->
                    val openedForFree = openedIds.contains(message.id)
                    val unlockedByAd = adUnlocked.contains(message.id)
                    val canOpenFree = openedIds.size < 5 && !openedForFree && !unlockedByAd
                    MessageCard(
                        message = message,
                        isOpen = openedForFree || unlockedByAd,
                        canOpenFree = canOpenFree,
                        canRequestAds = canRequestAds,
                        isRewardedAdReady = isRewardedAdReady,
                        onOpenFree = { onOpenFree(currentStudent.id, message.id) },
                        onRewardedUnlock = {
                            adNotice = null
                            onRewardedUnlock(message.id) { errorMessage ->
                                adNotice = errorMessage
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MessageCard(
    message: TeacherMessage,
    isOpen: Boolean,
    canOpenFree: Boolean,
    canRequestAds: Boolean,
    isRewardedAdReady: Boolean,
    onOpenFree: () -> Unit,
    onRewardedUnlock: () -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(message.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(message.date, style = MaterialTheme.typography.bodySmall)
            if (isOpen) {
                Text(message.body)
            } else if (canOpenFree) {
                Text("This message is available within your 5 free monthly openings.")
                Button(onClick = onOpenFree, modifier = Modifier.fillMaxWidth()) { Text("Open Free Message") }
            } else {
                Text("This message is locked after the monthly free limit.")
                Text(
                    "It unlocks only after a rewarded ad is completed.",
                    style = MaterialTheme.typography.bodySmall
                )
                Button(
                    onClick = onRewardedUnlock,
                    enabled = canRequestAds,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        when {
                            !canRequestAds -> "Ads unavailable"
                            isRewardedAdReady -> "Watch Ad to Unlock"
                            else -> "Prepare Rewarded Ad"
                        }
                    )
                }
            }
        }
    }
}
