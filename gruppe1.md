# 1. Zielbestimmung
Die Aufgabe des Projektteams ist es ein System zu entwickeln, das selbstfahrender Roboter in einer Stadt der Zukunft koordiniert. In dieser Stadt existieren keine Straßen mehr – umso komplexer wird der Prozess das Navigationsverhalten der Roboter mit den richtigen Parametern einzustellen und zu modellieren. Die Voraussetzungen und Spezifikation dafür zu erfassen ist Ziel dieser Analyse – die sich insbesondere mit dem Fahr- und dem Aufladevorgang der Roboter und ihren Manövrierfähigkeiten gegenüber Hindernissen auseinandersetzt.

Im weiteren Verlauf des Projektes sollen die Roboter ebenfalls Krankentransporter und schließlich Bestandteil eines Taxiservicedienstes werden. Alle hier getroffenen Annahmen, Modellierungen und Implementierungen könnten damit im Rahmen der späteren Anwendungen revidiert werden.

Als Ausgangspunkt stellt das Unternehmen eine unbegrenzte Anzahl von Robotern zur Verfügung, die mit Aktoren, Sensoren und einem Ortungsgerat ausgestattet sind, und im Wechselspiel mit einem Server agieren.

Das Primärziel des Projektes ist es dabei ein möglichst effizientes Transportsystem zu entwickeln, um für alle Verkehrsbegebenheiten im Großraum einer Zukunftsstadt vorbereitet zu sein. Davon würde die Menschheit nachhaltig profitieren, indem Verkehrsunfällen, Staus und die zeitliche Inanspruchnahme des Fahrens auf ein Minimum reduziert werden. Allerdings wird das System zuerst vor einige Herausforderungen im Fahrvorgang gestellt, mit denen sich die folgenden Kapitel beschäftigen.

 Bei erfolgreicher Lösung dieser Probleme, könnte langfristig ein einzelnes Unternehmen die gesamte Transportinfrastruktur einer Großstadt Übernehmen.  Das System soll von sich aus selbstständig und vollständig autonom agieren. Abgesehen davon Sicherheitsregeln einzuhalten, sollten damit keine Vorkenntnisse für die Fahrt mit den Robotern notwendig sein, um den Personennahvekehr für die breite Masse zu öffnen.
# 2. Produkteinsatz
Der Problembereich lässt sich für diese Analysestufe in vier Punkte einteilen, um eine Gesamtkoordination effizient zu gestalten:
1. Zuallererst muss das automatische Fahren im zweidimensionalen Koordinatensystem zu einem angegebenen Zielpunkt fehlerfrei möglich sein. ***Zur Vereinfachung wird das System im Folgenden mit der Annahme arbeiten, dass jeder Zielpunkt physisch erreichbar ist.*** Ebenfalls steht eine manuelle Steuerung zur Verfügung, um unerwarteten Ereignissen zu begegnen, die allerdings wiederum sinnvoll in das Gesamtsystem integriert werden muss.
<img src="/images/grafikZumProblembereich1.jpg" width="200">

2. Als zweite Herausforderung gilt es einen möglichst reibungs- und unterbrechungslosen Batteriebetrieb zu garantieren, um zeitlich vorrauschendes Fahren zu ermöglichen.

3. Im dritten Punkt geht es darum den Schaden von Kollisionen zu minimieren; wie diese erkannt und wie auf sie reagiert werden soll.<br>
<img src="/images/grafikZumProblembereich2.jpg" width="200">

4. Und viertens, natürlich wie diese Kollisionen durch vorrauschendes Umfahren von Objekten verhindert werden. Dies schließt sowohl bewegliche Objekte als auch unbewegliche Objekte mit ein.
***Bei den beweglichen Objekten wird davon ausgegangen, dass es sich im Verkehrsbetrieb ausschließlich um andere Roboter handelt. Für die unbeweglichen Objekte ist es notwendig, dass ihre Position von vornerein bekannt ist und sie unverändert bleiben***
## 2.1. Beschreibung des Problembereich
![Modell des Problembereichs](/images/Problembereich.svg)
## 2.2. Glossar
## 2.3. Modell des Problembereichs
