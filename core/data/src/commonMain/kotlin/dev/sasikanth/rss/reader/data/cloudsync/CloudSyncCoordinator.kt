package dev.sasikanth.rss.reader.data.cloudsync

import dev.sasikanth.rss.reader.data.repository.RssRepository
import dev.sasikanth.rss.reader.di.scopes.AppScope
import dev.sasikanth.rss.reader.util.DispatchersProvider
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock
import me.tatarka.inject.annotations.Inject

@AppScope
@Inject
class CloudSyncCoordinator(
  private val rssRepository: RssRepository,
  private val cloudSyncService: CloudSyncService,
  private val dispatchersProvider: DispatchersProvider,
) {

  suspend fun sync() {
    withContext(dispatchersProvider.io) {
      val local = localData()
      val remote = cloudSyncService.fetchData()
      val merged = mergeBundles(local, remote)
      cloudSyncService.storeData(merged)
    }
  }

  private suspend fun localData(): CloudDataBundle {
    val feeds = rssRepository.allFeedsBlocking()
    val groups = rssRepository.allFeedGroupsBlocking()
    return CloudDataBundle(feeds, groups, Clock.System.now())
  }


  companion object {
    internal fun mergeBundles(local: CloudDataBundle, remote: CloudDataBundle?): CloudDataBundle {
      return if (remote == null || local.timestamp > remote.timestamp) local else remote
    }
  }
}
