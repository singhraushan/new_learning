package com.rau.zafin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Raushan kumar
 *
 */
public class ValidWord {

	/*
	 * using set to avoid duplicate possible word fand better performance while
	 * searching in dictionary
	 */
	private Set<String> set = new LinkedHashSet<String>();
	private int biggestColumn;

	private static Map<String, String> dictionary = new HashMap<String, String>();

	static {
		dictionary.put("MAT", "A piece of protective material placed on a floor, in particular.");
		dictionary.put("HAT",
				"A shaped covering for the head worn for warmth, as a fashion item, or as part of a uniform.");
		dictionary.put("AIR",
				"The invisible gaseous substance surrounding the earth, a mixture mainly of oxygen and nitrogen.");
		dictionary.put("TAME", "not dangerous or frightened of people; domesticated.");
		dictionary.put("TINT", "A shade or variety of color.");
		// ........add all dictionary word to dictionary in UPPER CASE to test
		// the flow.
	}

	public static void main(String[] args) {
		ValidWord obj = new ValidWord();

		// 1st way to get input data and test the flow
		obj.simpleUI();

		// 2nd way to get input data and test the flow
		// obj.process(obj.getInputDataFromUser());
	}

	public void process(List<String> inputBlockLetters) {
		set = new LinkedHashSet<String>();
		generateAllPossibleLeftToRightAndRightToLeftWord(inputBlockLetters);
		generateAllPossibleTopToBottomAndBottomToTopWord(inputBlockLetters);
		generateAllPossibleLeftToRightDiagonallyAndReverseWord(inputBlockLetters);
		generateAllPossibleRightToLeftDiagonallyAndReverseWord(inputBlockLetters);
		printValidWord(set);
	}

