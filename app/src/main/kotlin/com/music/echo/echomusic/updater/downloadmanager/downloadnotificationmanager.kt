package echo.music.iad1tya.echomusic.updater.downloadmanager

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import echo.music.iad1tya.R

object DownloadNotificationManager {
  private lateinit var notificationManager: NotificationManager
  private lateinit var appContext: Context

  const val CHANNEL_ID = "download_progress_channel"
  private const val CHANNEL_NAME = "Download Progress"
  const val NOTIFICATION_ID = 5678

  fun initialize(context: Context) {
    appContext = context
    notificationManager =
      context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      val channel =
        NotificationChannel(
            CHANNEL_ID,
            context.getString(R.string.download_progress_channel),
            NotificationManager.IMPORTANCE_HIGH
          )
          .apply {
            description = context.getString(R.string.download_progress_description)
            setShowBadge(false)
            lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            enableVibration(false)
            enableLights(false)
          }
      notificationManager.createNotificationChannel(channel)
    }
  }

  fun getDownloadStartingNotification(version: String, fileSize: String): Notification {
    return buildDownloadStarting(version, fileSize)
  }

  fun getDownloadProgressNotification(progress: Int, version: String): Notification {
    return buildDownloadProgress(progress, version)
  }

  fun showDownloadComplete(version: String, filePath: String) {
    showDownloadCompleteNotification(version, filePath)
  }

  fun showDownloadFailed(version: String, errorMessage: String) {
    val notification =
      NotificationCompat.Builder(appContext, CHANNEL_ID)
        .setSmallIcon(android.R.drawable.stat_sys_warning)
        .setContentTitle(appContext.getString(R.string.update_failed))
        .setContentText(appContext.getString(R.string.failed_to_download_version, version))
        .setStyle(
          NotificationCompat.BigTextStyle()
            .bigText(
              appContext.getString(R.string.failed_to_download_version_error, version, errorMessage)
            )
        )
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
        .setAutoCancel(true)
        .build()

    notificationManager.notify(NOTIFICATION_ID, notification)
  }

  fun cancelNotification() {
    notificationManager.cancel(NOTIFICATION_ID)
  }

  private fun buildDownloadStarting(version: String, fileSize: String): Notification {
    return NotificationCompat.Builder(appContext, CHANNEL_ID)
      .setSmallIcon(R.drawable.ic_launcher_foreground)
      .setContentTitle(appContext.getString(R.string.downloading_update))
      .setContentText(appContext.getString(R.string.version_file_size, version, fileSize))
      .setProgress(100, 0, false)
      .setOngoing(true)
      .setOnlyAlertOnce(true)
      .setPriority(NotificationCompat.PRIORITY_HIGH)
      .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
      .setCategory(NotificationCompat.CATEGORY_PROGRESS)
      .build()
  }

  private fun buildDownloadProgress(progress: Int, version: String): Notification {
    return NotificationCompat.Builder(appContext, CHANNEL_ID)
      .setSmallIcon(R.drawable.ic_launcher)
      .setContentTitle(appContext.getString(R.string.downloading_update))
      .setContentText(appContext.getString(R.string.version_progress, version, progress))
      .setProgress(100, progress, false)
      .setOngoing(progress < 100)
      .setOnlyAlertOnce(true)
      .setPriority(NotificationCompat.PRIORITY_HIGH)
      .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
      .setCategory(NotificationCompat.CATEGORY_PROGRESS)
      .build()
  }

  private fun showDownloadCompleteNotification(version: String, filePath: String) {
    val installIntent =
      Intent(Intent.ACTION_VIEW).apply {
        setDataAndType(
          androidx.core.content.FileProvider.getUriForFile(
            appContext,
            "${appContext.packageName}.FileProvider",
            java.io.File(filePath)
          ),
          "application/vnd.android.package-archive"
        )
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      }

    val pendingIntent =
      PendingIntent.getActivity(
        appContext,
        0,
        installIntent,
        PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
      )

    val notification =
      NotificationCompat.Builder(appContext, CHANNEL_ID)
        .setSmallIcon(R.drawable.updated)
        .setContentTitle(appContext.getString(R.string.update_ready))
        .setContentText(appContext.getString(R.string.tap_to_install_version, version))
        .setProgress(0, 0, false)
        .setAutoCancel(true)
        .setContentIntent(pendingIntent)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
        .setCategory(NotificationCompat.CATEGORY_STATUS)
        .build()

    notificationManager.notify(NOTIFICATION_ID, notification)
  }
}
