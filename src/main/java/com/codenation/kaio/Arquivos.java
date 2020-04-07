package com.codenation.kaio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import com.codenation.kaio.models.ChallengeModel;

public class Arquivos {
	
	String pathToFile = "D:\\Kaio\\CodeNation\\answer.json";
	
	public Arquivos() {
		createFile();
	}

	
	public void createFile() {
		new File(pathToFile);
		System.out.println("Arquivo criado!");
	}
	
	
	public  void writeFile(ChallengeModel challenge) {

		try {
			FileWriter fileWriter = new FileWriter(pathToFile);
			fileWriter.write(challenge.toString());
			fileWriter.close();
			System.out.println("Arquivo gravado!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
