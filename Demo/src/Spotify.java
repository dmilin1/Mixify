

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Spotify {
  private static final String clientId = "abeef9600bad45989e961fcaa940fce4";
  private static final String clientSecret = "43c5fefb4d704fc3a4afeb6bae77355a";
  private static final URI redirectUri = SpotifyHttpManager.makeUri("https://open.spotify.com");

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
          .setClientId(clientId)
          .setClientSecret(clientSecret)
          .setRedirectUri(redirectUri)
          .build();
  private static final AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
          .state("x4xkmn9pu3j6ukrs8n")
          .scope("user-read-birthdate,user-read-email")
          .show_dialog(true)
          .build();

  public static void authorizationCodeUri_Sync() {
    final URI uri = authorizationCodeUriRequest.execute();

    System.out.println("URI: " + uri.toString());
  }

  public static void authorizationCodeUri_Async() {
    try {
      final Future<URI> uriFuture = authorizationCodeUriRequest.executeAsync();

      // ...

      final URI uri = uriFuture.get();

      System.out.println("URI: " + uri.toString());
    } catch (InterruptedException | ExecutionException e) {
      System.out.println("Error: " + e.getCause().getMessage());
    }
  }
  
  public static void main(String[] args) {
	Spotify spot = new Spotify();
	spot.authorizationCodeUri_Sync();
	AuthorizationCodeExample derp = new AuthorizationCodeExample();
	derp.authorizationCode_Sync();
}
}