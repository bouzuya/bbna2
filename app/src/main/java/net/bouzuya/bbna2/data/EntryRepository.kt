package net.bouzuya.bbna2.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDate

class EntryRepository {
    val entries: Flow<List<Entry>> = flow {
        (0..100).map {
            Entry(
                date = LocalDate.of(2020, 1, 2).plusDays(it.toLong()).toString(),
                title = "Title $it"
            )
        }.toList()
    }
}
