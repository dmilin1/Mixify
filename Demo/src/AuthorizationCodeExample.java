import com.google.gson.JsonParser;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import com.wrapper.spotify.requests.data.player.StartResumeUsersPlaybackRequest;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AuthorizationCodeExample {
  private static final String clientId = "abeef9600bad45989e961fcaa940fce4";
  private static final String clientSecret = "43c5fefb4d704fc3a4afeb6bae77355a";
  private static final URI redirectUri = SpotifyHttpManager.makeUri("https://open.spotify.com");
  private static final String code = "AQDXWDTxIJtcOrzzXTseBKKJCuojs41L5Ffszts9Z9BqD2qGfAEPtkuAEN1umqNhX8_uO5TpbqiZTaXe_He1fHUFaEDIjvxO-ueGI-tXtJmzn7EtMhinS-vaahcYJ-HotUZB5I4oUALsygRSVc4KU2XskhovW82VDgaO3qx8pYoBYUoEdm_G7EGi3nLCCDLurtvXYy53NU-sb1Zqf8hlERgkn7qBawD2TNcLDqWBmfNfJUTH";

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
          .setClientId(clientId)
          .setClientSecret(clientSecret)
          .setRedirectUri(redirectUri)
          .build();
  private static final AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(code)
          .build();

  public static void authorizationCode_Sync() {
    try {
      final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRequest.execute();

      // Set access and refresh token for further "spotifyApi" object usage
      spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
      spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());

      System.out.println("Expires in: " + authorizationCodeCredentials.getExpiresIn());
    } catch (IOException | SpotifyWebApiException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void authorizationCode_Async() {
    try {
      final Future<AuthorizationCodeCredentials> authorizationCodeCredentialsFuture = authorizationCodeRequest.executeAsync();

      // ...

      final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeCredentialsFuture.get();

      // Set access and refresh token for further "spotifyApi" object usage
      spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
      spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());

      System.out.println("Expires in: " + authorizationCodeCredentials.getExpiresIn());
    } catch (InterruptedException | ExecutionException e) {
      System.out.println("Error: " + e.getCause().getMessage());
    }
  }
  
  private static final StartResumeUsersPlaybackRequest startResumeUsersPlaybackRequest = spotifyApi
          .startResumeUsersPlayback()
          .context_uri("spotify:album:5zT1JLIj9E57p3e1rFm9Uq")
          .device_id("5fbb3ba6aa454b5534c4ba43a8c7e8e45a63ad0e")
          .offset(new JsonParser().parse("{\"uri\":\"spotify:track:01iyCAUm8EvOFqVWYJ3dVX\"}").getAsJsonObject())
          .uris(new JsonParser().parse("[\"spotify:track:01iyCAUm8EvOFqVWYJ3dVX\"]").getAsJsonArray())
          .build();
  
  public static void startResumeUsersPlayback_Sync() {
	    try {
	      final String string = startResumeUsersPlaybackRequest.execute();

	      System.out.println("Null: " + string);
	    } catch (IOException | SpotifyWebApiException e) {
	      System.out.println("Error: " + e.getMessage());
	    }
	  }
  
  public static void main(String[] args) {
	AuthorizationCodeExample derp = new AuthorizationCodeExample();
	derp.authorizationCode_Sync();
	derp.startResumeUsersPlayback_Sync();
}
  
}