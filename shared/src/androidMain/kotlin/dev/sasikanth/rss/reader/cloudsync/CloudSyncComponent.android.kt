package dev.sasikanth.rss.reader.cloudsync

import dev.sasikanth.rss.reader.data.cloudsync.CloudSyncEngine
import dev.sasikanth.rss.reader.data.cloudsync.DriveSyncEngine
import me.tatarka.inject.annotations.Provides

actual interface CloudSyncPlatformComponent {
  @Provides fun providesCloudSyncEngine(engine: DriveSyncEngine): CloudSyncEngine = engine
}
