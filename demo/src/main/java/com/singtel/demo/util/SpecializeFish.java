package com.singtel.demo.util;

public interface SpecializeFish {
	public enum Specialize {
		SHARK("large", "orange"), CLOWNFISH("small", "grey"), DEFAULT("","");
		String size;
		String colour;

		Specialize(String size, String colour) {
			this.size = size;
			this.colour = colour;
		}

		public String getSize() {
			return size;
		}

		public String getColour() {
			return colour;
		}

	}
   void jokes(String joke);
}
