
## 1.2-SNAPSHOT

  ...

## 1.1.4

  * D37901: udpate config init method
  * D35369: Replace 'mdh' dependency with community dependency for spark and storm
  * D35632: fix sdk may put null msg
  * D35648/D35864: fix sdk naming checking
  * D35735/D36159/D36783: add TalosTopicInputFormat for mapreduce job
  * D35961: Change scope of spark-streaming to compile


## 1.1.3

  * D34943/D35154: SDK support SDS Stream Auth


## 1.1.2

  * D33949: Add talos-storm plugin
  * D34377: Make config serializable


## 1.1.1

  * D34190: Fix log info boring to application
  * D33815: Add unhandled msg number for fetched messages
  * D33736: Using Properties instead of hadoop.conf
  * D33707: add shutdown for TalosConsumer
  * D33652: add shutdown for TalosProducer
  * D33380: Change generated files version to thrift 0.9.2
  * D33368: MessageProcessor support checkpoint consumed message offset
  * D33222: Fix simple consumer bug when startOffset==-1/-2


## 1.1.0

  * D32867: Enlarge message bytes limit
  * D32717: Change SimplePartitioner to adjust range partition
  * D32260: Bug fix: SimpleConsumer fetchMessage sometimes return some old data
  * D32045: Update talos sdk pom for independent deploy


## 1.0.0

  * Initial release!

