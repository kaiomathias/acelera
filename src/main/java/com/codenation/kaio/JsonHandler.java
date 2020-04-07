package com.codenation.kaio;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.codenation.kaio.models.ChallengeModel;

public class JsonHandler {
	
	private static ChallengeModel jsonObject;

	public static ChallengeModel readJson() {
		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader("D:\\Kaio\\Codenation\\answer.json"));

			JSONObject json = (JSONObject) obj;
			
			jsonObject = ChallengeModel.builder()
					.withNumeroCasas(Integer.parseInt(json.get("numero_casas").toString()))
					.withCifrado(json.get("cifrado").toString())
					.withToken(json.get("token").toString()).build();

		} catch (IOException e) {

		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		
		return jsonObject;

	}
	

}
