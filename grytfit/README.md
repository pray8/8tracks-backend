REST API for the application -
-----------------------------------------------------------------------------------------------------------
The result shown is sorted on the basis of highest "playCount" first and if "playCount" is same then it is sorted on the basis of "likeCount".
-----------------------------------------------------------------------------------------------------------
JVM should be installed in the system.
To start the server run the main method as Java application.
To start the server from CMD run this command = "gradlew bootrun".
To start the server from Git Bash run this command = "./gradlew bootrun".

1. GET request url = "http://localhost:8080/playlist"
2. GET request for searched tags url = "http://localhost:8080/playlist/hello@world" - any number of tags can be passed seperated with "@".
        General form of url = "http://localhost:8080/playlist/<sequence_of_tags_seperated_by_@>"

3. POST request url = "http://localhost:8080/playlist" - can be done by POSTMAN by selecting POST method.The JSON data should be in below format -
                {
                    "playlistId": 1,
                    "playlistName": "Rock Music",
                    "authorName": "Hi",
                    "numberOfTracks": 500,
                    "playCount": 1000000,
                    "likeCount": 50000,
                    "tags": [
                        "Love",
                        "Rock"
                    ]
                }

4. DELETE request url = "http://localhost:8080/playlist/<playlistId>" - can be made using POSTMAN by selecting the DELETE method.