	// creating UI using Jframe not using web application to avoid Server setup
	private void simpleUI() {

		JFrame f = new JFrame("Zafin Word validation Demo");
		JLabel label = new JLabel();
		label.setText("Enter BlockLetters:");
		label.setBounds(10, 10, 150, 150);

		JTextArea textfield = new JTextArea();
		textfield.setBounds(150, 10, 200, 200);
		textfield.setLineWrap(true);
		textfield.setWrapStyleWord(true);

		JButton b = new JButton("Submit");
		b.setBounds(150, 220, 140, 40);

		JLabel label1 = new JLabel();
		label1.setBounds(10, 225, 200, 100);

		JLabel searchLabel = new JLabel();
		searchLabel.setText("Search word:");
		searchLabel.setBounds(10, 250, 150, 150);
		
		JTextField textfieldSerach = new JTextField();
		textfieldSerach.setBounds(150, 310, 200, 30);
		
		JButton searchBtn = new JButton("Submit");
		searchBtn.setBounds(150, 350, 140, 40);

		JLabel searchResultLabel = new JLabel();
		searchResultLabel.setBounds(150, 360, 400, 100);

		// add to frame
		f.add(label);
		f.add(textfield);
		f.add(b);
		f.add(label1);
		
		f.add(searchLabel);
		f.add(textfieldSerach);
		f.add(searchBtn);
		f.add(searchResultLabel);
		
		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// action listener
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				label1.setText("BlockLetters has been submitted.");
				List<String> inputBlockLetters = new ArrayList<String>();
				for (String line : textfield.getText().split("\n")) {
					inputBlockLetters.add(line);
					if (line.length() > biggestColumn)
						biggestColumn = line.length();
				}
				process(inputBlockLetters);
			}
		});

		// searchBtn listener
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String meaning = dictionary.get(textfieldSerach.getText().toUpperCase());
				System.out.println("meaning: " + meaning);
				if (meaning == null)
					searchResultLabel.setText("Word not found in dictionary!");
				else
					searchResultLabel.setText(meaning);
			}
		});
	}

	// 2nd way to get input data
	// Reading input data
	private List<String> getInputDataFromUser() {
		List<String> inputBlockLetters = new ArrayList<String>();
		inputBlockLetters = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		String decision = "N";
		do {
			System.out.println("Please enter letters: ");
			String input = scan.nextLine().trim();
			inputBlockLetters.add(input);
			if (input.length() > biggestColumn)
				biggestColumn = input.length();
			System.out.println("Do you want to enter more letters ? Y/N: ");
			decision = scan.nextLine().trim();
		} while (decision.equalsIgnoreCase("Y"));
		scan.close();

		return inputBlockLetters;
	}

	// Collecting possible word from left to right & right to left
	private void generateAllPossibleLeftToRightAndRightToLeftWord(List<String> inputBlockLetters) {
		for (String line : inputBlockLetters) {
			possibleWord(line);
			possibleWord(new StringBuilder().append(line).reverse().toString());
		}
	}

	// Collecting possible word from top to bottom & bottom to top
	private void generateAllPossibleTopToBottomAndBottomToTopWord(List<String> inputBlockLetters) {
		for (int column = 0; column < biggestColumn; column++) {
			StringBuilder sb = new StringBuilder();
			for (int row = 0; row < inputBlockLetters.size(); row++) {
				if (inputBlockLetters.get(row).length() > column)
					sb.append(inputBlockLetters.get(row).charAt(column));
				else
					sb.append(' ');
			}
			if (sb.toString().trim().length() > 1) {
				possibleWord(sb.toString().trim());
				possibleWord(sb.reverse().toString().trim());
			}
		}
	}

	// Collecting possible word from left to right diagonally & reverse.
	private void generateAllPossibleLeftToRightDiagonallyAndReverseWord(List<String> inputBlockLetters) {
		// lower part
		for (int row = inputBlockLetters.size() - 2; row >= 0; row--) {
			StringBuilder sb = new StringBuilder();
			for (int column = 0; row + column < inputBlockLetters.size(); column++) {
				if (inputBlockLetters.get(row + column).length() > column)
					sb.append(inputBlockLetters.get(row + column).charAt(column));
				else
					sb.append(' ');
			}
			if (sb.toString().trim().length() > 1) {
				possibleWord(sb.toString().trim());
				possibleWord(sb.reverse().toString().trim());
			}
		}
		// upper part
		for (int column = 1; column < biggestColumn - 1; column++) {
			StringBuilder sb = new StringBuilder();
			for (int row = 0; row < inputBlockLetters.size() && column + row < biggestColumn - 1; row++) {
				if (inputBlockLetters.get(row).length() > column + row)
					sb.append(inputBlockLetters.get(row).charAt(column + row));
				else
					sb.append(' ');
			}
			if (sb.toString().trim().length() > 1) {
				possibleWord(sb.toString().trim());
				possibleWord(sb.reverse().toString().trim());
			}
		}
	}

	// Collecting possible word from right to left diagonally & reverse.
	private void generateAllPossibleRightToLeftDiagonallyAndReverseWord(List<String> inputBlockLetters) {
		for (int row = inputBlockLetters.size() - 2; row >= 0; row--) {// lower
			// part
			StringBuilder sb = new StringBuilder();
			for (int column = biggestColumn - 1; row + (biggestColumn - 1 - column) < inputBlockLetters
					.size(); column--) {
				if (inputBlockLetters.get(row + (biggestColumn - 1 - column)).length() > column)
					sb.append(inputBlockLetters.get(row + (biggestColumn - 1 - column)).charAt(column));
				else
					sb.append(' ');
			}
			if (sb.toString().trim().length() > 1) {
				possibleWord(sb.toString().trim());
				possibleWord(sb.reverse().toString().trim());
			}
		}
		for (int column = biggestColumn - 2; column > 0; column--) {// upper
																	// part
			StringBuilder sb = new StringBuilder();
			for (int row = 0; row < inputBlockLetters.size() && column - row >= 0; row++) {
				if (inputBlockLetters.get(row).length() > column - row)
					sb.append(inputBlockLetters.get(row).charAt(column - row));
				else
					sb.append(' ');
			}
			if (sb.toString().trim().length() > 1) {
				possibleWord(sb.toString().trim());
				possibleWord(sb.reverse().toString().trim());
			}
		}
	}

	// Not considering single char, because single char can't be word.
	public void possibleWord(String inputStr) {

		StringBuilder sb = null;
		for (int i = 0; i < inputStr.length(); i++) {
			sb = new StringBuilder().append(inputStr.charAt(i));
			for (int j = i + 1; j < inputStr.length(); j++) {
				set.add(new StringBuilder(sb).append(inputStr.substring(i + 1, j + 1)).toString());
			}
		}
	}

	// validating word
	public void printValidWord(Set<String> words) {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("words.txt"));
			for (String word : words) {
				if (dictionary.containsKey(word.toUpperCase())) {
					writer.write(word);
					writer.newLine();
					System.out.println("Valid word: " + word);
				}
			}
			System.out.println("words.txt file saved.");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
