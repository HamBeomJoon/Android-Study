package com.example.ch10_notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import androidx.core.content.ContextCompat
import com.example.ch10_notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val permissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions())
            {
                if (it.all { permission -> permission.value }) {
                    noti()
                }
            }

        binding.notificationBtn.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS")
                == PackageManager.PERMISSION_GRANTED
            ) {
                noti()
            } else {
                permissionLauncher.launch(arrayOf("android.permission.POST_NOTIFICATIONS"))
            }
        }
    }

    fun noti() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val builder: NotificationCompat.Builder


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "one-channel"
            val channelName = "MY Channel One"
            val channel =

                NotificationChannel(
                    channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_DEFAULT
                ).apply {
                    // 채널에 다양한 정보 설정
                    description = "My Channel One Description"
                    setShowBadge(true)
                    val uri: Uri =
                        RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                    // val audioAttributes = AudioAttributes
                }

            // 채널을 NotificationManager에 등록
            manager.createNotificationChannel(channel)
            builder =
                NotificationCompat.Builder(this, channelId)
        } else {
            builder = NotificationCompat.Builder(this)
        }

        // 알림의 기본 정보
        builder.run {
            setSmallIcon(R.drawable.small)
            setWhen(System.currentTimeMillis())
            setContentTitle("함범준")
            setContentText("안녕하세요.")
            setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.big))
        }

        val KEY_TEXT_REPLY = "key_text_reply"
        var replyLabel = "답장"
        var remoteInput: RemoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
            setLabel(replyLabel)
            build()
        }
        val replyIntent = Intent(this, ReplyReceiver::class.java)
        val replyPendingIntent =
            PendingIntent.getBroadcast(this, 30, replyIntent, PendingIntent.FLAG_MUTABLE)

        builder.addAction(
            NotificationCompat.Action.Builder(R.drawable.send, "답장하기", replyPendingIntent)
                .addRemoteInput(remoteInput).build()
        )
        manager.notify(11, builder.build())
    }
}