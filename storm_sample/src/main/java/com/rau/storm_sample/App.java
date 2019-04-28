package com.rau.storm_sample;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		TopologyBuilder topology = new TopologyBuilder();
		topology.setSpout("IntSpout", new IntSpout());
		topology.setBolt("MultipleBolt", new MultipleBolt()).shuffleGrouping("IntSpout");

		Config cofig = new Config();
		cofig.setDebug( true);

		LocalCluster localCluster = new LocalCluster();
		localCluster.submitTopology("HelloTopology", cofig, topology.createTopology());

		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} /*finally {
			localCluster.shutdown();
		}*/

	}
}
