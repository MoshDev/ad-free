package ch.abertschi.adump

/**
 * Created by abertschi on 13.12.16.
 */
abstract class AbstractStatusBarDetector() : AdDetectable {

    companion object {
        private val SPOTIFY_PACKAGE = "com.spotify"
    }

    override fun canHandle(payload: AdPayload): Boolean {
        println("can handle")
        return payload != null &&
                payload.statusbarNotification != null
                && payload.statusbarNotification.key != null
                && payload.statusbarNotification.key.toLowerCase().contains(SPOTIFY_PACKAGE)

    }
}
