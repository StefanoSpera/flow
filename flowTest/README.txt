Pregetto di test della libreria flow.jar

1 - Installare Maven

2 - Dopo aver importato i progetti Flow e FlowTest in eclipse
	in Flow è presente il jar sotto la cartella jar
    aggiornare il pom -> Maven -> update Project

3 - Eseguire il run come classe java della classe FlowTestApplication

4 - l'applicazione sarà disponibile all'indirizzo 
    http://localhost:<porta del server nel mio caso è 8080>/flowTest?passo=[...]&id=[...]&data=[...]

5 - classe di partenza per eseguire debug RequestController

	parametri passo,id,data in formato dd/MM/yyyy
    
    valori passi e id implementati:
    passo: 
    	PassoA
    	PassoB
    	PassoC
    	PassoD
    	PassoD1
    id:
    	1
    	2    
    data:
    	check maggiorenne
