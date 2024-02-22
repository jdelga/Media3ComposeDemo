import android.content.Context
import androidx.annotation.OptIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.RawResourceDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import com.javierdelgado.media3composedemo.R

@OptIn(UnstableApi::class)
@Composable
fun VideoScreen() {
    AndroidView(factory = {
        PlayerView(it).apply {
            useController = false
            player = getExoplayer(it)
            resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
        }
    })
}

private fun getExoplayer(context: Context) =
    ExoPlayer.Builder(context).build()
        .apply {
            setMediaItem(getMediaItem())
            repeatMode = Player.REPEAT_MODE_ONE
            playWhenReady = true
            prepare()
        }

@OptIn(UnstableApi::class)
fun getMediaItem() = MediaItem.fromUri(RawResourceDataSource.buildRawResourceUri(R.raw.demo))
