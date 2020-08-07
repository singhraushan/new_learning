package com.rau.common;

import java.io.Serializable;

//not early loading
public class SingleTon implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private static SingleTon obj;

	private SingleTon() {
	}

	public static SingleTon getObject() {
		if (obj == null) {//double check locked
			synchronized (SingleTon.class) {
				if (obj == null) {
					return obj = new SingleTon();
				}
			}
		}
		return obj;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
		// return obj;
	}

	protected Object readResolve() {
		return obj;
	}
}
