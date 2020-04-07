package com.codenation.kaio;

import org.json.simple.JSONObject;
import com.codenation.kaio.http.HttpClient;
import com.codenation.kaio.models.ChallengeModel;

public class Principal {
	public static void main(String[] args) throws Exception {

		HttpClient httpClient = new HttpClient();
		JSONObject json = httpClient.getMethod();
		Arquivos createFile = new Arquivos();
		createFile.writeFile(updateFile(json));
		httpClient.postMethod();
	}
	
	
	
	private static ChallengeModel updateFile(JSONObject json) {
		int numero_casas = Integer.parseInt(json.get("numero_casas").toString());
		String cifrado = json.get("cifrado").toString();
		String token = json.get("token").toString();
		String decifrado = new Decifra().decifra(numero_casas, cifrado);
		String resumoCriptografico = new Crypto().cryptoResume(decifrado);

		ChallengeModel challengeModel = ChallengeModel.builder().withCifrado(cifrado).withNumeroCasas(numero_casas)
				.withToken(token).withDecifrado(decifrado).withResumoCriptografico(resumoCriptografico).build();
	return challengeModel;
		
	}
}
