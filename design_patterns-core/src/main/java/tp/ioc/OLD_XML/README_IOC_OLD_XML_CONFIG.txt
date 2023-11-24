Au début des années 2000, l'injection de dépendance de Spring était souvent configuré en xml
Et les anciennes versions de ce tp étaient en java8 avec une configuration IOC/injection_dépendance en xml (pour faire comme le vrai spring).
Aujourd'hui , Spring 4,5,6 ne se configurent quasiment plus en XML
D'autre part, Java11 et java17 ne comportent plus certaines classes techniques liées à XML (jaxb2)
------------
Les versions récentes de ce tps vont donc exploiter une configuration IOC moderne sans XML mais à base d'annotations java