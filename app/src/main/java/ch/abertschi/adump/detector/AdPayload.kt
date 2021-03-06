package ch.abertschi.adump.detector

import android.service.notification.StatusBarNotification

/**
 * Created by abertschi on 15.04.17.
 */

data class AdPayload(val statusbarNotification: StatusBarNotification) {

    /**
     * Keys set by implementations of AdDetectable to exclude tracks from being matched as ad
     */
    val ignoreKeys: ArrayList<String> = ArrayList()
}