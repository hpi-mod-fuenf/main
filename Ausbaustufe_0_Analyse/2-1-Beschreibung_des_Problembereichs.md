# 2. Produkteinsatz
## 2.1. Beschreibung des Problembereich
<img src="/images/Problembereich.svg">
Der Problembereich lässt sich für diese Analysestufe in vier Punkte einteilen, um eine Gesamtkoordination effizient zu gestalten:

1. Zuallererst muss das automatische Fahren im zweidimensionalen Koordinatensystem zu einem angegebenen Zielpunkt fehlerfrei möglich sein. Ebenfalls steht eine manuelle Steuerung zur Verfügung, um unerwarteten Ereignissen zu begegnen, die allerdings wiederum sinnvoll in das Gesamtsystem integriert werden muss.<br>
<img src="/images/grafikZumProblembereich1.jpg" width="200">

2. Als zweite Herausforderung gilt es einen möglichst reibungs- und unterbrechungslosen Batteriebetrieb zu garantieren, um zeitlich vorrauschendes Fahren zu ermöglichen. Im Falle eines niedrigen Batteriestands also unverzüglich an eine Ladestation anzudocken und aufzuladen, beziehungsweise längere Fahrten nicht anzutreten, die den Batteriestand gefährden würden.<br>
<img src="/images/grafikZumProblembereich3.jpg" width="200">

3. Im dritten Punkt geht es darum den Schaden von Kollisionen zu minimieren; wie diese erkannt, wie auf sie reagiert wird und diese Kollisionen durch vorrauschendes Umfahren von Objekten verhindert werden können. Dies schließt sowohl bewegliche Objekte als auch unbewegliche Objekte mit ein. <br>
<img src="/images/grafikZumProblembereich2.jpg" width="200">

Daran anknüpfend wird mit folgenden Annahmen gearbeitet:

1.	Zur Vereinfachung des Fahrverhalten muss jedes Zielobjekt physisch erreichbar sein. Ziele sind dementsprechend keine Hindernisse, das gleiche gilt für Ladestationen.<br>
2.	Roboter können autark vom Server agieren, damit ihre Ziele bestimmen und eine Ladestation anfahren.<br>
3.	Bei den beweglichen Objekten wird davon ausgegangen, dass es sich im Verkehrsbetrieb ausschließlich um andere Roboter handelt. Für die unbeweglichen Objekte ist es notwendig, dass ihre Position von vornerein bekannt ist und sie unverändert bleibt.<br>




