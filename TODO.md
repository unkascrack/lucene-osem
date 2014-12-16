Apuntes posible framework lucene-orm:

    Crear repository googlecode o github (tiene más salida que googlecode)
    Wiki

Configuración

    crear configuración programática, más adelante mediante XML
    configuración permitir configurar todos los distintos índices que se generarán, no sólo uno como en compass
    configuración, poder definir valores globales (defecto) para todos los índices: versión lucene, analizador,...
    posibilidad de configuración "real-time-search" o "defecto" creación/búsqueda de los índices lucene.

    Ejemplo posible de configuración en XML, también válido para programatica:
    <configuracion>

        <!-- datos configuraciones globales y comunes a todos si no se sobrescribe por el índice -->

        <analyzer ...>

        <version-lucene ...>

        <tamaño maximo almacenar (store) de los índices>

        ...

        <!-- listados de indices a crear, el atributo id/name obligatorio para poder referenciar -->

        <indice id/name="...">

            <!-- obligatorio directory -->

            <directory ...>

            <!-- obligatorio mapper, clases con anotaciones -->

            <mapper class="...">

            <mapper class="...">

            ...

            <!-- opcional optimizer con configuración de cuando y como se debe ejecutar -->

            <optimizer scheduler="..." ...>

            <!-- se puede sobreescribir configuracion -->

            <analyzer ...>

            <version-lucene ...>
            <tamaño maximo almacenar de los índices>

        </indice>

        <indice id/name="...">

            ....

        </indice>

        <indice id/name="...">

            ....

        </indice>

        ....

    </configuracion>

Anotaciones

    Crear anotaciones para los beans que se desean maperar: @DocumentIndex @FieldIndex, @FieldIdIndex, @DocumentMetada, @FieldMetadata, 
    Permitir añadir configuración para las anotaciones: Tipo (text, int, long, double, date,..)  Store, Index, ...
    Crear anotación para poder convertir campo a valor indexable, @FieldConverter
    Poder definir que campos forman parte de la búsqueda global del índice (default/catchall/all) y cual se excluye, y si se crea un nuevo índice para estos valores o se realiza búsqueda en múltiples campos.

    Ejemplo:
    @DocumentIndex(analyzer="...")
    @DocumentMetadata(....)
    public class DocumentBean {

        @FieldIdIndex(index=NO_ANALYZE_NO_NORM, store=YES)

        private Long id;

        //default: type:TEXT, index=YES, store=NO, searchAll=NO

        @FieldIndex(type=DOUBLE)

        private Double dd;

        @FieldIndex(index=YES, store=NO, searchAll=YES)

        private String tt;

        @FieldIndex(searchAll=NO)

        @FieldConverter(class="...")

        private byte[] content;

        @FieldIndex(store=YES, searchAll=YES)

        public String getComplexMethod() {

            return ...

        }

        //metodos getter/setter

    }

Manager

    El manager deberá ser responsable de gestionar los writer y reader abiertos de todos los índices
    Threadsafe
    Crear un clase manager similar a JPA: persist, delete, find, ... para trabajar con el índice adecuado
    El manager debería ser capaz de saber con que índice o índices se trabaja por el ID definido para el índice de la configuración.
    Estudiar tema de transactions

Query

    Crear wrapper de la clase de Lucene para simplificar (QueryParse)
    Permitir trabajar tanto con consultas puras de Lucene (Query) como las generadas con el framework

Spring

    A futuro poder trabajar con Spring

Bibliografía/Links

    Lucene (http://lucene.apache.org/core/)
    Compass (http://www.compass-project.org)
    LukeMapper (https://github.com/lelandrichardson/LukeMapper)
    Lucinq (https://github.com/cardinal252/Lucinq)
    Hibernate Search (http://hibernate.org/search/)
    Ejemplo lucene orm (http://www.codecommit.com/blog/java/an-easier-java-orm-indexing)
    ActiveObjects https://activeobjects.java.net/0.8.2/
    ElasticSearch-OSEM https://github.com/kzwang/elasticsearch-osem


NOTAS:

Create Mapping:

    Client client = nodeBuilder().node().client();
    ElasticSearchIndexer indexer = new ElasticSearchIndexer(client, indexName);
    indexer.createMapping(Tweet.class);

Index Object:

    Tweet tweet = new Tweet();
    ...
    indexer.index(tweet);

Delete Object:

    Tweet tweet = ...;
    indexer.delete(tweet);

Get Object from index:

    ElasticSearchSearcher searcher = new ElasticSearchSearcherImpl(client, indexName);
    Tweet tweet = searcher.getById(Tweet.class, tweet.getId().toString());

Search Object:

    List<Tweet> searchResult = searcher.search(Tweet.class, QueryBuilders.matchAllQuery(),
