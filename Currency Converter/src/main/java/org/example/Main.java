package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class Main {

    // Replace this with your API key
    private static final String API_KEY = "ebb38a19dad4bd1c9616cc8f";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base currency (e.g., USD): ");
        String baseCurrency = sc.next().toUpperCase();

        System.out.print("Enter target currency (e.g., NPR): ");
        String targetCurrency = sc.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = sc.nextDouble();

        try {
            // API URL for conversion
            String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + baseCurrency;

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseStr = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                responseStr.append(line);
            }
            in.close();

            // Parse JSON using org.json
            JSONObject json = new JSONObject(responseStr.toString());

            if (json.getString("result").equals("success")) {
                JSONObject rates = json.getJSONObject("conversion_rates");
                double rate = rates.getDouble(targetCurrency);
                double convertedAmount = amount * rate;

                System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
            } else {
                System.out.println("Failed to fetch exchange rate. Please check currency codes.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
