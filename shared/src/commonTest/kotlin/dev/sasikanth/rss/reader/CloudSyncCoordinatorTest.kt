package dev.sasikanth.rss.reader

import dev.sasikanth.rss.reader.data.cloudsync.CloudDataBundle
import dev.sasikanth.rss.reader.data.cloudsync.CloudSyncCoordinator
import kotlinx.datetime.Instant
import kotlin.test.Test
import kotlin.test.assertEquals

class CloudSyncCoordinatorTest {
  @Test
  fun mergePrefersNewerBundle() {
    val older = CloudDataBundle(emptyList(), emptyList(), Instant.fromEpochMilliseconds(0))
    val newer = CloudDataBundle(emptyList(), emptyList(), Instant.fromEpochMilliseconds(10))

    val result1 = CloudSyncCoordinator.mergeBundles(newer, older)
    assertEquals(newer, result1)

    val result2 = CloudSyncCoordinator.mergeBundles(older, newer)
    assertEquals(newer, result2)
  }
}
