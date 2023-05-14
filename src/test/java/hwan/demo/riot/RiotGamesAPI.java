package hwan.demo.riot;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RiotGamesAPI {

    private static final String API_KEY = "RGAPI-75ff42e5-25e1-4ae4-a3bd-f53509436dde";
    private static final String BASE_URL = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/";

    public static JSONArray getRecentMatchesByPuuid(String puuid, int count) {
        try {
            URL url = new URL(BASE_URL + puuid + "/ids?count=" + count);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Riot-Token", API_KEY);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONArray matchIds = new JSONArray(response.toString());
            JSONArray matches = new JSONArray();
            for (int i = 0; i < matchIds.length(); i++) {
                String matchId = matchIds.getString(i);
                URL matchUrl = new URL("https://asia.api.riotgames.com/lol/match/v5/matches/" + matchId);
                HttpURLConnection matchConnection = (HttpURLConnection) matchUrl.openConnection();
                matchConnection.setRequestMethod("GET");
                matchConnection.setRequestProperty("X-Riot-Token", API_KEY);

                BufferedReader matchIn = new BufferedReader(new InputStreamReader(matchConnection.getInputStream()));
                String matchInputLine;
                StringBuilder matchResponse = new StringBuilder();

                while ((matchInputLine = matchIn.readLine()) != null) {
                    matchResponse.append(matchInputLine);
                }
                matchIn.close();

                JSONObject match = new JSONObject(matchResponse.toString());
                matches.put(match);
            }
            return matches;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    private static String getPuuidBySummonerName(String summonerName) {
        String url = String.format(
                "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/%s",
                summonerName
        );

        try {
            URL apiURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiURL.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Riot-Token", API_KEY);

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));

                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }

                in.close();

                JSONObject jsonObject = new JSONObject(response.toString());
                return jsonObject.getString("puuid");
            } else {
                System.out.println("API 요청 실패");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
    // 다른 메소드들은 생략합니다.
    @Test
    public void testGetRecentMatchesByPuuid() {
        String puuid = RiotGamesAPI.getPuuidBySummonerName("달려라토레스");

        JSONArray matches = RiotGamesAPI.getRecentMatchesByPuuid(puuid, 10);

        assertNotNull(matches);
        System.out.println(matches);
    }

    @Test
    public void testGetPuuidBySummonerName() {
        String summonerName = "달려라토레스";

        String puuid = RiotGamesAPI.getPuuidBySummonerName(summonerName);

        assertNotNull(puuid);
        System.out.println(puuid);
    }
}
