package dev.sasikanth.rss.reader.data.cloudsync

class AndroidCloudSyncService : CloudSyncService {
  override suspend fun fetchData(): CloudDataBundle? = null
  override suspend fun storeData(data: CloudDataBundle) {}
}
