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

Un saludo,
Carlos Alonso González Este correo electrónico y, en su caso, cualquier fichero anexo al mismo, contiene información de carácter confidencial exclusivamente dirigida a su destinatario o destinatarios. Si no es vd. el destinatario indicado, queda notificado que la lectura, utilización, divulgación y/o copia sin autorización está prohibida en virtud de la legislación vigente. En el caso de haber recibido este correo electrónico por error, se ruega notificar inmediatamente esta circunstancia mediante reenvío a la dirección electrónica del remitente.
Evite imprimir este mensaje si no es estrictamente necesario.

This email and any file attached to it (when applicable) contain(s) confidential information that is exclusively addressed to its recipient(s). If you are not the indicated recipient, you are informed that reading, using, disseminating and/or copying it without authorisation is forbidden in accordance with the legislation in effect. If you have received this email by mistake, please immediately notify the sender of the situation by resending it to their email address.
Avoid printing this message if it is not absolutely necessary.
