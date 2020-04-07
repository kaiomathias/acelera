package com.codenation.kaio.models;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.annotation.Generated;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ChallengeModel {
	
	int numeroCasas;
	String token;
	String cifrado;
	String decifrado;
	String resumo_criptografico;

	@Generated("SparkTools")
	private ChallengeModel(Builder builder) {
		this.numeroCasas = builder.numeroCasas;
		this.token = builder.token;
		this.cifrado = builder.cifrado;
		this.decifrado = builder.decifrado;
		this.resumo_criptografico = builder.resumo_criptografico;
	}
	
	public int getNumeroCasas() {
		return numeroCasas;
	}
	public String getToken() {
		return token;
	}
	public String getCifrado() {
		return cifrado;
	}
	public String getDecifrado() {
		return decifrado;
	}
	public String getResumoCriptografico() {
		return resumo_criptografico;
	}
	public void setNumeroCasas(int numeroCasas) {
		this.numeroCasas = numeroCasas;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public void setCifrado(String cifrado) {
		this.cifrado = cifrado;
	}
	public void setDecifrado(String decifrado) {
		this.decifrado = decifrado;
	}
	public void setResumoCriptografico(String resumoCriptografico) {
		this.resumo_criptografico = resumoCriptografico;
	}
	/**
	 * Creates builder to build {@link ChallengeModel}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}
	/**
	 * Builder to build {@link ChallengeModel}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private int numeroCasas;
		private String token;
		private String cifrado;
		private String decifrado;
		private String resumo_criptografico;

		private Builder() {
		}

		public Builder withNumeroCasas(int numeroCasas) {
			this.numeroCasas = numeroCasas;
			return this;
		}

		public Builder withToken(String token) {
			this.token = token;
			return this;
		}

		public Builder withCifrado(String cifrado) {
			this.cifrado = cifrado;
			return this;
		}

		public Builder withDecifrado(String decifrado) {
			this.decifrado = decifrado;
			return this;
		}

		public Builder withResumoCriptografico(String resumoCriptografico) {
			this.resumo_criptografico = resumoCriptografico;
			return this;
		}

		public ChallengeModel build() {
			return new ChallengeModel(this);
		}
	}
	
	   @Override
	    public String toString() {
	        return ToStringBuilder.reflectionToString(this, JSON_STYLE);
	    }
	

}
