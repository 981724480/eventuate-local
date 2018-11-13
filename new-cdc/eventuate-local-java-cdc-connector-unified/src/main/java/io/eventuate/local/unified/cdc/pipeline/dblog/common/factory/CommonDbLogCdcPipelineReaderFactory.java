package io.eventuate.local.unified.cdc.pipeline.dblog.common.factory;

import io.eventuate.local.common.BinlogEntryReader;
import io.eventuate.local.common.HealthCheck;
import io.eventuate.local.java.kafka.EventuateKafkaConfigurationProperties;
import io.eventuate.local.java.kafka.consumer.EventuateKafkaConsumerConfigurationProperties;
import io.eventuate.local.java.kafka.producer.EventuateKafkaProducer;
import io.eventuate.local.unified.cdc.pipeline.common.BinlogEntryReaderProvider;
import io.eventuate.local.unified.cdc.pipeline.common.factory.CommonCdcPipelineReaderFactory;
import io.eventuate.local.unified.cdc.pipeline.common.properties.CdcPipelineReaderProperties;
import io.micrometer.core.instrument.MeterRegistry;
import org.apache.curator.framework.CuratorFramework;

public abstract class CommonDbLogCdcPipelineReaderFactory<PROPERTIES extends CdcPipelineReaderProperties, READER extends BinlogEntryReader>
        extends CommonCdcPipelineReaderFactory<PROPERTIES, READER> {

  protected EventuateKafkaConfigurationProperties eventuateKafkaConfigurationProperties;
  protected EventuateKafkaConsumerConfigurationProperties eventuateKafkaConsumerConfigurationProperties;
  protected EventuateKafkaProducer eventuateKafkaProducer;


  public CommonDbLogCdcPipelineReaderFactory(MeterRegistry meterRegistry,
                                             HealthCheck healthCheck,
                                             CuratorFramework curatorFramework,
                                             BinlogEntryReaderProvider binlogEntryReaderProvider,
                                             EventuateKafkaConfigurationProperties eventuateKafkaConfigurationProperties,
                                             EventuateKafkaConsumerConfigurationProperties eventuateKafkaConsumerConfigurationProperties,
                                             EventuateKafkaProducer eventuateKafkaProducer) {

    super(meterRegistry, healthCheck, curatorFramework, binlogEntryReaderProvider);

    this.eventuateKafkaConfigurationProperties = eventuateKafkaConfigurationProperties;
    this.eventuateKafkaConsumerConfigurationProperties = eventuateKafkaConsumerConfigurationProperties;
    this.eventuateKafkaProducer = eventuateKafkaProducer;
  }
}
