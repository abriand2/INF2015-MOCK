Labo 07 : Mock Objects
=====

Objectifs
* Expérimenter l'injection de dépendances
* Expérimenter les mock objects

L'objectif de cette démonstration est d'approfondir l'expérimentation sur les tests unitaires. 
Comme vous l'avez vu en classe, un bon test unitaire ne doit pas nécessiter des ressources externes. 
Pour tester des fonctionnalités qui font des accès de ce genre, il faut utiliser des **Mock objects**.

* * *

Commencez par récupérer le projet suivant : []()

### Exercice 1 : Modifier la structure de la classe _Cours_ pour qu'on puisse lui injecter une dépendance

Nous voulons tester la méthode _envoyerCourrielMembres_ de la classe Membre. Cette méthode envoi un courriel à tous les membres du cours. 
Cependant, cette méthode envoi réellement un courriel aux membre du cours!! L'envoi de courriel implique l'utilisation d'un environnement et un accès à des ressources externes, 
nous voulons donc éviter d'envoyer réellement des courriels, mais nous voulons tester la méthode _envoyerCourrielMembres_.

Comme nous voudrons "mocker" la classe **MailSender**, nous devons extraire cette composante de la classe _Cours_.
Au lieu que l'objet _Cours_ instancie à l'interne  un MailSender, nous allons lui passer au constructeur un objet MailSender qu'il utilisera par la suite.
*C'est le principe de l'injection de dépendance.*

1- Modifier le constructeur pour qu'il accepte un 3e paramètre de type _MailSender_.
2- Modifier le code du constructeur pour qu'on assigne à la variable interne _mailSender_ l'objet _MailSender_ passé en paramètre.

Nous venons de créer une injection de dépendance pour la classe _Cours_


### Exercice 2 : Créer un mock pour tester la fonction _envoyerCourrielMembres_ de la classe _Cours_

1- Créez une classe qui hérite de la classe _MailSender_
2- Comme on veut simuler l'envoi de courriel, nous devrons stoquer d'une certaine façon les courriels "envoyés"
    * Créez une variable dans votre mock qui stoque les courriels envoyés.
    * Vous pouvez vous y aider en créant une classe Courriel avec laquelle vous instancierez les courriels et vous les stockerez dans votre collection de courriel.

    
### Exercice 3 : Créer quelques tests qui utilisent le mock.
Le but de cette manipulation était de pouvoir créer des tests unitaires plausibles sur la fonction _envoyerCourrielMembres_.

* Creez quelques tests sur la fonction _envoyerCourrielMembres_ en utilisant l'objet Mock créé précédemment.
    * Exemple de test : ajouter quelques membres au cours et vérifier que le mock a envoyé le bon nombre de courriel.
    

### Exercice 4 : Mocker en utilisant un _wrapper_
Il est possible que la classe que l'on veut mocker ne nous permette pas de l'instancier sans faire un accès à des données. C'est le cas pour la classe
_FileWriter_. En effet, comme le _FileWriter_ crée impérativement un fichier dans chacun de ses constructeurs, il faut contourner ça en l'englobant dans un wrapper.

Le FileWriterWrapper prend un filewriter en paramètre et appelle la fonction Write lorsqu'on apelle la fonction Write du FileWriterWrapper.

* Examinez la classe _FileWriterWrapper_ et créez un Mock object qui hérite du _FileWriterWrapper_
    * Votre mock doit donc hériter du FileWriterWrapper et doit redéfinir la méthode write.
    * Si l'on redéfinit la méthode write, la classe parente n'utilisera pas le FileWriter interne. On peut donc passer la valeur null lors de l'appel du constructeur de la classe parent.
    * Comme on veut garder traces de ce que le mock va écrire, on peut stoquer ce qu'il écrira dans un string que l'on gardera en variable protégée dans le mock.
* Nous voulons tester la fonction _genererRapport_ de la classe **Rapport**. Comme vous pouvez le voir, nous avons déjà injecter la dépendance du FileWriterWrapper dans la classe
**Rapport**. Il ne vous reste qu'à rédiger quelques tests sur la fonction en utilisant le mock précédemment créé.
