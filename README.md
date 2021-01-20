# Struttura 

Il programma è strutturato sulla base delle seguenti macro componenti
- controllers, espongono le api, definiscono le routes, implementano le logiche di controllo dei parametri, coordinano i servizi che si occupano delle elaborazioni sulla base dei parametri ricevuti
- models "ow", sono i modelli per la gestione delle risposte di openweather, gli attributi delle classi hanno la stessa struttura delle risposte JSON di Openweather, le classi sono nidificate tra loro come le strutture del JSON.
               con questa struttura Spring riesce a valorizzare automaticamente le proprietà delle classi in base al JSON ricevuto da Opwnweather
- models prefisso "entity", sono le classi che consentono un accesso semplificato al database H2 tramite i servizi Repository 
- models, sono le classi utilizzate dai servizi interni di elaborazione
- services, sono le classi che definiscono le logiche di funzionamento del servizio
	* OpenWeatherClient, si occupa di eseguire le chiamate alle API di Openweather
	* Configuration, carica la configurazione del progetto da config.json
	* Repository, classi che implementano le operazioni base sul db H2 (operazioni CRUD: Create, read, update and delete)
	* OpenWeatherTask, esegue le operazioni in base alla pianificazione configurata
	* DataService, invoca il servizio di Forecast e del meteo corrente di Openweather, elabora i dati e prepara le risposta per l'utente
	* StatsService, analizza i dati storici e fa una valutazione dell'affidabilità delle previsioni, prepara la risposta per il client.


# Funzionamento

In fase di avvio il programma legge il file di configurazione e carica in database l'elenco delle città presenti nel file.
Se il file di configurazione è corretto viene avviato il server web e il processo che si occupa di eseguire i Task pianificati.
Il Task, con cadenza di 30 minuti, per ogni città presente in database (in base al config.json) esegue le chiamate ad OpenWeather per registrare il meteo corrente e le previsioni a 5 giorni.

Le Api in ascolto consentono all'utente di richiedere il memeo corrente e le previsioni per una qualsiasi città: la richiesta viene infatti inoltrata a Openweather e la risposta rielabotrata.
Alla prima interrogazione di una nuova città, questa viene inserita nel database del monitoraggio, il task si occupa quindi di registrare i dati per tutte le città presenti nel file di configurazione e per tutte le nuove città interrogate dagli utenti che accedono ai servizi esposti.  

I dati presenti in DB vengono utilizzati per determinare l'affidabilità del servizio meteo confrontando la precisione della stima fornita da OpenWeather rispetto al meteo reale registrato nei giorni successivi a quelli della previsione.


# Componenti e tecniche utilizzate

## Spring
Spring consente di "annotare" i componenti tramite delle parole chiave che identificano lo scopo e il funzionamento di base di una classe.
I componenti Spring derivano dal componente base @Componet e possono essere di tipo @Component, @Services ecc questo identificativo è necessario affinchè Spring possa tipizzare la classe
Un oggetto di tipo @Component può utilizzare al suo interno degli oggetti auto istanziati, questi oggetti vanno marcati con l'attributo @Autowired, in questo modo Spring capisce che deve istanziare la classe automaticamente e sarà disponibile all'interno della classe stessa. 

Rif: https://docs.spring.io/spring-framework

* @EnableScheduling, Enables Spring's scheduled task execution capability
* @EntityScan, Configures the base packages used by auto-configuration when scanning for entity classes (esegue la ricerca delle classi di tipo Entity)
* @Autowired, Marks a constructor, field, setter method, or config method as to be autowired by Spring's dependency injection facilities
* @PostConstruct, 

* @RestController, /docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html
* @GetMapping, Annotation for mapping HTTP GET requests onto specific handler methods
* @ResponseBody, Annotation that indicates a method return value should be bound to the web response body 

## Pianificazione
Spring fornisce una gestione automatica per la pianificazione dei processi, è infatti sufficiente:
- aggiungere il decorator @EnableScheduling nell'applicazione principale, indica a spring di avviare il processo per l'esecuzione dei task pianificati
- aggiungere @Component con metodo decorato con la cadenza di esecuzione @Scheduled(fixedRate = 5000)

Rif: 
* https://spring.io/guides/gs/scheduling-tasks/

## Singleton
Il singleton rappresenta un tipo particolare di classe che garantisce che soltanto un’unica istanza della classe stessa possa essere creata all’interno di un programma.


## Database
Nel progetto viene utilizzato il database H2 (in realtà nato per fornire supporto ai test automatici).
Questo database in genere viene eseguito in memoria e ricreato ad ogni avvio dell'applicazione.
Per simulare il comportamento di un ambiene reale, è stata modificata la configurazione application.properties direttando il salvataggio del database su file:
```
- da -> spring.datasource.url=jdbc:h2:mem:~/test
- a -> spring.datasource.url=jdbc:h2:file:./repository
```
Al riavvio i dati e la struttura del database risultano persistenti

Rif:
* https://howtodoinjava.com/spring-boot2/h2-database-example/
* https://howtodoinjava.com/spring-boot2/hibernate-configuration-example/







<img src="https://github.com/AlessandroStella1/Esameprogrammazione/blob/main/processo-richiesta-meteo.png?raw=true">





<img src="https://github.com/AlessandroStella1/Esameprogrammazione/blob/main/processo-task.png?raw=true">





<img src="https://github.com/AlessandroStella1/Esameprogrammazione/blob/main/processo-utente.png?raw=true">






                    
## Esempio tabella output
                   
ID | CITY_ID | CITY_NAME | DATE | DATE_EPOCH | FEELS_LIKE | HUMIDITY | PRESSURE | TEMP_MAX | TEMP_MIN | TEMPERATURE | WEATHER
---|----------|--------------|--------|-------------|------------|---------|---------|--------|--------|--------|--
1 | 2177915 | ANCONA | 2021-01-14 18:00:00| 1610641815 | 8.09000015258789 | 85 | 1007 | 10.5600004196167 | 8.890000343322754 | 9.8100004196167| Clear
2 | 6127261 | ROMA | 2021-01-14 18:00:00 | 1610641816 | -14.25| 63 | 1024 | -5.0 | -5.0 | -5.0| Clouds
3 | 2525068 | Catania | 2021-01-14 18:00:00 | 1610645005 | 9.359999656677246 | 77 | 1010 | 15.0 | 12.779999732971191 | 13.699999809265137 | Clouds

## Software utilizzati
* #### [IDE Eclipse](https://www.eclipse.org/) - per lo sviluppo e la scrittura dell'intero codice del programma
* #### [Framework Spring](https://spring.io/projects/spring-framework) - framework concepito per lo sviluppo di applicazioni enterprise
* #### [Maven](https://maven.apache.org/) - per un'organizzazione efficiente e una semplificazione del progetto in Java
* #### [Diagrams.Net](https://www.diagrams.net) - per creare e modellare i diagrammi UML
* #### [JUnit](https://junit.org/junit5/) - per svolgere gli Unit Test
* #### [OpenWeather](https://openweathermap.org/forecast5) - per ottenere le informazioni metereologiche 

## Autori & contributo
[Matteo Albanesi](https://github.com/MatteoAlbanesi) - 50%                                                             
[Alessandro Stella](https://github.com/AlessandroStella1) - 50%
