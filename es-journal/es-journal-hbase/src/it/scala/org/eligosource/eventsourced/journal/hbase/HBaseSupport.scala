/*
 * Copyright 2012-2013 Eligotech BV.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.eligosource.eventsourced.journal.hbase

import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.HTable

object HBaseSupport {
  val config = HBaseConfiguration.create()
  val client = new HTable(config, "event")
}

trait HBaseSupport extends HBaseCleanup {
  val client = HBaseSupport.client
  val journalProps = HBaseJournalProps("localhost")
    .withPartitionCount(4)
    .withWriterCount(4)
    .withReplayChunkSize(8)
}