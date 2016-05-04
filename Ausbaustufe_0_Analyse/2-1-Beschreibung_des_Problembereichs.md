# 2. Produkteinsatz
Der Problembereich lässt sich für diese Analysestufe in vier Punkte einteilen, um eine Gesamtkoordination effizient zu gestalten:

1. Zuallererst muss das automatische Fahren im zweidimensionalen Koordinatensystem zu einem angegebenen Zielpunkt fehlerfrei möglich sein. ***Zur Vereinfachung wird das System im Folgenden mit der Annahme arbeiten, dass jeder Zielpunkt physisch erreichbar ist.*** Ebenfalls steht eine manuelle Steuerung zur Verfügung, um unerwarteten Ereignissen zu begegnen, die allerdings wiederum sinnvoll in das Gesamtsystem integriert werden muss.<br>
<img src="/images/grafikZumProblembereich1.jpg" width="200">

2. Als zweite Herausforderung gilt es einen möglichst reibungs- und unterbrechungslosen Batteriebetrieb zu garantieren, um zeitlich vorrauschendes Fahren zu ermöglichen.<br>
<img src="/images/grafikZumProblembereich3.jpg" width="200">

3. Im dritten Punkt geht es darum den Schaden von Kollisionen zu minimieren; wie diese erkannt und wie auf sie reagiert werden soll.<br>
<img src="/images/grafikZumProblembereich2.jpg" width="200">

4. Und viertens, natürlich wie diese Kollisionen durch vorrauschendes Umfahren von Objekten verhindert werden. Dies schließt sowohl bewegliche Objekte als auch unbewegliche Objekte mit ein.
***Bei den beweglichen Objekten wird davon ausgegangen, dass es sich im Verkehrsbetrieb ausschließlich um andere Roboter handelt. Für die unbeweglichen Objekte ist es notwendig, dass ihre Position von vornerein bekannt ist und sie unverändert bleiben***

## 2.1. Beschreibung des Problembereich
<img src="/images/Problembereich.svg">
