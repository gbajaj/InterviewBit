package com.letsdecode.interviewbit;

import java.util.*;

class Main {
	public static void main(String[] args) {

		List<String> list = new ArrayList();
		subStrings(
				list,
				"ohazmsexovixkuuneqnzdhhsweyjmrevqszglreqzacuzefaszzyzramuctxeusmzmtajezzfnrqmmmcyvrogrhntqwlbfpatgjxlweewaiaqidxrqplxdudscuqhrfjtqvksksnfmfhcodvghtkgzojpzytmdcimjzwaonnwmhmsaacnrblvvzhwbiokgziuvsfersuxiiydcfcvnkpbzljsqrqtgmhywkjxlxsixlxrwsnyypjkoxgtyczbouvojmfoqptnqfkvrynavuywnemedlvbvlafhorcfpqixphfwoybefcsbubegqmhcgyfbetfsyuqbadugfylowmzrifijkzlpawkewixgcfvqxapcyzpegrzrqczfdssgvspnjktlshhjqvvlkcmvwtwclpfwlwwulvfvmnnzldpiotcalpktbklalusufgbkrqgzdbagtqzlzealvq");

		int max = 0;
		String subseq = "pxmfjrmvkehafjpxrehkkqcqbjpcmxymsgnfdzzplkdaewzoteyavwwzcnbtsrxyccjxfmbwsfquqelpicmmvymatfvwpemabhlxpjxuywludjhkfwpyowvnkpupalimnnecvtesblatxnewkywvvohdbgfavjxumqhvkznutjpowuvhmnyvzbykuzmchbnlmuiavdfbcuutaqqgiwhjefmcapfisdtohavoputtnhzecalriymlnfabvtbkhtnpenxkbtubuyskwykpablacspjkanwlnxeuuksccptvtqwomusmvuygfdmbkftbdlwmmxeudbdknqudfcrsaefetouygyejfelfqoqvhfabprdbjcihqrzfdbqcafvoowjskqwzironkxxsqedgbycvhnuskhdkkgfpggahvuznqytlldquvbofbxafrxmnbaignazengaxngdobatpmqfzghlamzuoelwvajlvzbuoxwluxqhsmcj";

		for (String s : list) {
			char[] arr = s.toCharArray();
			int i = 0;
			int j = 0;
			while (i < arr.length) {
				while (j < subseq.length() && arr[i] != subseq.charAt(j))
					j++;
				if (j == subseq.length())
					break;
				i++;
			}

			if (i == arr.length)
				max = Math.max(max, arr.length);
		}

		System.out.println(max);
	}

	private static void subStrings(List<String> list, String inp) {
		for (int i = 0; i < inp.length(); i++) {
			for (int j = i + 1; j <= inp.length(); j++) {
				list.add(inp.substring(i, j));
			}
		}
	}

}
