package com.codenation.kaio;

public class Decifra {
	
	

	public String decifra(int qtdeCasas, String cifrado) {
		StringBuilder decifrado = new StringBuilder();

		for (int i = 0; i < cifrado.length(); i++) {
			if (cifrado.charAt(i) >= 97 && cifrado.charAt(i) <= 122) {
				int cod = (int) cifrado.charAt(i) - qtdeCasas;
				if (cod < 97) {
					cod = cod + 26;
				}
				decifrado.append((char) cod);
			}
			if (cifrado.charAt(i) == 32) {
				decifrado.append(" ");
			}

			if (cifrado.charAt(i) >= 33 && cifrado.charAt(i) <= 47) {
				decifrado.append(cifrado.charAt(i));
			}
		}
		System.out.println("Texto decifrado");
		return decifrado.toString();
	}


}
