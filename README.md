# F&E-Projekt

Willkommen im F&E-Projekt-Repository! Dieses Projekt zielt darauf ab, verschiedene Ansätze zur Abrufung von Wetterdaten für eine vom Benutzer angegebene Stadt zu demonstrieren und die Auswirkungen von blockierenden Methoden, asynchroner Programmierung in Java und der Verwendung von Virtual Threads zu verdeutlichen. Wir untersuchen auch, wie diese Ansätze eine hohe Anzahl von Aufgaben bewältigen können, indem wir den Speicherverbrauch und die Ausführungszeit vergleichen.

## Übersicht

Das F&E-Projekt ist eine Anwendung, die dazu dient, Wetterdaten für eine benutzerdefinierte Stadt abzurufen. Es zeigt die folgenden Schlüsselaspekte:

- **Blockierende Methoden**: Die anfängliche Version der Anwendung zeigt die Nachteile der Verwendung von blockierenden Methoden auf, die zu einer geringen CPU-Auslastung und einer ineffizienten Ressourcennutzung führen können.

- **Asynchrone Programmierung**: In einer nachfolgenden Version der App wird die asynchrone Programmierung in Java verwendet, um nicht-blockierende Ausführung und eine bessere Ressourcennutzung zu ermöglichen.

- **Virtual Threads**: In einer weiteren Iteration erkunden wir den Einsatz von Virtual Threads und zeigen, wie sie die Aufgaben effizient bewältigen können. Dieser Abschnitt geht auch auf die inneren Abläufe von Virtual Threads ein.

- **Leistungsanalyse**: Das Projekt bietet Tools zur Messung und Vergleich des Speicherverbrauchs und der Ausführungszeit zwischen den verschiedenen Ansätzen, um Benutzern zu helfen, ihre relativen Stärken und Schwächen zu verstehen.

## Erste Schritte

Um mit dem F&E-Projekt zu beginnen, befolgen Sie diese Schritte:

1. **Repository klonen**: Klonen Sie dieses GitHub-Repository auf Ihre lokale Maschine mit dem folgenden Befehl:

   ```bash
   git clone https://github.com/your-username/F&E-Projekt.git

    Erstellen und Ausführen: Navigieren Sie zum Projektverzeichnis und befolgen Sie die Anweisungen in der README-Datei oder der Dokumentation jeder Version, um die entsprechende Anwendungsversion zu erstellen und auszuführen.

    Erkunden und Analysieren: Führen Sie Tests durch, experimentieren Sie mit verschiedenen Städten und erkunden Sie, wie sich die Anwendung unter verschiedenen Belastungen verhält. Verwenden Sie die bereitgestellten Tools zur Leistungsanalyse.

Versionen

    blocking-methods: Die erste Version der App zeigt die Probleme, die mit blockierenden Methoden verbunden sind.

    async-programming: Die asynchrone Version der App demonstriert die nicht-blockierende Ausführung.

    virtual-threads: Die Version mit Virtual Threads veranschaulicht die Vorteile von Virtual Threads bei der effizienten Bewältigung von Aufgaben.

Leistungsanalyse

Jede Version enthält Tools zur Leistungsanalyse, die es Ihnen ermöglichen, Folgendes zu messen und zu vergleichen:

    Speicherverbrauch: Überwachen Sie, wie viel Speicher jede Version unter verschiedenen Szenarien verbraucht.

    Ausführungszeit: Messen Sie die Zeit, die jede Version benötigt, um Aufgaben abzuschließen.




Dieses Projekt steht unter der MIT-Lizenz:)


Vielen Dank für Ihr Interesse am F&E-Projekt! Viel Spaß beim Programmieren!
