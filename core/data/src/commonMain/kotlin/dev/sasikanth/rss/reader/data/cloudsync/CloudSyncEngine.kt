package dev.sasikanth.rss.reader.data.cloudsync

interface CloudSyncEngine {
  suspend fun sync()
}
