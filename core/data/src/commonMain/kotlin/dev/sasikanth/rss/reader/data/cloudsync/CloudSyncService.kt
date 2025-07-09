package dev.sasikanth.rss.reader.data.cloudsync

interface CloudSyncService {
  suspend fun fetchData(): CloudDataBundle?
  suspend fun storeData(data: CloudDataBundle)
}
