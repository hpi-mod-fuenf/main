# Protokoll 11.05.
- Abwesende Personen: Dominik
- __Nächstes Treffen: 12.05.2016, 09:00 Uhr dschool-Poolraum/Dachterrasse__

## Feedback Analyse

### Layout
- Verantwortlichkeiten auf eigene Seite, nicht zusammen mit Inhaltsverzeichnis
- vertikale Linien in Tabellen!
- "Holger" in der Fußzeile?

### Inhaltliches
- gut, dass wir an manchen Stellen gesagt haben "[...] wäre eine Entwurfsentscheidung, die hier noch nicht getroffen wurde."
- nicht sowas wie "was später weiter gemacht wird" (zu meta)
- im finalen Dokument mehr auf Rechtschreibung und Grammatik achten
- Glossar: zu wenig!
    + z.B. Robot: einzelne Instanz von Roboter, der in Stadt rumfährt und Aufgaben vom Server zugewiesen bekommt ...
    + aber nicht mehr Begriffe, nur mehr Erläuterungen pro Begriff
- Modell des Problembereichs
    + **Multiplizitäten fehlen bei keepsTrackOf**
    + gut, dass überall Rollennamen sind
- Geschäftsprozesse
    + 
- Use-Case-Diagramme
    + **müssen eindeutig feiner/präziser sein als die Geschäftsprozesse**
    + **hier falsch: Use Case der 1:1 mit Geschäftsprozess übereinstimmt**
        * z.B. **besser**: driveToPosition, avoidObstacle: beide gehören zu DriveToDestination
    + Pfeile bei Abb. 5 am gleichen Punkt beginnen lassen
    + konsistenteren Stil (Use-Case-Diagramme haben verschiedene Skalierungen)
    + **Erklären, woher die Environments kommen**
    + möglichst andere Environments verwenden
    + Beschreibung zu den Use Cases: o.k.
    + Charging:
        * **taucht nicht im Use-Case-Diagramm auf!**
        * Schritte 1 und 4 bei Standardablauf weglassen
    + bei Standardablauf mit nur einem Schritt: evtl. weglassen, kann aber auch drin bleiben
- Produktumgebung
    + IServerMessageHandler: "Der Einfachheit halber wird angenommen, die dahinterstehende Infrastruktur zur Übertragung von Nachrichten ist stets stabil" ist zu praktisch/spezifisch --> evtl. weglassen!
    + Evtl. ist es überflüssig, zu den bereits beschriebenen Komponenten/Interfaces nochmal Texte zu schreiben

## Besprechung Entwurfs-Template

### Annahmen für den Entwurf
- als eigenes Kapitel vor 1.

### 1. Abstrakte Architektur
- nur bereits vorgegebene Komponenten verwenden
- nichts neues erstellen
- erläuternder Text

### 2. Interaktion der Komponenten
- Fragmente (in Visual Paradigm: *Guards*)
    + *loop*: Schleife
    + *opt*: if ..., dann ..., ansonsten überspringen
    + *break*: wenn Bedingung zutrifft, wird umgebenende Umgebung verlassen
    + usw.

### 3. Komponentenschnittstellen
- evtl. hier: Erstellung eigener, neuer Interfaces macht in 0. Iterationsstufe keinen Sinn
- alle Interfaces, die hinzugefügt wurden, müssen erklärt werden (z.B. Interaktion Server-Roboter)

### 4. Konkrete Architektur
- auch hier: von uns eingeführte Dinge erklären

### 6. Paketstruktur
- *Common*-Paket: von beiden verwendet, vermeidet Redundanz
- *import*: alles wird eingebunden, geht aber nicht "im Kreis"
- *access*: nur auf bestimmte Methoden wird zugegriffen, geht auch "im Kreis"

### 7. Paketdetails
- evtl. OCL verwenden
- neue Klassen und Methoden erklären
- evtl. Zustandsdiagramm (z.B. später: Roboter entweder im Taxi- oder im Krankentransport-Zustand)

### 9. Produkteinsatz
- Verteilungsdiagramm mit Komponenten

### 10. Anhang
#### 10.1. Glossar
