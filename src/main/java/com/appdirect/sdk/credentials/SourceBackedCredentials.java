package com.appdirect.sdk.credentials;

import com.appdirect.sdk.appmarket.Credentials;
import com.appdirect.sdk.appmarket.DeveloperSpecificAppmarketCredentialsSupplier;

import java.util.function.Function;

import static com.appdirect.sdk.appmarket.Credentials.invalidCredentials;

/**
 * Function to find Credentials by key from a different sources: Database, ResourceFile, in memory cache, etc.
 */
public class SourceBackedCredentials implements DeveloperSpecificAppmarketCredentialsSupplier {
	private final Function<String, Credentials> credentialsFinder;

	public SourceBackedCredentials(Function<String, Credentials> credentialsFinder) {
		this.credentialsFinder = credentialsFinder;
	}

	@Override
	public Credentials getConsumerCredentials(String consumerKey) {
		return credentialsFinder.apply(consumerKey);
	}
}
