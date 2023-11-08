# Current Place Details on Map and News Fetcher

## Overview

This Android application provides two main features:
1. Displaying a map that indicates the user's current location along with the option to explore nearby places.
2. Fetching the latest news articles based on a predefined query using the NewsAPI.

The app consists of two primary activities:
- `MapsActivityCurrentPlace`: Displays the current location on the map and nearby places.
- `NewsActivity`: Retrieves and displays news articles related to the query "tesla".

## Screenshots

![Screenshot1](Screenshot(1).jpg "Screenshot 1")
![Screenshot2](Screenshot(2).jpg "Screenshot 2")
![Screenshot3](Screenshot(3).jpg "Screenshot 3")



## Features

### Maps Activity

- Utilizes the Google Maps API to display the map.
- Fetches the user's current location and displays it on the map.
- Offers a list of likely places near the current location to choose from.
- Custom information windows for map markers.
- Polylines on the map to represent certain areas.
- Location permission handling to ensure user privacy.

### News Activity

- Uses Retrofit library to make network requests to the NewsAPI.
- Fetches news articles from the past day about "tesla".
- Parses JSON responses and updates the UI with the latest news articles.
- Error handling for scenarios such as null responses or empty article lists.

## Technical Details

- Retrofit is used for making asynchronous API requests.
- GsonConverterFactory handles the conversion of JSON to Java objects.
- Custom ArrayAdapter (`NewsAdapter`) to populate a ListView with news articles.
- Error logging for debugging API call issues.
- NewsAPI interface defines the GET request parameters and endpoint for Retrofit.
- Handling Android lifecycle by saving instance states.

## Permissions

- Internet Access: To fetch data from the NewsAPI and Google Maps.
- Access Fine Location: To get the precise location for the Maps feature.

## API Keys

- A valid Google Maps API key is required to use the mapping features.
- A valid NewsAPI key is required to fetch news articles.

## Usage

1. Ensure you have the required API keys set in your `BuildConfig` or as a resource.
2. Compile and run the application on an Android device with API level 26 or higher.
3. Grant location permissions when prompted to use the Maps feature.
4. Access the news feature from the menu to see the latest articles.

## Libraries

- Retrofit 2: HTTP Client for Android and Java by Square.
- Gson: A Java serialization/deserialization library to convert Java Objects into JSON and back.
