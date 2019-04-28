package com.rau.storm_sample;

import java.util.Map;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

public class IntSpout extends BaseRichSpout {
	SpoutOutputCollector spoutOutputCollector;
	private int index = 0;

	public void nextTuple() {
		if (index < 100) {
			spoutOutputCollector.emit(new Values(index));
			index++;
		}
	}

	public void open(Map arg0, TopologyContext arg1, SpoutOutputCollector spoutOutputCollector) {
		this.spoutOutputCollector = spoutOutputCollector;
	}

	public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
		outputFieldsDeclarer.declare(new Fields("Field"));
	}

}
