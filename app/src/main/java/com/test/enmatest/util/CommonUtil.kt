package com.test.enmatest.util

import com.test.enmatest.R
import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.provider.Settings
import androidx.core.app.NotificationManagerCompat
import androidx.core.graphics.drawable.toDrawable
import java.text.DecimalFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

object CommonUtil {

    /**
     * Shows a simple loading dialog
     * @param context: Context
     * @return instance of the shown loading dialog
     */
    fun showLoadingDialog(context: Context?): ProgressDialog {
        val progressDialog = ProgressDialog(context)
        progressDialog.let {
            it.show()
            it.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
            it.setContentView(R.layout.progress_dialog)
            it.isIndeterminate = true
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            return it
        }
    }

    /**
     * @param context: Context
     * @return a string that has the device ID
     */
    @SuppressLint("all")
    fun getDeviceId(context: Context) = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)

    /**
     * Validates the inputted email
     * @param email: the inputted email
     * @return returns a flag that indicates if the email is valid
     */
    fun isEmailValid(email: String): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        pattern = Pattern.compile(EMAIL_PATTERN)
        matcher = pattern.matcher(email)
        return matcher.matches()
    }

    /**
     * Validates the inputted Emirates ID
     * @param emiratesID: the inputted Emirates ID
     * @return returns a flag that indicates if the Emirates ID is valid
     */
    fun isValidEmiratesID(emiratesID: String): Boolean {

        // Odd digits + N
        var digitsA = 0L
        // the checksum
        var checksum = -1L

        emiratesID.forEachIndexed { index, char ->

            if (char.isDigit()) {
                val digit = char.toString().toLong()
                if (index % 2 == 0) {
                    if (index == 14)
                        checksum = digit
                    else
                        digitsA += digit

                } else {

                    val digitsK = 2 * digit
                    val digitsL: Long = (Math.floor((digit / 5.0F).toDouble()) * 9).toLong()
                    // N = K - L
                    val digitsN = digitsK - digitsL
                    // add the N
                    digitsA += digitsN

                }

            }
        }

        val digitsB = digitsA + 10
        // B % 10
        val digitsC = digitsB % 10
        // 10 - C
        val digitsD = 10 - digitsC
        // checksum = digitsD % 10

        AppLogger.d("Emarits ID: $emiratesID is ${(checksum == (digitsD % 10))}")

        return (checksum == (digitsD % 10))
    }


    /**
     *  Adds dashes in appropriate places for the Emirates ID
     *  @param emiratesId: user's Emirates ID
     *  @return the Emirates ID with dashes
     */
    fun getFormattedEmiratesId(emiratesId: String?): String {
        val formattedEmirateId = StringBuilder(emiratesId)
        if (formattedEmirateId.length > 14)
            formattedEmirateId.insert(3, "-").insert(8, "-").insert(16, "-")
        return formattedEmirateId.toString()
    }

    /**
     * @return a flag that indicates if the user's device has notifications enabled
     */
    fun isNotificationEnabled(context: Context) = NotificationManagerCompat.from(context).areNotificationsEnabled()

    /**
     * @return a flag that indicates if the user's device language is Arabic
     */
    fun isArabic() = Locale.getDefault().language == "ar"

    /**
     * @param number: inputted number
     * @return the inputted number formatted similar to (123.45)
     */
    fun formatDouble(number: Double): String? {
        val df = DecimalFormat("#.##")
        return df.format(number)
    }

    /**
     * Formats distance to be shown (e.g. 12 Km) or Unknown if the distance isn't valid
     * @param distanceInMeters: distance in Meters
     * @return distance formatted string
     */
    fun getFormattedDistance(distanceInMeters: Double?): String {
        if (distanceInMeters == null)
            return if (isArabic()) "غير معروف" else "Unknown"
        var distance: Float = distanceInMeters.toFloat()
        var unit = if (isArabic()) "م" else "m"
        if (distance > 1000) {
            distance /= 1000f
            unit = if (isArabic()) "كم" else "Km"
        }

        return String.format("%1.2f %2s", distance, unit)
    }

}