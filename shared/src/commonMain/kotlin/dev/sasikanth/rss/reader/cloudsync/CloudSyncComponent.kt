package dev.sasikanth.rss.reader.cloudsync

import dev.sasikanth.rss.reader.data.cloudsync.CloudSyncEngine

expect interface CloudSyncPlatformComponent

interface CloudSyncComponent : CloudSyncPlatformComponent {
  val cloudSyncEngine: CloudSyncEngine
}
