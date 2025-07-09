package dev.sasikanth.rss.reader.cloudsync

import dev.sasikanth.rss.reader.data.cloudsync.CloudKitSyncEngine
import dev.sasikanth.rss.reader.data.cloudsync.CloudSyncEngine
import me.tatarka.inject.annotations.Provides

actual interface CloudSyncPlatformComponent {
  @Provides fun providesCloudSyncEngine(engine: CloudKitSyncEngine): CloudSyncEngine = engine
}
