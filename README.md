# BiałQA 2018 
Materiały do prezentacji live na BiałQA, 25 stycznia 2018

### Budowanie obrazów
1. Zainstauj serwer Docker'a 
2. Wejdź do katalogu `/json-server` i odpal skrypt `build.sh`
3. Wejdź do katalogu `/tests` i odpal skrypt `build.sh`

### Odpalenie serwera
1. Wejdź do katalogu `/json-server`
2. Odpal skrypt `run.sh`
3. Włącz w pzeglądarce adres `http://localhost:3000`
4. Odpal skrypt `/json-server/kill.sh`aby ubić serwer

### Uruchomienie testów i serwera
1. Wejdź do głównego katalogu 
2. Wykonaj polecenie `docker-compose up`, po wszystkich skryptach wciśnij `CTRL+C`, żeby przerwać
3. Wykonaj polecenie `docker-compose down`
4. Po wykonanych testach srpawdź, że utworzył się raport w folderze `/reports`
