package dev.sasikanth.rss.reader.data.cloudsync

import me.tatarka.inject.annotations.Inject

@Inject
class CloudKitSyncEngine : CloudSyncEngine {
  override suspend fun sync() {
    // TODO: Implement CloudKit sync logic
  }
}
