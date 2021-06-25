Huffman – kód implementáció
Szöveg beolvasás, feldolgozás:
A szöveg beolvasása konzolról történik, kettő ArrayList-be, az egyik listában [listOfChar] a karaktereket tároljuk el,
 illetve egy változóban [n] azt, hogy hányféle karaktert olvastunk be, továbbá a másik listában [listOfFreqs] tároljuk azt, 
hogy az egyes karakterek milyen gyakran fordulnak elő.

A Huffman fa felépítése
Egy for ciklus segítségével létrehozunk minden karakterhez egy csúcsot (node típusú objektumot, 
mivel a Node osztály tartalmazza az adott fa csúcsait) amit egy minimum prioritásos sorba [pQ] helyezünk gyakoriság alapján, 
a gyakoribb elemnek alacsonyabb prioritása lesz. Az összehasonlításban a MyComparator osztályt használjuk.
A while ciklusban kiveszünk két csúcsot (az első és második minimum elemet) és létrehozunk nekik egy szülő csúcsot, 
melynek kulcsa a két kivett csúcs gyakoriságának összege. Az első elem a szülő baloldali gyereke, a második a jobboldali gyereke lesz,
az adott szülőelem pedig az adott gyökércsúcs. A szülőcsúcsot a kulcsával belehelyezzük a prioritásos sorunkba, 
és ezt ismételjük addig, amíg a sorunkban 1-nél több elem van.

Kiíratás
A printCode metódusban címkézzük fel az egyes szülő-gyerek éleket. Ha a vizsgált csúcs üres,
 akkor nullával tér vissza (például ha csak szóközöket adunk meg). 
A metódus rekurzív hívásával, amíg a karakter bal és jobb csúcsa nem üres (nem null) addig az adott karakter kódját hozzuk létre
(konkatenáljuk a karakter kódjához a ’0’-t a bal részfájához, az ’1’-et a jobbhoz). 
A végén kiíratjuk a kódtáblát (azaz a karaktert és a hozzá tartozó kódot), és egy HashMap-be [huffmanCode] helyezzük a karaktert
és a kódját, a végén pedig újra átfutunk eredeti szövegen és kiírjuk kódolt formáját.
