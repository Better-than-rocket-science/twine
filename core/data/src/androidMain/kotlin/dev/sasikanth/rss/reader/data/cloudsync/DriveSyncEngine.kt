package dev.sasikanth.rss.reader.data.cloudsync

import me.tatarka.inject.annotations.Inject

@Inject
class DriveSyncEngine : CloudSyncEngine {
  override suspend fun sync() {
    // TODO: Implement Google Drive sync logic
  }
}
