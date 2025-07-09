package dev.sasikanth.rss.reader.data.cloudsync

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import dev.sasikanth.rss.reader.di.scopes.AppScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import me.tatarka.inject.annotations.Inject

@Inject
@AppScope
class SyncSettingsStore(private val dataStore: DataStore<Preferences>) {

  private val cloudSyncEnabledKey = booleanPreferencesKey("cloud_sync_enabled")
  private val lastSyncAtKey = stringPreferencesKey("cloud_last_sync_at")

  val cloudSyncEnabled: Flow<Boolean> =
    dataStore.data.map { preferences -> preferences[cloudSyncEnabledKey] ?: false }

  val lastSyncAt: Flow<Instant?> =
    dataStore.data.map { preferences ->
      preferences[lastSyncAtKey]?.let { Instant.parse(it) }
    }

  suspend fun isCloudSyncEnabledImmediate(): Boolean = cloudSyncEnabled.first()

  suspend fun lastSyncAtImmediate(): Instant? = lastSyncAt.first()

  suspend fun setCloudSyncEnabled(value: Boolean) {
    dataStore.edit { preferences -> preferences[cloudSyncEnabledKey] = value }
  }

  suspend fun updateLastSyncAt(time: Instant = Clock.System.now()) {
    dataStore.edit { preferences -> preferences[lastSyncAtKey] = time.toString() }
  }
}
