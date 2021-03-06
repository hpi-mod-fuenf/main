# Entwurf:

- [X] Aktualisierte Sequenz-Diagramme (2.) und aktualisiertes ITask als SVG exportieren
- [X] 8.: Diagramme an veränderte Use Cases anpassen
- [x] OCL shit
- [x] "Select best match"-Aktivitätsdiagramm einfügen @Baschdl 
- [x] "Enters" einfügen
- [ ] Aktivitätsdiagramm driveAroundObstacle Prioritäten-Ausweichen @josauder 
- [x] Bildunterschriften @bakoe @Fluepke 
- [x] Erklärung Netzwerkkomponenten/ Kommunikation (Remote Procedure Calls) ("NetworkAccess implementiert IWlanAdapter und MessageHandler")
- [x] Diagramm zu Queue
- [x] "VirtualRobots" auf dem Server verwenden, Methoden können nicht direkt auf der "RobotUnit" aufgerufen werden
- [X] Methoden der Interfaces irgendwo verwenden
- [x] Sequenzdiagramme für IWlanAdapter und MessageHandler modellieren (RPC)
- [x] Benötigen wir wirklich die taskDistribution?
- [x] evt. kollidiert das "Select Best Match"-Sequenzdiagramm und die Modellierung bei den Paketdetails
- [x] Return void bei Interfaces
- Diagramme
  - [x] receiveMessage
  - [x] RPC
  - [x] handleArrival
  - queue @jcremerius @jonashering 
     - [x] add
     - [x] addTopOfType
     - [x] poll
     - [x] remove
  - [x] TaskPriorityQueue
  - [x] OCL
  - [x] SelectBestMatch
- [x] Klassendiagramm layouten
- [x] Fehlen unter "3.2 Interfaces" noch die Interfaces IRepair und ...? @Fluepke @jcremerius 
- [x] "Interaktion bei Ausführung von Receive Order & Cancel Order" Enthält, dass die Warteliste beim Krankentransport nur von theoretischer Natur ist, aber das betrachte ich als falsch.
- [x] ChooseRobot überarbeiten (Server weiß jetzt, welche VirtualRobotUnit momentan welchen Task ausführt)
- [x] Initialisierungssequenz (IMessageHandler, IBumperHandler, weitere?)
- [x] Aktivitätsdiagramm zur Queue aktualisieren: Fall hinzufügen, dass ein Robot gewählt wird, der bereits einen Taxi-Task auswählt. Dann muss ein neuer Task (aktualisierte Destinations!) erstellt werden und der Queue hinzugefügt werden. 
- [x] Beschreibung zu Figure 4 und 5
- [x] Sequenzdiagramme Kapitel 2 überprüfen+korrigieren
- [x] Datentyp von Task.type von `String` zu `enum` (hospital, taxi) ändern
- [ ] Beschreibungen zu aktualisierten Sequenzdiagrammen in 2. Interaktion der Komponenten aktualisieren (Wichtig: "Unser sendQueueIndex() ruft bei Taxi-Aufträgen intern die gegebene reportNumberInList()-Methode auf")
- [X] Möglichkeit für "cancel order" einbauen
- [X] Methoden des AppContainers etc. einbauen
- [x] Im Text daruf hinweisen: Es gibt höchstens so viele Krankenhaustransporte wie Robots, inbesondere: Krankenhaustransporte werden immer sofort ausgeführt und können nicht in die Warteliste
- [x] Aktivitätsdiagramme "driveToDestination", Abfrage mit dem Obstacle ergibt noch nicht all zu viel Sinn @josauder


## nachträgliche Änderungen Analyse:

- [x] "Obstacle" soll laut Max/ Hänsel nicht modelliert werden
- [x] Datentypen (Position, Destination) ebenso nicht
- [x] Use-Case-Namen vielleicht irgendwo erklären
- [x] "Robot" und "RobotUnit" konsistenter
- [x] Annahme "Es gibt mind. einen Roboter"
- [x] "Figure 2: Illustration von 1: Choose Robot durch Aktivitätendiagramm" Swimlane mit Plural "Robots" bezeichnen, da dort nicht nur ein Robot angefragt wird
- [x] Typo im ersten Teil @bakoe 
- [x] Annahme "Es kann mehr Krankentransporte als Roboter geben"

## Verbesserungen nach dem Review übernehmen
- [x] Abstrakte Architektur anpassen @dschwenkert 
- [x] "Take Patient To Hospital"-Sequenzdiagramm: Referenz (?) und evt. gestrichelte Linie verwenden @jakobbraun @djdj10x10 
- [x] "Select Best Match"-Sequenzdiagramm alternatives vertauschen @jakobbraun @djdj10x10 
- [x] Konkrete Architektur der RobotSoftware anpassen, richtiger Name @Fluepke @jcremerius 
- [x] HardwareInterfaces aus Paketstruktur löschen @josauder @bakoe @baschdl
- [x] Kapitel 7: mehr Diagramme
- [x] komische Lebenslinien, auf Parallelität/ Deadlocks achten
- [x] "Interaktion bei Ausführung von Use Case 4 – Charging" steht irgendwas mit Kommunikation von RobotUnit und ChargingStation
- [x] Kapitel 9: Interface "IWlanAdapter" @jonashering 

# Proofread

- [ ] Abgeschnittene Texte in Diagrammen
- [ ] `TaskSystem` zu `TaskPriorityQueue`
- [ ] `RobotControlSystem` zu `VirtualRobotManager`
- [ ] `RobotUnit` verwenden, nicht `Robot`
- [ ] Warteliste in 2. "Das System arbeitet mit einer Warteliste."
- [ ] Paketnamen "Robot" in 6. inkonsistent zu 7.
