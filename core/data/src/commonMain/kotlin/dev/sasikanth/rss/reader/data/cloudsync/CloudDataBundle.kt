package dev.sasikanth.rss.reader.data.cloudsync

import dev.sasikanth.rss.reader.core.model.local.Feed
import dev.sasikanth.rss.reader.core.model.local.FeedGroup
import kotlinx.datetime.Instant

data class CloudDataBundle(
  val feeds: List<Feed>,
  val groups: List<FeedGroup>,
  val timestamp: Instant
)
