package com.rau.storm_sample;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

public class MultipleBolt extends BaseRichBolt {
	OutputCollector outputCollector;

	public void execute(Tuple tuple) {
		Integer value = tuple.getInteger(0);
		value *= 2;
		outputCollector.emit(new Values(value));
		//System.out.println(value);
	}

	public void prepare(Map arg0, TopologyContext arg1, OutputCollector outputCollector) {
		this.outputCollector = outputCollector;
	}

	public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
		outputFieldsDeclarer.declare(new Fields("BoltField"));
	}

}
