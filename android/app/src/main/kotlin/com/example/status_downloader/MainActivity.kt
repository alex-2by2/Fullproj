package com.example.status_downloader  // <-- must match manifest package and folder path

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.documentfile.provider.DocumentFile
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    private val CHANNEL = "com.statusdownloader/saf"

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            // your MethodChannel handlers here (openDocumentTree, listFilesInTree, etc.)
            // ... keep the existing implementations you already added
        }
    }

    // If you use startActivityForResult, override onActivityResult here
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // your handling
    }
}
