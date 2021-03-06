package ch.abertschi.adump.detector

import ch.abertschi.adump.model.TrackRepository
import org.jetbrains.anko.AnkoLogger

/**
 * AdDetectable that checks for the Keyword Spotify
 *
 * Created by abertschi on 15.04.17.
 */
class SpotifyTitleDetector(val trackRepository: TrackRepository) : AbstractStatusBarDetector(), AnkoLogger {

    override fun canHandle(payload: AdPayload): Boolean {
        getTitle(payload).let { payload.ignoreKeys.add(it!!) }
        return super.canHandle(payload)
    }

    override fun flagAsAdvertisement(payload: AdPayload): Boolean
            = getTitle(payload)?.toLowerCase()?.trim()?.contains("spotify") ?: false

    override fun flagAsMusic(payload: AdPayload): Boolean
            = getTitle(payload).let { trackRepository.getAllTracks().contains(it) }

    fun getTitle(payload: AdPayload): String?
            = payload?.statusbarNotification?.notification?.tickerText?.toString() ?: ""
}