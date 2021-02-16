package web.controllers;

import business.Hash;
/**
 * Servlet implementation class TotoController
 */

public class TotoController  {
	public static void main(String[] args) {
		String mdp = "0";
		System.out.println(Hash.makeHash(mdp));
	}

}
