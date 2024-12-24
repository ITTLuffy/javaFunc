Create un progetto Java in grado di gestire il seguente mini-gioco.
Un vettore di lunghezza a scelta è riempito con delle palline di 4 colori diversi (rappresentate da lettere o numeri), e queste palline possono essere rimosse con una certa logica. 
Il gioco consiste nel rimuovere una pallina in una posizione del vettore scelta dall'utente, la quale provoca il compattamento delle restanti che "cadono" riempiendo lo spazio. Se due palline dello stesso colore si toccano, tutte le palline adiacenti dello stesso colore vengono rimosse in blocco, provocando una nuova "esplosione" e successivo compattamento, con un eventuale effetto a catena.

Lo scopo del giocatore è rimuovere il maggior numero di sfere in una sola mossa.

Qualche esempio di funzione utile:
- riempiVettore(): se il vettore non è pieno, generare casualmente delle palline che andranno a riempire gli spazi vuoti, tenendo conto che esistono solo 4 colori possibili.
- togliSfera(): data una posizione, rimuove la pallina indicata, tenendo conto di eventuali collisioni e rimozioni a catena. Le celle rimaste vuote dovranno contenere un valore "nullo", ad esempio zero.
- simulaMossa(): data una posizione, calcola il numero di palline che verrebbero rimosse togliendo la pallina indicata
- mossaMigliore(): restituisce la posizione della pallina da rimuovere che provocherebbe il maggior numero di punti

Extra:
Il gioco è competitivo, implementare un secondo giocatore e un sistema a turni
