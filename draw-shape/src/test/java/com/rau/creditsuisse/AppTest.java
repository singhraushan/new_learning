package com.rau.creditsuisse;

import org.junit.Assert;
import org.junit.Test;

import com.rau.creditsuisse.exception.CreditSuisseException;
import com.rau.creditsuisse.util.TestUtil;

/**
 * Unit test for simple App.
 */
public class AppTest {
	@Test
	public void testApp() throws CreditSuisseException {
		App app = new App();
		app.main(new String[] { "C 20 4" });

		char[][] actualCanvas = app.commandControl.getCh();

		char[][] expectedCanvas = TestUtil.emptyCanvas(20, 4);

		for (int row = 0; row < actualCanvas.length; row++) {
			for (int column = 0; column < actualCanvas[row].length; column++) {

				Assert.assertEquals(expectedCanvas[row][column], actualCanvas[row][column]);
			}
		}
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testNegativeScenarioApp() throws CreditSuisseException {
		App app = new App();
		app.main(new String[] { "C" });

		char[][] actualCanvas = app.commandControl.getCh();

	}

}
