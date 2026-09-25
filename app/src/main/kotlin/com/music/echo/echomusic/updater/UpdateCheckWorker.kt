package echo.music.iad1tya.echomusic.updater

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import echo.music.iad1tya.echomusic.UpdateNotificationHelper

class UpdateCheckWorker(
  private val context: Context,
  workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

  override suspend fun doWork(): Result {
    if (!getAutoUpdateCheckSetting(context)) {
      return Result.success()
    }

    return try {
      checkForUpdate(
        context = context,
        onSuccess = { latestVersion, isAvailable, _, _, _, _, _, _ ->
          saveUpdateAvailableState(context, isAvailable)
          if (isAvailable && getUpdateNotificationsSetting(context)) {
            Log.d("UpdateCheckWorker", "Found update: $latestVersion, showing notification")
            UpdateNotificationHelper.showUpdateNotification(context, latestVersion)
          }
        },
        onError = {
          Log.e("UpdateCheckWorker", "Periodic update check error")
        }
      )
      Result.success()
    } catch (e: Exception) {
      Log.e("UpdateCheckWorker", "Failed periodic check", e)
      Result.retry()
    }
  }
}
