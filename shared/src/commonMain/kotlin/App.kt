import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun App() {
    MaterialTheme {
        var greetingText by remember {
            mutableStateOf("Hello, World!")
        }
        var showImage by remember {
            mutableStateOf(false)
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    greetingText = "Hello, ${getPlatformName()}"
                    showImage = !showImage
                },
            ) {
                Text(text = greetingText)
            }
            AnimatedVisibility(visible = showImage) {
                KamelImage(
                    resource = asyncPainterResource("https://sebastianaigner.github.io/demo-image-api/pigeon/alan-qIrxgh8WupA-unsplash.jpg"),
                    contentDescription = "Pigeon"
                )
            }
        }
    }
}

expect fun getPlatformName(): String