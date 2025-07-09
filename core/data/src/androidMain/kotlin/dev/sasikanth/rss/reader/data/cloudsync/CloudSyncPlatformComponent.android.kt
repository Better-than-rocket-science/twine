package dev.sasikanth.rss.reader.data.cloudsync

import dev.sasikanth.rss.reader.di.scopes.AppScope
import me.tatarka.inject.annotations.Provides

actual interface CloudSyncPlatformComponent {
  @Provides
  @AppScope
  fun providesCloudSyncService(service: AndroidCloudSyncService): CloudSyncService = service
}
